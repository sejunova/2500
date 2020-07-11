package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public final class SimulationManager {
    private static SimulationManager simulationManager;

    private ArrayList<Unit> units = new ArrayList<>();
    private ArrayList<Thinkable> thinkables = new ArrayList<>();
    private ArrayList<Movable> movables = new ArrayList<>();
    private ArrayList<CollisionEventLister> collisionEventListeners = new ArrayList<>();

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

    public void registerCollisionEventListener(CollisionEventLister listener) {
        this.collisionEventListeners.add(listener);
    }

    public void unregisterCollisionEventListener(CollisionEventLister listener) {
        this.collisionEventListeners.remove(listener);
    }

    public void update() {
        for (Thinkable thinkable : this.thinkables) {
            thinkable.think();
        }

        for (Movable movable : this.movables) {
            movable.move();
        }

        for (CollisionEventLister collisionEventLister : this.collisionEventListeners) {
            collisionEventLister.listenCollisionEvent();
        }

        ArrayList<AttackIntent> attackIntents = new ArrayList<>();
        for (Unit unit : this.units) {
            AttackIntent attackIntentOrNull = unit.attack();
            if (attackIntentOrNull != null) {
                attackIntents.add(attackIntentOrNull);
            }
        }

        for (AttackIntent attackIntent : attackIntents) {
            Unit attackUnit = attackIntent.getAttackUnit();
            Set<UnitType> attackableUnitTypes = attackUnit.getAttackableUnitType();
            for (Unit unit : this.units) {
                if (unit == attackUnit) {
                    continue;
                }
                if (!attackableUnitTypes.contains(unit.getUnitType())) {
//                    System.out.println(unit);
                    continue;
                }

                for (AttackInfo attackInfo : attackIntent.getAttackInfos()) {
                    if (attackInfo.area.equals(unit.getPosition())) {
//                        System.out.println(String.format("%s by %s, %s", attackInfo, attackUnit, unit));
                        unit.onAttacked(attackInfo.ap);
                    }
                }
            }
        }

        this.units.forEach(Unit::beforeUpdate);
        this.units = this.units.stream().filter(x -> x.getHp() != 0).collect(Collectors.toCollection(ArrayList::new));
    }
}