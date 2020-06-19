package academy.pocu.comp2500.assignment3;

import java.util.Set;

public abstract class Unit {
    // 표식	유닛 종류	시야	AoE	AP	HP	공격 대상
    protected IntVector2D position;
    protected char symbol;
    protected UnitType unitType;
    protected int sight;
    protected int aoe;
    protected int ap;
    protected int hp;
    protected Set<UnitType> attackableUnitType;

    protected Unit(IntVector2D position) {
        this.position = position;
    }

    public final IntVector2D getPosition() {
        return this.position;
    }

    public int getHp() {
        return this.hp;
    }

    public AttackIntent attack() {
        return null;
    };

    public void onAttacked(int damage) {

    };

    public void onSpawn() {

    };

    public char getSymbol() {
        return this.symbol;
    };
}