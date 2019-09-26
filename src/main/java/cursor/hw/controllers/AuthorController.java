package cursor.hw.controllers;

import cursor.hw.models.Author;
import cursor.hw.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        authorService.addNewAuthor(author);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAllAuthors() {
        List<Author> allAuthors = authorService.getAllAuthors();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allAuthors);
    }

    @DeleteMapping
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long idAuthor){
        authorService.removeAuthor(idAuthor);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
