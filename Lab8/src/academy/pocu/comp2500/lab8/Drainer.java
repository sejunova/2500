package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IDrainable, IWaterDetectable {
    private int drainTriggerWaterAmount;
    private boolean isOn;
    private int ticksSinceLastUpdate;

    public Drainer(int drainTriggerWaterAmount) {
        this.drainTriggerWaterAmount = drainTriggerWaterAmount;
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void onTick() {
    }

    @Override
    public int getTicksSinceLastUpdate() {
        return this.ticksSinceLastUpdate;
    }

    @Override
    public void drain(Planter planter) {
        detect(planter.getWaterAmount());
        if (this.isOn) {
            planter.setWaterAmount(Math.max(0, planter.getWaterAmount() - 7));
        }
    }

    @Override
    public void detect(int waterLevel) {
        boolean isOn = waterLevel >= this.drainTriggerWaterAmount;
        if (this.isOn != isOn) {
            this.ticksSinceLastUpdate = 1;
        } else {
            this.ticksSinceLastUpdate++;
        }
        this.isOn = isOn;
    }

    @Override
    public void onInstalled(Planter planter) {
        this.planter = planter;
        planter.addDrainable(this);
    }
}
