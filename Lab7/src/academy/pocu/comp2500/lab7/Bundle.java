package academy.pocu.comp2500.lab7;

import java.util.HashSet;
import java.util.Objects;

public class Bundle {
    private String name;
    private HashSet<Book> books = new HashSet<>();

    public Bundle(String name) {
        this.name = name;
    }

    public boolean add(Book book) {
        if (this.books.contains(book)) {
            return false;
        }
        this.books.add(book);
        return true;
    }

    public boolean remove(Book book) {
        if (!this.books.contains(book)) {
            return false;
        }
        this.books.remove(book);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Bundle)) {
            return false;
        }

        Bundle bundle = (Bundle) o;
        if (!this.name.equals(bundle.name)) {
            return false;
        }

        if (this.books.size() != bundle.books.size()) {
            return false;
        }

        for (Book book: this.books) {
            if (!bundle.books.contains(book)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Book book: this.books) {
            hash = hash ^ book.hashCode() << 16;
        }
        return Objects.hash(this.name, hash);
    }
}
