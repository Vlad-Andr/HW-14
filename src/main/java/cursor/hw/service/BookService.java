package cursor.hw.service;

import cursor.hw.models.Book;
import cursor.hw.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addNewBook(Book book) {
        bookRepo.save(book);
    }

    public void deleteBook(Long idDeletedBook) {
        bookRepo.deleteById(idDeletedBook);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}
