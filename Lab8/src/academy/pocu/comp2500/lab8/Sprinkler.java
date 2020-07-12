package academy.pocu.comp2500.lab8;

import java.util.ArrayDeque;
import java.util.Queue;

public class Sprinkler extends SmartDevice implements ISprayable {
    private Queue<Schedule> schedules = new ArrayDeque<>();
    private boolean isOn = false;
    private int curTick;
    private int ticksSinceLastUpdate;
    private Schedule curSchedule;
    private boolean isCurScheduleEffective;

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
        // 스케줄이 없으면 뽑기
        if (this.curSchedule == null) {
            while (!this.schedules.isEmpty()) {
                Schedule schedule = this.schedules.poll();
                if (this.curTick <= schedule.getStartTick() + schedule.getActivateUntil()) {
                    this.curSchedule = schedule;
                    this.isCurScheduleEffective = this.curTick <= schedule.getStartTick();
                    break;
                }
            }
        }

        // 뽑을 스케줄이 없거나 유효한 스케줄이 없을때
        if (this.curSchedule == null) {
            isOn = false;
        } else {
            // 현재 유효한 스케쥴인 상태인 경우 + 현재 tick이 해당 스케쥴의 범위 안쪽인 경우에만 스위치 On
            isOn = this.isCurScheduleEffective && this.curSchedule.getStartTick() <= this.curTick && this.curTick <= this.curSchedule.getStartTick() + this.curSchedule.getActivateUntil() - 1;
            // 마지막 스케쥴 사용한 다음 턴
            if (this.curTick == this.curSchedule.getStartTick() + this.curSchedule.getActivateUntil()) {
                this.curSchedule = null;
            }
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
