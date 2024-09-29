package br.com.api4dev.pdfgenerator.services.shared;

import java.io.IOException;

public interface TemplateLoaderService {

    String load(String templatePath) throws IOException;

}
