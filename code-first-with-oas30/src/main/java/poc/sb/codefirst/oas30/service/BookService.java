package poc.sb.codefirst.oas30.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.sb.codefirst.oas30.exception.EntityNotFoundException;
import poc.sb.codefirst.oas30.exception.InvalidCommandException;
import poc.sb.codefirst.oas30.model.Book;
import poc.sb.codefirst.oas30.resource.CreateBookCommand;

import java.time.LocalDate;
import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.getAll();
    }

    public Book create(CreateBookCommand command) {
        Book book = command.getBook();
        if (book.getId() != null) {
            throw new InvalidCommandException("book.id must be null");
        }
        if (book.getPublicationDate() != null
                && (book.getPublicationDate() < 0
                || book.getPublicationDate() > LocalDate.now().getYear())) {
            throw new InvalidCommandException("book.publicationDate must be a number between 0 and " + LocalDate.now().getYear());
        }
        book.setId(UUID.randomUUID().toString());
        return bookRepository.create(book);
    }

    public Book getBook(String uuid) {
        return bookRepository.getById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("no book found with id '" + uuid + "'"));
    }
}
