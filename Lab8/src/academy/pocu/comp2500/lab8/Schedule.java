package academy.pocu.comp2500.lab8;

public class Schedule {
    private int startTick;
    private int activateUntil;

    public Schedule(int startTick, int activateUntil) {
        this.startTick = startTick;
        this.activateUntil = activateUntil;
    }

    public int getStartTick() {
        return startTick;
    }

    public int getActivateUntil() {
        return activateUntil;
    }
}
