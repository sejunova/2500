package academy.pocu.comp2500.lab8;

import java.util.ArrayDeque;
import java.util.Queue;

public class Sprinkler extends SmartDevice implements ISprayable {
    private Queue<Schedule> schedules = new ArrayDeque<>();
    private boolean isOn = false;
    private int curTick;
    private int ticksSinceLastUpdate;
    private int startTick = -1;
    private int endTick;

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void onTick() {
        if (this.curTick >= this.endTick) {
            if (this.curTick == this.endTick) {
                this.isOn = false;
                this.ticksSinceLastUpdate = 0;
            }
            while (!this.schedules.isEmpty()) {
                Schedule nextSchedule = this.schedules.poll();
                int nextStart = nextSchedule.getStartTick();
                int nextEnd = nextSchedule.getActivateUntil();
                if (nextStart + nextEnd < this.curTick) {
                    continue;
                }
                if (nextStart >= this.curTick) {
                    this.startTick = nextStart;
                }
                this.endTick = nextStart + nextEnd;
                break;
            }
        }

        if (this.curTick == this.startTick) {
            this.isOn = true;
            this.ticksSinceLastUpdate = 0;
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
