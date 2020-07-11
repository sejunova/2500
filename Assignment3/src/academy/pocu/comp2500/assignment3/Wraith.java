package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.EnumSet;

public class Wraith extends Unit implements Movable, Thinkable {
    private boolean shieldOn = true;
    private boolean isAttacked = false;
    private IntVector2D movePosition;
    private IntVector2D startPosition;

    public Wraith(IntVector2D intVector2D) {
        super(intVector2D);
        super.symbol = 'W';
        super.unitType = UnitType.AIR;
        super.sight = 4;
        super.aoe = 0;
        super.ap = 6;
        super.hp = 80;
        super.attackableUnitType = EnumSet.allOf(UnitType.class);
        this.startPosition = intVector2D;
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
        int targetUnitTypePriority = 0;


        Unit unitToMove = null;
        double unitToMoveDist = Double.MAX_VALUE;
        double unitToMoveAtan = Double.MAX_VALUE;
        int unitToMoveTypePriority = 0;

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
            int unitTypePriority = (unit.unitType.equals(UnitType.AIR)) ? 2 : 1;
            boolean setTarget = false;
            // 공격범위
            if (unitDist <= 1) {
                if (targetUnit == null) {
                    setTarget = true;
                } else {
                    // 1순위 공중유닛
                    if (unitTypePriority > targetUnitTypePriority) {
                        setTarget = true;
                    } else if (unitTypePriority == targetUnitTypePriority) {
                        // 2순위 낮은 체력
                        if (unit.hp < targetUnit.hp) {
                            setTarget = true;
                        } else if (unit.hp == targetUnit.hp) {
                            // 거리 3순위
                            if (unitDist < targetUnitDist) {
                                setTarget = true;
                            } else if (unitDist == targetUnitDist) {
                                // Atan 4순위
                                if (unitAtan > targetUnitAtan) {
                                    setTarget = true;
                                }
                            }
                        }
                    }
                }
            }

            if (setTarget) {
                targetUnit = unit;
                targetUnitDist = unitDist;
                targetUnitAtan = unitAtan;
                targetUnitTypePriority = unitTypePriority;
            }

            if (targetUnit != null) {
                continue;
            }

            boolean setMoveTo = false;
            if (unitToMove == null) {
                setMoveTo = true;
            } else {
                if (unitTypePriority > unitToMoveTypePriority) {
                    setMoveTo = true;
                } else if (unitTypePriority == unitToMoveTypePriority) {
                    // 거리 2순위
                    if (unitDist < unitToMoveDist) {
                        setMoveTo = true;
                    } else if (unitDist == unitToMoveDist) {
                        // hp 3순위
                        if (unit.hp < unitToMove.hp) {
                            setMoveTo = true;
                        } else if (unit.hp == unitToMove.hp) {
                            // atan 4순위
                            if (unitAtan > unitToMoveAtan) {
                                setMoveTo = true;
                            }
                        }
                    }
                }
            }
            if (setMoveTo) {
                unitToMove = unit;
                unitToMoveDist = unitDist;
                unitToMoveAtan = unitAtan;
                unitToMoveTypePriority = unitTypePriority;
            }
        }

        if (targetUnit != null) {
            this.attackIntentOrNull = new AttackIntent(this, targetUnit.getPosition());
            this.movePosition = super.position;
            return;
        }

        IntVector2D toward;
        if (unitToMove != null) {
            toward = unitToMove.position;
        } else {
            toward = this.startPosition;
        }
        this.attackIntentOrNull = null;
        if (toward.equals(super.position)) {
            this.movePosition = toward;
        } else {
            if (toward.getY() != super.position.getY()) {
                int nextY = (toward.getY() > super.position.getY()) ? super.position.getY() + 1 : super.position.getY() - 1;
                this.movePosition = new IntVector2D(super.position.getX(), nextY);
            } else {
                int nextX = (toward.getX() > super.position.getX()) ? super.position.getX() + 1 : super.position.getX() - 1;
                this.movePosition = new IntVector2D(nextX, super.position.getY());
            }
        }
    }


    @Override
    public void onAttacked(int damage) {
        this.isAttacked = true;
        if (!this.shieldOn) {
            this.hp = Math.max(0, this.hp - damage);
        }
    }

    @Override
    public void beforeUpdate() {
        if (this.isAttacked) {
            this.shieldOn = false;
        }
        if (this.hp == 0) {
            SimulationManager simulationManager = SimulationManager.getInstance();
            simulationManager.unregisterThinkable(this);
            simulationManager.unregisterMovable(this);
        }
    }
}
