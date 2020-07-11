package academy.pocu.comp2500.assignment3;

import java.util.EnumSet;

public class Destroyer extends Unit implements Thinkable {
    public Destroyer(IntVector2D intVector2D) {
        super(intVector2D);
        super.symbol = 'D';
        super.unitType = UnitType.GROUND;
        super.sight = 0;
        super.aoe = 15;
        super.ap = Integer.MAX_VALUE;
        super.hp = Integer.MAX_VALUE;
        super.attackableUnitType = EnumSet.allOf(UnitType.class);
    }

    @Override
    public void onSpawn() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        simulationManager.registerUnit(this);
        simulationManager.registerThinkable(this);
    }

    @Override
    public void think() {
        this.attackIntentOrNull = new AttackIntent(this, this.getPosition());
    }

    @Override
    public void onAttacked(int damage) {
        this.hp = Math.max(0, this.hp - 1);
    }

    @Override
    public void beforeUpdate() {
        if (this.hp == 0) {
            SimulationManager simulationManager = SimulationManager.getInstance();
            simulationManager.unregisterThinkable(this);
        }
    }
}
