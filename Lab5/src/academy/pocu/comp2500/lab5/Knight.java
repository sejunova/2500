package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private Pet pet;

    public Knight(String name, int Hp, int attack, int defense) {
        super(name, Hp, attack, defense);
    }

    public void setPet(Pet petOrNull) {
        this.pet = petOrNull;
    }

    public void attackTogether(Barbarian enemy) {
        if (this == enemy) {
            return;
        }

        if (this.pet == null) {
            return;
        }

        int damage = Math.max((this.attack + pet.getAttack() - enemy.defense) / 2, 1);
        enemy.currentHp = Math.max(enemy.currentHp - damage, 0);
    }
}
