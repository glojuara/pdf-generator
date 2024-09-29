package br.com.api4dev.pdfgenerator.services.book;

import br.com.api4dev.pdfgenerator.models.book.BookCover;

import java.util.List;

public interface BookCoversGeneratorService {

    byte[] generatePdf(List<BookCover> bookCovers);

}
