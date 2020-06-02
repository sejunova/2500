package academy.pocu.comp2500.lab5;

public class Barbarian {
    protected String name;
    protected int maxHp;
    protected int currentHp;
    protected int attack;
    protected int defense;

    public Barbarian(String name, int maxHp, int attack, int defense) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attack = attack;
        this.defense = defense;
    }


    public int getHp() {
        return currentHp;
    }

    public void attack(Barbarian enemy) {
        if (this == enemy) {
            return;
        }
        int damage = Math.max((this.attack - enemy.defense) / 2, 1);
        enemy.currentHp = Math.max(enemy.currentHp - damage, 0);
    }

    public boolean isAlive() {
        return this.currentHp > 0;
    }
}
