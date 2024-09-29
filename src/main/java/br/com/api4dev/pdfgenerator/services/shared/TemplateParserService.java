package br.com.api4dev.pdfgenerator.services.shared;

import br.com.api4dev.pdfgenerator.templates.Template;

import java.io.IOException;

public interface TemplateParserService {
    <T> String parse(Template<T> template, T target);
}
