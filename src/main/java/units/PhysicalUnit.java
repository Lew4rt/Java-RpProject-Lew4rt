package units;

import teams.Team;
import units.enums.AttackType;

public abstract class PhysicalUnit extends Unit {

    int stamina;

    public PhysicalUnit(String name, float damage, float health, int armor, AttackType attackType, int stamina, Team team) {
        super(name, damage, health, armor, attackType, team);
        this.stamina = stamina;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
