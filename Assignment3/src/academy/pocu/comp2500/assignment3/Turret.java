package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.EnumSet;

public class Turret extends Unit implements Thinkable {
    public Turret(IntVector2D intVector2D) {
        super(intVector2D);
        super.symbol = 'U';
        super.unitType = UnitType.GROUND;
        super.sight = 2;
        super.aoe = 0;
        super.ap = 7;
        super.hp = 99;
        super.attackableUnitType = EnumSet.of(UnitType.AIR);
    }

    @Override
    public void onSpawn() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        simulationManager.registerUnit(this);
        simulationManager.registerThinkable(this);
    }

    @Override
    public void think() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        ArrayList<Unit> units = simulationManager.getUnits();

        Unit targetUnit = null;
        double targetUnitDist = Double.MAX_VALUE;
        double targetUnitAtan = Double.MAX_VALUE;

        for (Unit unit : units) {
            // 같은 유닛
            if (this == unit) {
                continue;
            }

            if (!unit.isVisible()) {
                continue;
            }

            if (unit.unitType.equals(UnitType.GROUND)) {
                continue;
            }

            if (!(Math.abs(this.position.getX() - unit.position.getX()) <= 1 && Math.abs(this.position.getY() - unit.position.getY()) <= 1)) {
                continue;
            }

            int unitDist = super.position.getDistance(unit.position);
            double unitAtan = super.position.getAtan(unit.position);
            boolean setTarget = false;
            // 공격범위
            if (targetUnit == null) {
                setTarget = true;
            } else {
                // 체력 1순위
                if (unit.hp < targetUnit.hp) {
                    setTarget = true;
                } else if (unit.hp == targetUnit.hp) {
                    // 거리 2순위
                    if (unitDist < targetUnitDist) {
                        setTarget = true;
                    } else if (unitDist == targetUnitDist) {
                        // Atan 3순위
                        if (unitAtan > targetUnitAtan) {
                            setTarget = true;
                        }
                    }
                }
            }

            if (setTarget) {
                targetUnit = unit;
                targetUnitDist = unitDist;
                targetUnitAtan = unitAtan;
            }
        }
        this.attackIntentOrNull = (targetUnit != null) ? new AttackIntent(this, targetUnit.getPosition()) : null;
    }

    @Override
    public void beforeUpdate() {
        if (this.hp == 0) {
            SimulationManager simulationManager = SimulationManager.getInstance();
            simulationManager.unregisterThinkable(this);
        }
    }
}
