package cursor.hw.controllers;

import cursor.hw.models.Book;
import cursor.hw.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("library")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("book")
    public void addBook(@RequestBody Book book){
        bookService.addNewBook(book);
    }

    @GetMapping("book")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    public ResponseEntity<List<Book>> findAllBook() {
        List<Book> allBooks = bookService.getAllBooks();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allBooks);
    }

    @DeleteMapping("book")
    public ResponseEntity<Book> deleteAuthor(@PathVariable Long idBook){
        bookService.deleteBook(idBook);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
