package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected Planter planter;

    public abstract boolean isOn();

    public abstract void onTick();

    public abstract int getTicksSinceLastUpdate();

    public void setPlanter(Planter plantter) {
        this.planter = plantter;
    }
}
