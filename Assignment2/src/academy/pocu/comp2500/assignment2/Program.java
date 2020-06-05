package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class Program {

    public static void main(String[] args) {
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        Stamp stamp = new Stamp(StampColor.BLUE, StampSize.WIDTH_40_HEIGHT_30, "dd");
    }
}
