package academy.pocu.comp2500.lab9;

import java.util.Collection;

public abstract class PricingPolicy {
    public abstract int getTotalPrice(Collection<Book> books);
}
