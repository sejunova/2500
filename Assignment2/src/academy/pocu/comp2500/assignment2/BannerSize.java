package academy.pocu.comp2500.assignment2;

public enum BannerSize {
    WIDTH_1000_HEIGHT_500(1000, 500),
    WIDTH_1000_HEIGHT_1000(1000, 1000),
    WIDTH_2000_HEIGHT_500(2000, 500),
    WIDTH_3000_HEIGHT_1000(3000, 1000);

    private int width;
    private int height;

    BannerSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public static BannerSize[] all() {
        return values();
    }
}
