package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();
    private int totalPrice;

    public void addProduct(Product product) {
        this.products.add(product);
        this.totalPrice += product.getPrice();
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
        this.totalPrice -= product.getPrice();
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public Product getProduct(int index) {
        return this.products.get(index);
    }
}
