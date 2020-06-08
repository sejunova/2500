package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends ComboMeal{
    private static final int PRICE = 25;

    public ThreeCourseMeal() {
        super(PRICE);
    }

    private boolean isThreeCourseMealValid() {
        return this.appetizer.size() == 1 && this.mainCourse != null && this.dessert.size() == 1;
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
        this.isValid = isThreeCourseMealValid();
    }

    public void setAppetizer(Appetizer appetizer) {
        this.appetizer.clear();
        this.appetizer.add(appetizer);
        this.isValid = isThreeCourseMealValid();
    }

    public void setDessert(Dessert dessert) {
        this.dessert.clear();
        this.dessert.add(dessert);
        this.isValid = isThreeCourseMealValid();
    }
}