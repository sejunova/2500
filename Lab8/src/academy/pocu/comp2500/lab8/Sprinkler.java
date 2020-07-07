package academy.pocu.comp2500.lab8;

import java.util.ArrayDeque;
import java.util.Queue;

public class Sprinkler extends SmartDevice implements ISprayable {
    private Queue<Schedule> schedules = new ArrayDeque<>();
    private boolean isOn = false;
    private int curTick;
    private int nextStart = -1;
    private int remainingActiveTick;
    private int ticksSinceLastUpdate;

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void onTick() {
        boolean isOnNext = this.isOn;

        if (this.isOn) {
            this.remainingActiveTick--;
        }

        if (this.remainingActiveTick == 0) {
            isOnNext = false;

            while (!this.schedules.isEmpty()) {
                Schedule nextSchedule = this.schedules.poll();
                int nextStart = nextSchedule.getStartTick();
                if (nextStart >= this.curTick) {
                    this.nextStart = nextStart;
                    this.remainingActiveTick = nextSchedule.getActivateUntil();
                    break;
                }
            }
        }

        if (this.nextStart == this.curTick) {
            isOnNext = true;
        }

        if (this.isOn == isOnNext) {
            this.ticksSinceLastUpdate++;
        } else {
            this.isOn = isOnNext;
            this.ticksSinceLastUpdate = 1;
        }

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
