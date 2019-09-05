package poc.sb.codefirst.oas30.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc.sb.codefirst.oas30.model.Book;
import poc.sb.codefirst.oas30.resource.BookResource;
import poc.sb.codefirst.oas30.service.BookService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.CREATED;

@Api(tags = "Book api", description = " ")
@RestController
@RequestMapping(
        path = "/v1/books",
        produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class BooksController {

    @Autowired
    private BookService bookService;

    @ApiOperation(
            value = "list of recommended books",
            code = 200,
            notes = "some notes",
            responseContainer = "response container", responseReference = "response ref"/*, extensions = */)

    @GetMapping
    public Resources<BookResource> getAll() {
        List<BookResource> books = bookService.getBooks().stream()
                .map(BookResource::new)
                .collect(toList());
        return new Resources<>(
                books,
                linkTo(methodOn(BooksController.class).getAll()).withRel("start"));
    }

    @ApiOperation(
            value = "get book detail",
            notes = "TRY TO PUT HERE A REF TO THE POST METHOD",
            responseContainer = "response container", responseReference = "response ref"/*, extensions = */)
    /*@ApiResponses({
            @ApiResponse(code = 200, message = "Ok", examples = @Example(@ExampleProperty(mediaType = "msg", value = "OK"))
            ),
            @ApiResponse(code = 404, message = "Not found", examples = @Example(@ExampleProperty(mediaType = "msg", value = "OK"))
            )
    })*/
    @ApiResponses(@ApiResponse(code = 200, message = "Resource created", response = String.class, examples = @Example({@ExampleProperty("'Example text'")})))

    @GetMapping("/{id}")
    public BookResource get(
            @ApiParam(
                    value = "the book id",
                    example = "fe6c8d75-1a5d-4d6f-b973-000000000001")
            @PathVariable String id) {
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
