package academy.pocu.comp2500.lab6;

public class NoHeavyMeal extends ComboMeal{
    private static final int PRICE = 15;

    public NoHeavyMeal() {
        super(PRICE);
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        this.appetizer.clear();
        this.appetizer.add(appetizer1);
        this.appetizer.add(appetizer2);
        this.isValid = this.appetizer.size() == 2 && this.dessert.size() == 1;
    }

    public void setDessert(Dessert desert) {
        this.dessert.clear();
        this.dessert.add(desert);
        this.isValid = this.appetizer.size() == 2 && this.dessert.size() == 1;
    }
}