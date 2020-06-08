package academy.pocu.comp2500.lab6;


import java.util.ArrayList;

public class ComboMeal extends Menu {
    protected ArrayList<Appetizer> appetizer = new ArrayList<>();
    protected MainCourse mainCourse;
    protected ArrayList<Dessert> dessert = new ArrayList<>();

    ComboMeal(int price) {
        super(price);
    }

    public MainCourse getMainCourse() {
        return this.mainCourse;
    }

    public ArrayList<Appetizer> getAppetizer() {
        return this.appetizer;
    }

    public ArrayList<Dessert> getDessert() {
        return this.dessert;
    }
}
