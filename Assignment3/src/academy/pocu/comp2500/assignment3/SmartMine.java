package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.EnumSet;

public class SmartMine extends Unit implements CollisionEventLister {
    private int collisionsBeforeBlowUp;

    public SmartMine(IntVector2D intVector2D, int collisionsBeforeBlowUp) {
        super(intVector2D);
        super.symbol = 'A';
        super.unitType = UnitType.GROUND;
        super.sight = 1;
        super.aoe = 1;
        super.ap = 15;
        super.hp = 1;
        super.attackableUnitType = EnumSet.of(UnitType.GROUND);
        this.collisionsBeforeBlowUp = collisionsBeforeBlowUp;
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
                .filter(x -> x != this)
                .filter(x -> this.position.isInSight(x.position, this.sight))
                .count();

        if (collisionsCount >= this.collisionsBeforeBlowUp) {
            this.hp = 0;
            this.attackIntentOrNull = new AttackIntent(this, this.getPosition());
        } else {
            this.collisionsBeforeBlowUp -= collisionsCount;
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
