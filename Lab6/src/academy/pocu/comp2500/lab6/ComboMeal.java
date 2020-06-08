package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class ComboMeal extends Menu {
    protected ArrayList<Appetizer> appetizers = new ArrayList<>();
    protected ArrayList<MainCourse> mainCourses = new ArrayList<>();
    protected ArrayList<Dessert> desserts = new ArrayList<>();

    ComboMeal(int price) {
        super(price);
    }

    public ArrayList<MainCourse> getMainCourses() {
        return this.mainCourses;
    }

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }
}
