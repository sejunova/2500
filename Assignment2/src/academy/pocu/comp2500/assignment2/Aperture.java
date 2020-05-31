package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.List;

public class Aperture {
    List<String> aperture = new ArrayList<>();

    public List<String> getAperture() {
        return this.aperture;
    }


    public void addAperture(String aperture) {
        this.aperture.add(aperture);
    }
}
