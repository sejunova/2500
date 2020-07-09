package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.stream.Collectors;

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

        ArrayList<AttackIntent> attackIntents = new ArrayList<>();
        for (Unit unit: this.units) {
            AttackIntent attackIntentOrNull = unit.attack();
            if (attackIntentOrNull != null) {
                attackIntents.add(attackIntentOrNull);
            }
        }

        for (AttackIntent attackIntent: attackIntents) {
            this.units.stream()
                    .filter(x -> x.getPosition().equals(attackIntent.getUnit().getPosition()))
                    .filter(x -> attackIntent.getUnit().getAttackableUnitType().contains(x.getUnitType()))
                    .filter(x -> x.equals(attackIntent.getUnit()))
                    .forEach(x -> x.onAttacked(attackIntent.getUnit().getAp()));
        }

        this.units = this.units.stream().filter(x -> x.getHp() != 0).collect(Collectors.toCollection(ArrayList::new));
    }
}