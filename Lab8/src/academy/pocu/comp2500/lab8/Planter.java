package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private int waterAmount;
    private ArrayList<SmartDevice> smartDevices = new ArrayList<>();

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void installSmartDevice(SmartDevice smartDevice) {
        this.smartDevices.add(smartDevice);
        smartDevice.setPlanter(this);
    }

    public int getWaterAmount() {
        return this.waterAmount;
    }

    public void tick() {
        this.waterAmount = Math.max(0, this.waterAmount - 2);
    }

    public void setWaterAmount(int waterAmount) {
        this.waterAmount = waterAmount;
    }

}
