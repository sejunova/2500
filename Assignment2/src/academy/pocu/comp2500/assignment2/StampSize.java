package academy.pocu.comp2500.assignment2;

public enum StampSize {
    WIDTH_40_HEIGHT_30(40, 30, 2300),
    WIDTH_50_HEIGHT_20(50, 20, 2300),
    WIDTH_70_HEIGHT_40(70, 40, 2600);

    private int width;
    private int height;
    private int price;

    StampSize(int width, int height, int price) {
        this.width = width;
        this.height = height;
        this.price = price;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getPrice() {
        return this.price;
    }

    public static StampSize[] all() {
        return values();
    }
}
