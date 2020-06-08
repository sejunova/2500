package academy.pocu.comp2500.lab6;

public class DeathByDesserts extends ComboMeal{
    private static final int PRICE = 20;

    public DeathByDesserts() {
        super(PRICE);
    }

    public void setDesserts(Dessert dessert1, Dessert dessert2, Dessert dessert3, Dessert dessert4) {
        this.dessert.clear();

        this.dessert.add(dessert1);
        this.dessert.add(dessert2);
        this.dessert.add(dessert3);
        this.dessert.add(dessert4);
        this.isValid = true;
    }
}