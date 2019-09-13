package poc.sb.codefirst.oas30.resource;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import poc.sb.codefirst.oas30.controller.BooksController;
import poc.sb.codefirst.oas30.model.Book;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class BookResultQuery extends ResourceSupport {

    @JsonUnwrapped
    private final Book book;

    public BookResultQuery(Book book) {
        String id = book.getId();
        this.book = book;
        add(ControllerLinkBuilder.linkTo(methodOn(BooksController.class).get(id)).withSelfRel());
    }

}
