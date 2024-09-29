package br.com.api4dev.pdfgenerator.services.shared.impl;

import br.com.api4dev.pdfgenerator.services.shared.TemplateLoaderService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
public class TemplateLoaderServiceImpl implements TemplateLoaderService {
    @Override
    public String load(String templatePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(templatePath);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }
}
