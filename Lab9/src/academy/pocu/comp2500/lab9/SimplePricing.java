package academy.pocu.comp2500.lab9;

import java.util.Collection;

public class SimplePricing {
    public int getTotalPrice(Collection<Book> books) {
        return books.stream().map(Book::getPrice).mapToInt(p -> p).sum();
    }
}
