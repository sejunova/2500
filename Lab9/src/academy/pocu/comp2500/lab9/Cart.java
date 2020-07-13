package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.Collection;

public final class Cart {
    private ArrayList<Book> books = new ArrayList<>();

    public Book getBookOrNull(int index) {
        if (this.books.size() <= index) {
            return null;
        }

        return this.books.get(index);
    }

    public int getBookCount() {
        return this.books.size();
    }

    public boolean addBooks(Collection<Book> books) {
        for (Book book : books) {
            if (book == null) {
                return false;
            }
        }
        this.books.addAll(books);
        return true;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public boolean remove(int index) {
        if (this.books.size() <= index) {
            return false;
        }

        this.books.remove(index);

        return true;
    }

    public int getTotalPrice(SimplePricing pricingPolicy) {
        return pricingPolicy.getTotalPrice(this.books);
    }

    public int getTotalPrice(BuyOneGetOneFree pricingPolicy) {
        return pricingPolicy.getTotalPrice(this.books);
    }

    public int getTotalPrice(DecadeMadness pricingPolicy) {
        return pricingPolicy.getTotalPrice(this.books);
    }

    public int getTotalPrice(SkyIsTheLimit pricingPolicy) {
        return pricingPolicy.getTotalPrice(this.books);
    }
}