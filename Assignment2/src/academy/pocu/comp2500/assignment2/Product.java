package academy.pocu.comp2500.assignment2;

public class Product {
    protected int width;
    protected int height;
    protected int price;
    protected DeliveryMethod deliveryMethod = DeliveryMethod.PICKUP;

    public Product(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getPrice() {
        return this.price;
    }

    public DeliveryMethod getDeliveryMethod() {
        return this.deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
