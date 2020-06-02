package academy.pocu.comp2500.lab5;

import java.util.HashMap;
import java.util.Map;

public class Gladiator extends Barbarian {
    private Map<String, Move> moveSet;

    public Gladiator(String name, int Hp, int attack, int defense) {
        super(name, Hp, attack, defense);
        this.moveSet = new HashMap<>();
    }

    public boolean addMove(Move move) {
        if (this.moveSet.size() == 4) {
            return false;
        }
        if (!this.moveSet.containsKey(move.getMoveName())) {
            this.moveSet.put(move.getMoveName(), move);
            return true;
        }
        return false;
    }

    public boolean removeMove(String moveName) {
        if (this.moveSet.containsKey(moveName)) {
            this.moveSet.remove(moveName);
            return true;
        }
        return false;
    }

    public void attack(String moveName, Barbarian enemy) {
        if (this == enemy) {
            return;
        }

        if (!this.moveSet.containsKey(moveName)) {
            return;
        }

        if (this.moveSet.get(moveName).getCurrentPowerPoint() == 0) {
            return;
        }
        Move move = this.moveSet.get(moveName);
        int damage = Math.max((int) ((double) this.attack / enemy.defense * move.getPower() / 2), 1);
        enemy.currentHp = Math.max(enemy.currentHp - damage, 0);
        move.setCurrentPowerPoint(Math.max(move.getCurrentPowerPoint() - 1, 0));
    }

    public void rest() {
        this.currentHp = Math.min(this.maxHp, this.currentHp + 10);
        for (Move move : this.moveSet.values()) {
            move.setCurrentPowerPoint(Math.min(move.getMaxPowerPoint(), move.getCurrentPowerPoint() + 1));
        }
    }
}
