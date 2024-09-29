package br.com.api4dev.pdfgenerator.templates;

import br.com.api4dev.pdfgenerator.models.book.BookCover;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BookCoverTemplate implements Template<BookCover> {
    @Override
    public String getPath() {
        return "templates/book/book-cover.html";
    }

    @Override
    public Map<String, String> getReplacements(BookCover bookCover) {
        Map<String, String> replacements = new HashMap<>();
        replacements.put("title", bookCover.title());
        replacements.put("subtitle", bookCover.subtitle());
        replacements.put("author", bookCover.author());
        replacements.put("publisher", bookCover.publisher());
        return replacements;
    }

    @Override
    public boolean shouldSanitize() {
        return true;
    }
}
