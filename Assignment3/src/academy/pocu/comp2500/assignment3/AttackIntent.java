package academy.pocu.comp2500.assignment3;

import java.util.Set;

public class AttackIntent {
    private IntVector2D position;
    private int ap;
    private Set<UnitType> attackableUnitType;
    private int aoe;

    public AttackIntent(IntVector2D position, int ap, Set<UnitType> unitTypes, int aoe) {
        this.position = position;
        this.ap = ap;
        this.attackableUnitType = unitTypes;
        this.aoe = aoe;
    }

    public IntVector2D getPosition() {
        return position;
    }

    public int getAp() {
        return ap;
    }

    public Set<UnitType> getAttackableUnitType() {
        return attackableUnitType;
    }

    public int getAoe() {
        return aoe;
    }

}