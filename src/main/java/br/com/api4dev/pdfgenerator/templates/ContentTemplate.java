package br.com.api4dev.pdfgenerator.templates;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ContentTemplate implements Template<String> {
    @Override
    public String getPath() {
        return "templates/book/base.html";
    }

    @Override
    public Map<String, String> getReplacements(String content) {
        Map<String, String> replacements = new HashMap<>();
        replacements.put("content", content);
        return replacements;
    }
}
