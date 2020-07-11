package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.EnumSet;

public class Tank extends Unit implements Movable, Thinkable {
    private boolean isTankMode = true;
    private boolean isMovingTowardRight = true;
    private IntVector2D movePosition;

    public Tank(IntVector2D intVector2D) {
        super(intVector2D);
        super.symbol = 'T';
        super.unitType = UnitType.GROUND;
        super.sight = 3;
        super.aoe = 1;
        super.ap = 8;
        super.hp = 85;
        super.attackableUnitType = EnumSet.of(UnitType.GROUND);
    }

    @Override
    public void onSpawn() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        simulationManager.registerUnit(this);
        simulationManager.registerMovable(this);
        simulationManager.registerThinkable(this);
    }


    @Override
    public void move() {
        super.position = this.movePosition;
    }

    @Override
    public void think() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        ArrayList<Unit> units = simulationManager.getUnits();

        Unit targetUnit = null;
        double targetUnitAtan = Double.MAX_VALUE;


        boolean findUnit = false;
        for (Unit unit: units) {
            // 같은 유닛
            if (this == unit) {
                continue;
            }
            // 시야 범위 밖이라면 고려 안함.
            if (!this.position.isInSight(unit.position, super.sight)) {
                continue;
            }

            if (!unit.isVisible()) {
                continue;
            }

            if (unit.unitType.equals(UnitType.AIR)) {
                continue;
            }

            findUnit = true;
            // 탱크모드시 시즈모드 전환하고 끝
            if (this.isTankMode) {
                this.attackIntentOrNull = null;
                this.movePosition = super.position;
                this.isTankMode = false;
                return;
            }

            double unitAtan = super.position.getAtan(unit.position);
            boolean setTarget = false;
            // 공격범위
            int unitX = unit.position.getX();
            int unitY = unit.position.getY();
            if ((Math.abs(unitX - super.position.getX()) == 2 && Math.abs(unitY - super.position.getY()) <= 1) || (Math.abs(unitY - super.position.getY()) == 2 && Math.abs(unitX - super.position.getX()) <= 1)) {
                if (targetUnit == null) {
                    setTarget = true;
                } else {
                    // 체력 1순위
                    if (unit.hp < targetUnit.hp) {
                        setTarget = true;
                    } else if (unit.hp == targetUnit.hp) {
                        // Atan 2순위
                        if (unitAtan > targetUnitAtan) {
                            setTarget = true;
                        }
                    }
                }
            }

            if (setTarget) {
                targetUnit = unit;
                targetUnitAtan = unitAtan;
            }
        }

        if (!this.isTankMode) {
            this.attackIntentOrNull = (targetUnit != null) ? new AttackIntent(this, targetUnit.getPosition()) : null;
            this.movePosition = super.position;
        } else {
            if (!findUnit) {
                this.attackIntentOrNull = null;
                this.movePosition = super.position;
                this.isTankMode = true;
                return;
            }
            if (this.isMovingTowardRight) {
                if (this.position.getX() == 15) {
                    this.isMovingTowardRight = false;
                    this.movePosition = new IntVector2D(this.position.getX() - 1, this.position.getY());
                } else {
                    this.movePosition = new IntVector2D(this.position.getX() + 1, this.position.getY());
                }
            } else {
                if (this.position.getX() == 0) {
                    this.isMovingTowardRight = true;
                    this.movePosition = new IntVector2D(this.position.getX() + 1, this.position.getY());
                } else {
                    this.movePosition = new IntVector2D(this.position.getX() - 1, this.position.getY());
                }
            }
        }
    }

    @Override
    public void onAttacked(int damage) {
        if (!this.isTankMode) {
            damage *= 2;
        }
        this.hp = Math.max(0, this.hp - damage);
    }

    @Override
    public void beforeUpdate() {
        if (this.hp == 0) {
            SimulationManager simulationManager = SimulationManager.getInstance();
            simulationManager.unregisterThinkable(this);
            simulationManager.unregisterMovable(this);
        }
    }
}
