package academy.pocu.comp2500.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReadingList {
    private String name;
    private ArrayList<Book> books = new ArrayList<>();

    public ReadingList(String name) {
        this.name = name;
    }

    public boolean add(Book book) {
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

        if (!(o instanceof ReadingList)) {
            return false;
        }

        ReadingList readingList = (ReadingList) o;
        if (!this.name.equals(readingList.name)) {
            return false;
        }

        if (this.books.size() != readingList.books.size()) {
            return false;
        }

        List<Book> myBooks = this.books.stream().sorted().collect(Collectors.toList());
        List<Book> otherBooks = readingList.books.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < myBooks.size(); i++) {
            if (!myBooks.get(i).equals(otherBooks.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        List<Book> myBooks = this.books.stream().sorted().collect(Collectors.toList());
        int hash = myBooks.get(0).hashCode();
        for (int i = 1; i < myBooks.size(); i++) {
            hash = hash ^ myBooks.get(i).hashCode() << 16;
        }
        return Objects.hash(this.name, hash);
    }

    @Override
    public String toString() {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : this.books) {
            count++;
            stringBuilder.append(String.format("%d. %s%s", count, book, System.lineSeparator()));
        }
        return stringBuilder.toString();
    }
}
