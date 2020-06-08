package academy.pocu.comp2500.lab6;

public class Menu {
    protected int price;
    protected boolean isValid = false;

    Menu(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isValid() {
        return this.isValid;
    }
}
