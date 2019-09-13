package poc.sb.codefirst.oas30.resource;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import poc.sb.codefirst.oas30.model.Book;

public class CreateBookCommand {

    @JsonUnwrapped
    private final Book book;

    public CreateBookCommand(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
