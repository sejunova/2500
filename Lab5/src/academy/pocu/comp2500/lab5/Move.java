package academy.pocu.comp2500.lab5;

public class Move {
    private String moveName;
    private int power;
    private int maxPowerPoint;
    private int currentPowerPoint;

    public Move(String moveName, int power, int maxPowerPoint) {
        this.moveName = moveName;
        this.power = power;
        this.maxPowerPoint = maxPowerPoint;
        this.currentPowerPoint = maxPowerPoint;
    }

    public String getMoveName() {
        return moveName;
    }

    public int getCurrentPowerPoint() {
        return currentPowerPoint;
    }

    public int getPower() {
        return power;
    }

    public int getMaxPowerPoint() {
        return maxPowerPoint;
    }

    public void setCurrentPowerPoint(int currentPowerPoint) {
        this.currentPowerPoint = currentPowerPoint;
    }
}
