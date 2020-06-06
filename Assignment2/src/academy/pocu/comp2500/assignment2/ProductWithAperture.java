package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.List;

public class ProductWithAperture extends Product{
    protected List<Aperture> apertures = new ArrayList<>();
    protected Orientation orientation;

    ProductWithAperture(int width, int height, Orientation orientation) {
        super(width, height);
        this.orientation = orientation;
    }

    public List<Aperture> getApertures() {
        return this.apertures;
    }

    public void addAperture(Aperture aperture) {
//        if (aperture.getWidth() <= 0 || aperture.getHeight() <= 0) {
//            return;
//        }
//        if (!(0 <= aperture.getX() && aperture.getX() < super.width)) {
//            return;
//        }
//        if (!(0 <= aperture.getY() && aperture.getY() < super.height)) {
//            return;
//        }
//
//        if (aperture.getX() + aperture.getWidth() > super.width) {
//            return;
//        }
//
//        if (aperture.getY() + aperture.getHeight() > super.height) {
//            return;
//        }
        this.apertures.add(aperture);
        super.price += 5;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
