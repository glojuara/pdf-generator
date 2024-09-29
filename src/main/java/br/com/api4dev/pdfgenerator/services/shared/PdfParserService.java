package br.com.api4dev.pdfgenerator.services.shared;

import com.lowagie.text.DocumentException;

import java.io.IOException;

public interface PdfParserService {

    byte[] parse(String content) throws IOException, DocumentException;

}
