package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.EnumSet;

public class Mine extends Unit implements CollisionEventLister {
    private int minimumCollision;

    public Mine(IntVector2D intVector2D, int minimumCollision) {
        super(intVector2D);
        super.symbol = 'N';
        super.unitType = UnitType.GROUND;
        super.sight = 0;
        super.aoe = 0;
        super.ap = 10;
        super.hp = 1;
        super.attackableUnitType = EnumSet.of(UnitType.GROUND);
        this.minimumCollision = minimumCollision;
    }

    @Override
    public void onSpawn() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        simulationManager.registerUnit(this);
        simulationManager.registerCollisionEventListener(this);
    }

    @Override
    public void listenCollisionEvent() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        ArrayList<Unit> units = simulationManager.getUnits();

        int collisionsCount = (int) units.stream()
                .filter(x -> x.unitType.equals(UnitType.GROUND))
                .filter(Unit::isVisible)
                .filter(x -> x != this)
                .filter(x -> x.position.equals(this.position))
                .count();

        if (collisionsCount >= this.minimumCollision) {
            this.hp = 0;
            this.attackIntentOrNull = new AttackIntent(this, this.getPosition());
        } else {
            this.minimumCollision -= collisionsCount;
            this.attackIntentOrNull = null;
        }
    }

    @Override
    public void beforeUpdate() {
        if (this.hp == 0) {
            SimulationManager simulationManager = SimulationManager.getInstance();
            simulationManager.unregisterCollisionEventListener(this);
        }
    }

    @Override
    public boolean isVisible() {
        return false;
    }
}
