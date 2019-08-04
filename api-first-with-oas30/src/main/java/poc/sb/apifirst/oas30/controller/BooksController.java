package poc.sb.apifirst.oas30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc.sb.apifirst.oas30.model.Book;
import poc.sb.apifirst.oas30.resource.BookResource;
import poc.sb.apifirst.oas30.service.BookService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(
        path = "/v1/books",
        produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Resources<BookResource> getAll() {
        List<BookResource> books = bookService.getBooks().stream()
                .map(BookResource::new)
                .collect(toList());
        return new Resources<>(
                books,
                linkTo(methodOn(BooksController.class).getAll()).withRel("start"));
    }

    @GetMapping("/{id}")
    public BookResource get(@PathVariable String id) {
        return new BookResource(bookService.getBook(id));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Book input, HttpServletResponse response) {
        String id = bookService.create(input).getId();
        return ResponseEntity.status(CREATED)
                .header("location", linkTo(methodOn(BooksController.class).get(id)).toUri().toString())
                .build();
    }

}
