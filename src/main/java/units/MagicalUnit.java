package units;

import teams.Team;
import units.enums.AttackType;

public abstract class MagicalUnit extends Unit{

    int mana;

    public MagicalUnit(String name, float damage, float health, int armor, AttackType attackType, int mana, Team team) {
        super(name, damage, health, armor, attackType, team);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
