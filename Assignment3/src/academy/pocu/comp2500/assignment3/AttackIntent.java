package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class AttackIntent {
    private Unit attackUnit;
    private ArrayList<AttackInfo> attackInfos = new ArrayList<>();

    public AttackIntent(Unit attackUnit, IntVector2D area) {
        this.attackUnit = attackUnit;
        int aoe = attackUnit.getAoe();
        for (int x = area.getX() - aoe; x <= area.getX() + aoe; x++) {
            for (int y = area.getY() - aoe; y <= area.getY() + aoe; y++) {
                if (x >= 0 && x < 16 && y >= 0 && y < 8) {
                    // 피해치(x, y) = (공격 지점에서의 피해치) * (1 - 공격 지점으로부터의 거리 / (공격의 AoE 값 + 1))
                    IntVector2D targetArea = new IntVector2D(x, y);
                    int targetDist;
                    if (area.equals(targetArea)) {
                        targetDist = 0;
                    } else {
                        targetDist = Math.max(Math.abs(area.getX() - targetArea.getX()), Math.abs(area.getY() - targetArea.getY()));
                    }

                    int ap = (int) (attackUnit.getAp() * (1 - targetDist / (double) (aoe + 1)));
                    this.attackInfos.add(new AttackInfo(targetArea, ap));
                }
            }
        }
    }

    public Unit getAttackUnit() {
        return this.attackUnit;
    }

    public ArrayList<AttackInfo> getAttackInfos() {
        return attackInfos;
    }

    @Override
    public String toString() {
        return "attackUnit=" + attackUnit;
    }
}