package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class SimulationManager {
    private static SimulationManager simulationManager;

    private ArrayList<Unit> units = new ArrayList<>();
    private ArrayList<Thinkable> thinkables = new ArrayList<>();
    private ArrayList<Movable> movables = new ArrayList<>();

    public static SimulationManager getInstance() {
        if (simulationManager == null) {
            simulationManager = new SimulationManager();
        }
        return simulationManager;
    }

    public ArrayList<Unit> getUnits() {
        return this.units;
    }

    public void spawn(Unit unit) {
        unit.onSpawn();
    }

    public void registerUnit(Unit unit) {
        this.units.add(unit);
    }

    public void unregisterUnit(Unit unit) {
        this.units.remove(unit);
    }

    public void registerThinkable(Thinkable thinkable) {
        this.thinkables.add(thinkable);
    }

    public void unregisterThinkable(Thinkable thinkable) {
        this.thinkables.remove(thinkable);
    }

    public void registerMovable(Movable movable) {
        this.movables.add(movable);
    }

    public void unregisterMovable(Movable movable) {
        this.movables.remove(movable);
    }

    public void registerCollisionEventListener(Unit listener) {
    }

    public void update() {
        for (Thinkable thinkable: this.thinkables) {
            thinkable.think();
        }

        for (Movable movable: this.movables) {
            movable.move();
        }

        for (Unit unit: this.units) {
            AttackIntent attackIntentOrNull = unit.attack();
            if (attackIntentOrNull != null) {

            }
        }
    }
}