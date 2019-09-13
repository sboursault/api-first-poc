package poc.sb.codefirst.oas30.controller;

import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import poc.sb.codefirst.oas30.model.Book;
import poc.sb.codefirst.oas30.resource.BookQuery;

import javax.servlet.http.HttpServletResponse;

public interface IBooksController {

    /**
     * @api {get} /v1/books list of recommended books
     * @apiGroup Books
     *
     * @apiSampleRequest http://localhost:809/v1/books
     *
     * @apiSuccessExample {json} Success-Response:
     *     HTTP/1.1 200 OK
     *     {
     *       "links": [
     *         {
     *           "rel": "start",
     *           "href": "http://localhost:8080/v1/books"
     *         }
     *       ],
     *       "content": [
     *         {
     *           "title": "Foundation",
     *           "author": "Isaac Asimov",
     *           "series": "Foundation Series",
     *           "publicationDate": 1951,
     *           "genre": ["Science fiction", "political drama"],
     *           "links": [
     *             {
     *               "rel": "self",
     *               "href": "http://localhost:8080/v1/books/fe6c8d75-1a5d-4d6f-b973-000000000000"
     *             }
     *           ]
     *         },
     *         {
     *           "title": "Harry Potter and the Deathly Hallows",
     *           "author": "J. K. Rowling",
     *           "series": "Harry Potter",
     *           "publicationDate": 2009,
     *           "genre": ["Fantasy"],
     *           "links": [
     *             {
     *               "rel": "self",
     *               "href": "http://localhost:8080/v1/books/fe6c8d75-1a5d-4d6f-b973-000000000002"
     *             }
     *           ]
     *         }
     *       ]
     *     }
     *
     */

    Resources<BookQuery> getAll();

    /**
     * @api {get} /api/book/:isbn Get a book via its ISBN code
     * @apiName getBookByIsbn
     * @apiGroup Books
     *
     * @apiParam {String} isbn The book's unique ISBN code
     *
     * @apiSampleRequest http://localhost:8095/api/book/111-1
     *
     * @apiSuccess {String} isbn Book's ISBN
     * @apiSuccess {String} title Title of book
     * @apiSuccess {String} author Book's author
     * @apiSuccessExample {json} Success-Response:
     *     HTTP/1.1 200 OK
     *     {
    "isbn": "111-1",
    "title": "Java 8 Lamdas",
    "author": "Richard Warburton"
    }
     *
     */
    BookQuery get(String id);

    ResponseEntity create(Book input, HttpServletResponse response);
}
