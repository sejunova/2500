package academy.pocu.comp2500.assignment2;

public class Stamp {
    private Color color;
    private int width;
    private int height;
    private int price;
    private DeliveryMethod deliveryMethod = DeliveryMethod.PICKUP;
    private String text;

    public Stamp(Color color, int width, int height, String text) {
        if (width == 40 && height == 30) {
            this.price = 2300;
        } else if (width == 50 && height == 20) {
            this.price = 2300;
        } else if (width == 70 && height == 40) {
            this.price = 2600;
        } else {
            throw new RuntimeException("Wrong width & height given");
        }
        this.color = color;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public String getColor() {
        return color.getColor();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public String getText() {
        return text;
    }
}
