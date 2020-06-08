package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza{
    private static final int PRICE = 20;
    private static final int MAX_MEAT_COUNT = 2;

    private int meatCount;

    public HousePizza() {
        super(PRICE);
        this.toppings.add(Topping.BLACK_OLIVES);
        this.toppings.add(Topping.RED_ONIONS);
        this.toppings.add(Topping.GREEN_PEPPERS);
        this.toppings.add(Topping.MOZZARELLA_CHEESE);
    }

    public boolean addBacon() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.BACON);
        ++this.meatCount;
        this.isValid = this.meatCount == MAX_MEAT_COUNT;
        return true;
    }

    public boolean removeBacon() {
        boolean isRemoved = this.toppings.remove(Topping.BACON);

        if (isRemoved) {
            --this.meatCount;
        }

        this.isValid = this.meatCount == MAX_MEAT_COUNT;
        return isRemoved;
    }

    public boolean addPeperoni() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.PEPERONI);
        ++this.meatCount;
        this.isValid = this.meatCount == MAX_MEAT_COUNT;
        return true;
    }

    public boolean removePeperoni() {
        boolean isRemoved = this.toppings.remove(Topping.PEPERONI);

        if (isRemoved) {
            --this.meatCount;
        }

        this.isValid = this.meatCount == MAX_MEAT_COUNT;
        return isRemoved;
    }

    public boolean addSausages() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.SAUSAGES);
        ++this.meatCount;
        this.isValid = this.meatCount == MAX_MEAT_COUNT;
        return true;
    }

    public boolean removeSausages() {
        boolean isRemoved = this.toppings.remove(Topping.SAUSAGES);

        if (isRemoved) {
            --this.meatCount;
        }

        this.isValid = this.meatCount == MAX_MEAT_COUNT;
        return isRemoved;
    }
}

