package academy.pocu.comp2500.assignment3;

public class Destroyer extends Unit {
    private int i;
    public Destroyer(IntVector2D intVector2D, int i) {
        super(intVector2D);
        this.i = i;
    }

    @Override
    public void onSpawn() {

    }
}
