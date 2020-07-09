package academy.pocu.comp2500.lab8;

import java.util.ArrayDeque;
import java.util.Queue;

public class Sprinkler extends SmartDevice implements ISprayable {
    private Queue<Schedule> schedules = new ArrayDeque<>();
    private boolean isOn = false;
    private int curTick;
    private int ticksSinceLastUpdate;
    private Schedule curSchedule;
    private boolean curMode;

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void onTick() {
        boolean isOn;
        if (this.curSchedule == null) {
            while (!this.schedules.isEmpty()) {
                Schedule schedule = this.schedules.poll();
                if (this.curTick > schedule.getStartTick() + schedule.getActivateUntil()) {
                    continue;
                } else {
                    this.curSchedule = schedule;
                    this.curMode = this.curTick <= schedule.getStartTick();
                    break;
                }
            }
        }

        if (this.curSchedule == null) {
            isOn = false;
        } else {
            isOn = this.curMode && this.curSchedule.getStartTick() <= this.curTick && this.curTick <= this.curSchedule.getStartTick() + this.curSchedule.getActivateUntil() - 1;
        }

        if (this.curSchedule != null && this.curTick == this.curSchedule.getStartTick() + this.curSchedule.getActivateUntil()) {
            isOn = false;
            this.curSchedule = null;
        }

        if (this.isOn != isOn) {
            this.ticksSinceLastUpdate = 0;
        }

        this.isOn = isOn;
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
