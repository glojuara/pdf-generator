package br.com.api4dev.pdfgenerator.services.shared.impl;

import br.com.api4dev.pdfgenerator.services.shared.PdfParserService;
import com.lowagie.text.DocumentException;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfParserServiceImpl implements PdfParserService {
    @Override
    public byte[] parse(String content) throws IOException, DocumentException {

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(content);
            renderer.layout();
            renderer.createPDF(baos);
            return baos.toByteArray();
        }

    }
}
