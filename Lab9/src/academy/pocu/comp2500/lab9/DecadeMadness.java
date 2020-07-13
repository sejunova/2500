package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DecadeMadness {
    public int getTotalPrice(Collection<Book> books) {
        double price = 0;
        HashMap<Integer, ArrayList<Integer>> generationBooksMap = new HashMap<>();
        for (Book book : books) {
            int generation = book.getPublishedYear() / 10 * 10;
            if (!generationBooksMap.containsKey(generation)) {
                generationBooksMap.put(generation, new ArrayList<>());
            }
            generationBooksMap.get(generation).add(book.getPrice());
        }

        for (ArrayList<Integer> prices : generationBooksMap.values()) {
            double priceToAdd = (prices.size() == 1) ? prices.get(0) : prices.stream().mapToDouble(p -> p).sum() * 0.8;
            price += priceToAdd;
        }
        return (int) price;
    }
}
