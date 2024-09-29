package br.com.api4dev.pdfgenerator.services.book.impl;

import br.com.api4dev.pdfgenerator.models.book.BookCover;
import br.com.api4dev.pdfgenerator.services.book.BookCoversGeneratorService;
import br.com.api4dev.pdfgenerator.services.shared.PdfParserService;
import br.com.api4dev.pdfgenerator.services.shared.TemplateParserService;
import br.com.api4dev.pdfgenerator.templates.Template;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCoversGeneratorServiceImpl implements BookCoversGeneratorService {

    private final TemplateParserService templateParserService;
    private final PdfParserService pdfParserService;
    private final Template<String> contentTemplate;
    private final Template<BookCover> bookCoverTemplate;


    public BookCoversGeneratorServiceImpl(TemplateParserService templateParserService,
                                          PdfParserService pdfParserService,
                                          Template<String> contentTemplate,
                                          Template<BookCover> bookCoverTemplate) {
        this.templateParserService = templateParserService;
        this.pdfParserService = pdfParserService;
        this.contentTemplate = contentTemplate;
        this.bookCoverTemplate = bookCoverTemplate;
    }

    @Override
    public byte[] generatePdf(List<BookCover> bookCovers)  {

        try {

            StringBuilder coversContent = new StringBuilder();
            bookCovers.forEach(it -> coversContent.append(templateParserService.parse(bookCoverTemplate, it)));
            String content = templateParserService.parse(contentTemplate, coversContent.toString());

            return pdfParserService.parse(content);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao gerar PDF");
        }

    }

}
