package br.com.api4dev.pdfgenerator.services.shared.impl;

import br.com.api4dev.pdfgenerator.services.shared.HtmlSanitizerService;
import br.com.api4dev.pdfgenerator.services.shared.TemplateLoaderService;
import br.com.api4dev.pdfgenerator.services.shared.TemplateParserService;
import br.com.api4dev.pdfgenerator.templates.Template;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TemplateParserServiceImpl implements TemplateParserService {


    private final TemplateLoaderService templateLoaderService;
    private final HtmlSanitizerService htmlSanitizerService;

    public TemplateParserServiceImpl(TemplateLoaderService templateLoaderService, HtmlSanitizerService htmlSanitizerService) {
        this.templateLoaderService = templateLoaderService;
        this.htmlSanitizerService = htmlSanitizerService;
    }

    @Override
    public <T> String parse(final Template<T> template, final T target) {

        try {
            final String content = templateLoaderService.load(template.getPath());

            final Pattern pattern = Pattern.compile("\\#\\{(\\w+)}");
            final Matcher matcher = pattern.matcher(content);
            final StringBuilder result = new StringBuilder();

            while (matcher.find()) {
                final String placeholder = matcher.group(1);
                final String replacement = template.getReplacements(target).getOrDefault(placeholder, matcher.group(0));
                matcher.appendReplacement(result, template.shouldSanitize() ? htmlSanitizerService.sanitize(replacement) : replacement);
            }

            matcher.appendTail(result);

            return result.toString();

        } catch (IOException ex) {
            throw new RuntimeException("Erro ao carregar template", ex);

        }

    }
}
