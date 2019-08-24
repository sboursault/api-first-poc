package poc.sb.codefirst.oas30.service;

import org.springframework.stereotype.Repository;
import poc.sb.codefirst.oas30.model.Book;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class BookRepository {

    private Map<String, Book> innerMap = new HashMap<>();

    @PostConstruct
    void init() {
        create(Book.Builder.aBook()
                .id("fe6c8d75-1a5d-4d6f-b973-000000000000")
                .title("Foundation")
                .author("Isaac Asimov")
                .series("Foundation Series")
                .publicationDate(1951)
                .genre("Science fiction", "political drama")
                .build());

        create(Book.Builder.aBook()
                .id("fe6c8d75-1a5d-4d6f-b973-000000000001")
                .title("A Game of Thrones")
                .author("George R. R. Martin")
                .series("A Song of Ice and Fire")
                .publicationDate(1996)
                .genre("Epic fantasy")  // https://en.wikipedia.org/wiki/High_fantasy
                .build());

        create(Book.Builder.aBook()
                .id("fe6c8d75-1a5d-4d6f-b973-000000000002")
                .title("Harry Potter and the Deathly Hallows")
                .author("J. K. Rowling")
                .series("Harry Potter")
                .publicationDate(2009)
                .genre("Fantasy")  // https://en.wikipedia.org/wiki/Fantasy
                .build());

        create(Book.Builder.aBook()
                .id("fe6c8d75-1a5d-4d6f-b973-000000000003")
                .title("Pandora's Star")
                .author("Peter F. Hamilton")
                .series("The Commonwealth Saga")
                .publicationDate(2004)
                .genre("Science fiction")
                .build());

        //create(aBook()
        //        .id("fe6c8d75-1a5d-4d6f-b973-000000000004")
        //        .title("Theft of Swords")
        //        .author("Michael J. Sullivan")
        //        .series("The Riyria Revelations")
        //        .publicationDate(2011)
        //        .genre("Epic fantasy")  // https://en.wikipedia.org/wiki/High_fantasy
        //        .build());

    }

    public List<Book> getAll() {
        return new ArrayList<>(innerMap.values());
    }

    public Book create(Book book) {
        innerMap.put(book.getId(), book);
        return book;
    }


    public Optional<Book> getById(String uuid) {
        return Optional.ofNullable(innerMap.get(uuid));
    }
}
