package br.com.api4dev.pdfgenerator.services.shared.impl;

import br.com.api4dev.pdfgenerator.services.shared.HtmlSanitizerService;
import org.springframework.stereotype.Service;

@Service
public class HtmlSanitizerServiceImpl implements HtmlSanitizerService {

    public String sanitize(String input) {
        if (input == null) {
            return null;
        }

        StringBuilder sanitized = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (isSpecialCharacter(c)) {
                sanitized.append("&#").append((int) c).append(';');
            } else {
                sanitized.append(c);
            }
        }

        return sanitized.toString();
    }

    private static boolean isSpecialCharacter(char c) {
        return !Character.isLetterOrDigit(c) && !Character.isWhitespace(c);
    }

}

