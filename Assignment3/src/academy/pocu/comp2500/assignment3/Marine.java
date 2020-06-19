package academy.pocu.comp2500.assignment3;

import java.util.EnumSet;

public class Marine extends Unit {
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
}
