package academy.pocu.comp2500.lab8;

import java.util.ArrayDeque;
import java.util.Queue;

public class Sprinkler extends SmartDevice implements ISprayable {
    private Queue<Schedule> schedules = new ArrayDeque<>();
    private boolean isOn = false;
    private int curTick;
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
        if (isOn && this.planter != null) {
            this.spray(this.planter);
        }
        if (this.remainingActiveTick == 0 && !this.schedules.isEmpty()) {
            Schedule nextSchedule = this.schedules.poll();
            int startTick = nextSchedule.getStartTick();
            if (startTick < this.curTick) {
                this.ticksSinceLastUpdate++;
            } else {
                this.ticksSinceLastUpdate = 0;
                this.remainingActiveTick = nextSchedule.getActivateUntil();
                this.isOn = true;
            }
        } else {
            this.remainingActiveTick--;
            if (remainingActiveTick == 0) {
                this.isOn = false;
            }
            this.ticksSinceLastUpdate++;
        }
        this.curTick++;
    }

    @Override
    public int getTicksSinceLastUpdate() {
        return this.ticksSinceLastUpdate;
    }

    @Override
    public void spray(Planter planter) {
        planter.setWaterAmount(planter.getWaterAmount() + 15);
    }
}
