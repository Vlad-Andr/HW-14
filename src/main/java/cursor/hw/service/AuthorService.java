package cursor.hw.service;

import cursor.hw.models.Author;
import cursor.hw.models.Book;
import cursor.hw.repo.AuthorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {
    private final AuthorRepo authorRepository;

    public AuthorService(AuthorRepo authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addNewAuthor(Author author){
        authorRepository.save(author);
    }
    public void removeAuthor(Long idAuthor){
        authorRepository.deleteById(idAuthor);
    }
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
}
