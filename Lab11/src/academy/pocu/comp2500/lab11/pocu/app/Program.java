package academy.pocu.comp2500.lab11.pocu.app;

import academy.pocu.comp2500.lab11.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

    public static void main(String[] args) throws IOException {
        App app = new App();

        app.run(new BufferedReader(new InputStreamReader(System.in)), System.out, System.err);
    }
}
