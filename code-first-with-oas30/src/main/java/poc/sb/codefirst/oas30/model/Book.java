package poc.sb.codefirst.oas30.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {

    @JsonIgnore
    private String id;
    private String title;
    private String author;
    private String series;
    private Integer publicationDate;
    private final List<String> genre = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Integer publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<String> getGenre() {
        return genre;
    }


    public static final class Builder {
        private Book book;

        private Builder() {
            book = new Book();
        }

        public static Builder aBook() {
            return new Builder();
        }

        public Builder id(String id) {
            book.setId(id);
            return this;
        }

        public Builder title(String title) {
            book.setTitle(title);
            return this;
        }

        public Builder author(String author) {
            book.setAuthor(author);
            return this;
        }

        public Builder series(String series) {
            book.setSeries(series);
            return this;
        }

        public Builder publicationDate(Integer publicationDate) {
            book.setPublicationDate(publicationDate);
            return this;
        }

        public Builder genre(String... genre) {
            return genre(Arrays.asList(genre));
        }

        public Builder genre(List<String> genre) {
            book.getGenre().addAll(genre);
            return this;
        }

        public Book build() {
            return book;
        }
    }
}
