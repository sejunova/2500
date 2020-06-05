package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture{
    private String image;

    public ImageAperture(int x, int y, int width, int height, String image) {
        super(x, y, width, height);
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }
}
