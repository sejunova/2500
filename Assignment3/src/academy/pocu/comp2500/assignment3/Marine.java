package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.EnumSet;

public class Marine extends Unit implements Movable, Thinkable {
    private IntVector2D movePosition;

    public Marine(IntVector2D position) {
        super(position);
        super.symbol = 'M';
        super.unitType = UnitType.GROUND;
        super.sight = 2;
        super.aoe = 0;
        super.ap = 6;
        super.hp = 35;
        super.attackableUnitType = EnumSet.allOf(UnitType.class);
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
        double targetUnitDist = Double.MAX_VALUE;
        double targetUnitAtan = Double.MAX_VALUE;


        Unit unitToMove = null;
        double unitToMoveDist = Double.MAX_VALUE;
        double unitToMoveAtan = Double.MAX_VALUE;

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

            int unitDist = super.position.getDistance(unit.position);
            double unitAtan = super.position.getAtan(unit.position);
            boolean setTarget = false;
            // 공격범위
            if (unitDist <= 1) {
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
            }

            if (setTarget) {
                targetUnit = unit;
                targetUnitDist = unitDist;
                targetUnitAtan = unitAtan;
            }

            if (targetUnit != null) {
                continue;
            }

            boolean setMoveTo = false;
            if (unitToMove == null) {
                setMoveTo = true;
            } else {
                // 거리 1순위
                if (unitDist < unitToMoveDist) {
                    setMoveTo = true;
                } else if (unitDist == unitToMoveDist) {
                    // hp 2순위
                    if (unit.hp < unitToMove.hp) {
                        setMoveTo = true;
                    } else if (unit.hp == unitToMove.hp) {
                        // atan 2순위
                        if (unitAtan > unitToMoveAtan) {
                            setMoveTo = true;
                        }
                    }
                }
            }
            if (setMoveTo) {
                unitToMove = unit;
                unitToMoveDist = unitDist;
                unitToMoveAtan = unitAtan;
            }
        }
        if (targetUnit != null) {
            this.attackIntentOrNull = new AttackIntent(this, targetUnit.getPosition());
            this.movePosition = super.position;
            return;
        }

        if (unitToMove != null) {
            this.attackIntentOrNull = null;
            if (unitToMove.position.getY() != super.position.getY()) {
                int nextY = (unitToMove.position.getY() > super.position.getY()) ? super.position.getY() + 1 : super.position.getY() - 1;
                this.movePosition = new IntVector2D(super.position.getX(), nextY);
            } else {
                int nextX = (unitToMove.position.getX() > super.position.getX()) ? super.position.getX() + 1 : super.position.getX() - 1;
                this.movePosition = new IntVector2D(nextX, super.position.getY());
            }
            return;
        }

        this.attackIntentOrNull = null;
        this.movePosition = super.position;
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
