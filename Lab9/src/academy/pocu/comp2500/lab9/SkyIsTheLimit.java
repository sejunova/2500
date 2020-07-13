package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class SkyIsTheLimit {
    int discountThreshold;

    public SkyIsTheLimit(int discountThreshold) {
        this.discountThreshold = discountThreshold;
    }

    public int getTotalPrice(Collection<Book> books) {
        ArrayList<Double> booksPrice = books.stream().map(b -> (double) b.getPrice()).collect(Collectors.toCollection(ArrayList::new));
        int originalSum = (int) booksPrice.stream().mapToDouble(p -> p).sum();
        if (booksPrice.size() >= 5 && originalSum >= this.discountThreshold) {
            booksPrice.sort(Collections.reverseOrder());
            booksPrice.set(0, booksPrice.get(0) * 0.5);
            booksPrice.set(1, booksPrice.get(1) * 0.5);
            return (int) booksPrice.stream().mapToDouble(p -> p).sum();
        }
        return originalSum;
    }
}
