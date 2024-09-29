package br.com.api4dev.pdfgenerator.controllers.book;

import br.com.api4dev.pdfgenerator.models.book.BookCover;
import br.com.api4dev.pdfgenerator.services.book.BookCoversGeneratorService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {


    private final BookCoversGeneratorService bookCoversGeneratorService;

    public BookController(BookCoversGeneratorService bookCoversGeneratorService) {
        this.bookCoversGeneratorService = bookCoversGeneratorService;
    }

    @PostMapping(value = "/generate-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf(@RequestBody List<BookCover> bookCovers) {

        byte[] pdf = bookCoversGeneratorService.generatePdf(bookCovers);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=covers.pdf");

        return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdf);

    }


}
