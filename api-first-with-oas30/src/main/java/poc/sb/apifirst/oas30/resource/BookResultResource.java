package poc.sb.apifirst.oas30.resource;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.ResourceSupport;
import poc.sb.apifirst.oas30.controller.BooksController;
import poc.sb.apifirst.oas30.model.Book;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class BookResultResource extends ResourceSupport {

    @JsonUnwrapped
    private final Book person;

    public BookResultResource(Book person) {
        String id = person.getId();
        this.person = person;
        add(linkTo(methodOn(BooksController.class).get(id)).withSelfRel());
    }

}
