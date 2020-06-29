package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public class Bookshelf {
    private int maxBookCount;
    private ArrayList<Book> books = new ArrayList<>();

    public Bookshelf(int maxBookCount) {
        this.maxBookCount = maxBookCount;
    }

    public boolean add(Book book) {
        if (this.books.size() == this.maxBookCount) {
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
}
