package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    public abstract boolean isOn();
    public abstract void onTick();
    public abstract int getTicksSinceLastUpdate();
}
