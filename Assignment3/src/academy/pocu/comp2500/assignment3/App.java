package academy.pocu.comp2500.assignment3;

import academy.pocu.comp2500.assignment3.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerMarineCreator("Foo");
        registry.registerTankCreator("Foo");
        registry.registerWraithCreator("Foo");
        registry.registerTurretCreator("Foo");
        registry.registerMineCreator("Foo");
        registry.registerSmartMineCreator("Foo");
        registry.registerDestroyerCreator("Foo");
    }
}
