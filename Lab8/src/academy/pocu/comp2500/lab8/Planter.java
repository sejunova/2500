package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private int waterAmount;
    private ArrayList<ISprayable> sprayables = new ArrayList<>();
    private ArrayList<IDrainable> drainables = new ArrayList<>();
    private ArrayList<SmartDevice> smartDevices = new ArrayList<>();

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void installSmartDevice(SmartDevice smartDevice) {
        this.smartDevices.add(smartDevice);
        smartDevice.onInstalled(this);
    }

    public int getWaterAmount() {
        return this.waterAmount;
    }

    public void tick() {
        for (SmartDevice smartDevice: this.smartDevices) {
            smartDevice.onTick();
        }
        for (IDrainable drainable: this.drainables) {
            drainable.drain(this);
        }
        for (ISprayable sprayable: this.sprayables) {
            sprayable.spray(this);
        }
        this.waterAmount = Math.max(0, this.waterAmount - 2);
    }

    public void setWaterAmount(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void addSprayable(ISprayable sprayable) {
        this.sprayables.add(sprayable);
    }

    public void addDrainable(IDrainable drainable) {
        this.drainables.add(drainable);
    }

}
