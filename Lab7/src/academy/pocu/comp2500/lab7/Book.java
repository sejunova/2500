package academy.pocu.comp2500.lab7;

import java.util.Objects;

public class Book {
    private String title;
    private Author author;
    private int publishedYear;
    private Genre genre;


    public Book(String title, Author author, int publishedYear, Genre genre) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Book)) {
            return false;
        }

        Book book = (Book) o;
        return this.title.equals(book.title) && this.author.equals(book.author) && this.publishedYear == book.publishedYear && this.genre.equals(book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.author, this.publishedYear, this.genre);
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", this.title, this.author);
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }
}
