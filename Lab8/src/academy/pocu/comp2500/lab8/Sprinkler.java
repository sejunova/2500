package academy.pocu.comp2500.lab8;

import java.util.ArrayDeque;
import java.util.Queue;

public class Sprinkler extends SmartDevice implements ISprayable {
    private Queue<Schedule> schedules = new ArrayDeque<>();
    private boolean isOn = false;
    private int curTick;
    private int ticksSinceLastUpdate;
    private int ticksUntilToggle;

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void onTick() {
        if (!this.isOn) {
            if (!this.schedules.isEmpty()) {
                Schedule nextSchedule = this.schedules.poll();
                int nextStart = nextSchedule.getStartTick();
                if (nextStart >= this.curTick) {
                    this.isOn = true;
                    this.ticksSinceLastUpdate = 0;
                    this.ticksUntilToggle = nextSchedule.getActivateUntil();
                } else {
                    this.ticksUntilToggle = nextStart + nextSchedule.getActivateUntil();
                }
            }
        } else {
            if (this.curTick == this.ticksUntilToggle) {
                this.isOn = false;
                this.ticksSinceLastUpdate = 0;
            }
        }
        this.ticksSinceLastUpdate++;
        this.curTick++;
    }

    @Override
    public int getTicksSinceLastUpdate() {
        return this.ticksSinceLastUpdate;
    }

    @Override
    public void spray(Planter planter) {
        if (this.isOn) {
            planter.setWaterAmount(planter.getWaterAmount() + 15);
        }
    }

    @Override
    public void onInstalled(Planter planter) {
        this.planter = planter;
        planter.addSprayable(this);
    }
}
