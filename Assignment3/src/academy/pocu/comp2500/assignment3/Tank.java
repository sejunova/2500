package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.EnumSet;

public class Tank extends Unit implements Movable, Thinkable {
    private boolean isTankMode = true;
    private boolean isMovingTowardRight;
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
        this.isMovingTowardRight = intVector2D.getX() != 15;
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
        for (Unit unit : units) {
            // 같은 유닛
            if (this == unit) {
                continue;
            }
            // 시야 범위 밖이라면 고려 안함.
            if (!this.position.isOtherUnitInSight(unit.position, super.sight)) {
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

        // 시즈모드
        if (!this.isTankMode) {
            // 시야 안에 적이 있다면
            if (findUnit) {
                // 공격 대상이 있으면 공격하고 없으면 제자리
                this.attackIntentOrNull = (targetUnit != null) ? new AttackIntent(this, targetUnit.getPosition()) : null;
            } else {
                // 시야 안에 적이 없으면 탱크모드
                this.isTankMode = true;
            }
            this.movePosition = super.position;
        } else {
            // 탱크모드
            if (findUnit) {
                // 시야 안에 적이 있으면 시즈모드
                this.attackIntentOrNull = null;
                this.movePosition = super.position;
                this.isTankMode = true;
            } else {
                // 시야 안에 적이 없으면 이동
                if (this.isMovingTowardRight) {
                    this.movePosition = new IntVector2D(this.position.getX() + 1, this.position.getY());
                    if (this.movePosition.getX() == 15) {
                        this.isMovingTowardRight = false;
                    }
                } else {
                    this.movePosition = new IntVector2D(this.position.getX() - 1, this.position.getY());
                    if (this.movePosition.getX() == 0) {
                        this.isMovingTowardRight = true;
                    }
                }
            }
        }
    }

    @Override
    public void onAttacked(int damage) {
        if (!this.isTankMode) {
            this.hp = Math.max(0, this.hp - damage);
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
