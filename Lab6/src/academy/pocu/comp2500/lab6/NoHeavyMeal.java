package academy.pocu.comp2500.lab6;

public class NoHeavyMeal extends ComboMeal{
    private static final int PRICE = 15;

    public NoHeavyMeal() {
        super(PRICE);
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        this.appetizers.clear();
        this.appetizers.add(appetizer1);
        this.appetizers.add(appetizer2);
        this.isValid = this.appetizers.size() == 2 && this.desserts.size() == 1;
    }

    public void setDessert(Dessert desert) {
        this.desserts.clear();
        this.desserts.add(desert);
        this.isValid = this.appetizers.size() == 2 && this.desserts.size() == 1;
    }
}