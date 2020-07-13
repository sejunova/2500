package academy.pocu.comp2500.lab9;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

public class BuyOneGetOneFree extends PricingPolicy {
    private Map<UUID, Integer> skus;

    public BuyOneGetOneFree(HashSet<UUID> skus) {
        this.skus = new HashMap<>();
        for (UUID sku : skus) {
            this.skus.put(sku, 0);
        }
    }

    public int getTotalPrice(Collection<Book> books) {
        if (books.isEmpty()) {
            return 0;
        }
        int price = 0;
        HashMap<UUID, Integer> booksPrice = new HashMap<>();
        for (Book book : books) {
            if (this.skus.containsKey(book.getSku())) {
                this.skus.merge(book.getSku(), 1, Integer::sum);
                booksPrice.put(book.getSku(), book.getPrice());
            } else {
                price += book.getPrice();
            }
        }
        for (Map.Entry<UUID, Integer> entry : this.skus.entrySet()) {
            UUID sku = entry.getKey();
            int count = entry.getValue();
            int bookPrice = booksPrice.get(sku);
            price += (count / 2 + count % 2) * bookPrice;
        }
        return price;
    }
}
