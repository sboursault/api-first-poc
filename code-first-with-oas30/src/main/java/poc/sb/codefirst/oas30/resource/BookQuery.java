package poc.sb.codefirst.oas30.resource;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.ResourceSupport;
import poc.sb.codefirst.oas30.controller.BooksController;
import poc.sb.codefirst.oas30.model.Book;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class BookQuery extends ResourceSupport {

    @JsonUnwrapped
    private final Book book;

    public BookQuery(Book book) {
        String id = book.getId();
        this.book = book;
        add(linkTo(methodOn(BooksController.class).get(id)).withSelfRel());
        add(linkTo(methodOn(BooksController.class).getAll()).withRel("start"));
    }

}
