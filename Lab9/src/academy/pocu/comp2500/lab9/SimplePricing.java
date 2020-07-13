package academy.pocu.comp2500.lab9;

import java.util.Collection;

public class SimplePricing extends PricingPolicy {
    public int getTotalPrice(Collection<Book> books) {
        if (books.isEmpty()) {
            return 0;
        }
        return books.stream().map(Book::getPrice).mapToInt(p -> p).sum();
    }
}
