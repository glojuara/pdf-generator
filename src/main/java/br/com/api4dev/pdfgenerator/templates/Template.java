package br.com.api4dev.pdfgenerator.templates;

import java.util.Map;

public interface Template<T> {

    String getPath();
    Map<String, String> getReplacements(T target);

    default boolean shouldSanitize() {
        return false;
    }

}
