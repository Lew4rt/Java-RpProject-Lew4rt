package units;

import teams.Team;
import units.enums.AttackType;

// --> Abstract Class <--
// An abstract class is a class that cannot be instantiated directly.
// Instead, it is meant to be extended by other classes, which can provide concrete implementations of its abstract methods.

public abstract class Unit {
    String name;
    float damage;
    float health;
    float fullHealth;
    int armor;
    AttackType attackType;
    public Unit target = null;
    public Team team;

    public void run() {
        System.out.println(name + " is running");
    }
    public void attack() {
        if(target != null){
            String targetName = target.getName();
            float targetHealth = target.getHealth();
            int targetArmor = target.getArmor();
            if(target.getTeam().getName().equals(team.getName())){
                System.out.println(name + " tries to attack " + targetName + " but they're in the same team");
            }
            if(targetHealth <= 0){
                System.out.println(name + " tries to attack " + targetName + " but is dead");
                return;
            }
            System.out.println(name + " is attacking " + targetName);
            float damageInflicted = calculateDamageAfterArmor(damage, targetArmor);
            float targetNewHealth = targetHealth - damageInflicted;
            if(targetNewHealth <= 0){
                System.out.println(targetName + " has been killed by " + name);
                boolean allDead = true;

                for (Unit member : target.getTeam().getMembers()){
                    if (member.getHealth() > 0) {
                        allDead = false;
                        break;
                    }
                }
                if (allDead) {
                    System.out.println("\n" + team.getName() + " WINS!");
                }
                return;
            }
            target.setHealth(targetNewHealth);
            System.out.println(targetName + " receives " + damageInflicted + " points of damage and now have " + target.getHealth() + "HP" );
        }else{
            System.out.println(name + " do not have a target.");
        }
    }

    private static float calculateDamageAfterArmor(float damage, int armor) {
        if (armor == 0) {
            return damage;
        }

        // Each armor point reduces damage by 10%
        float reductionFactor = 1 - (armor * 0.1f);

        // Ensure reduction factor doesn't go below 0
        if (reductionFactor < 0) {
            reductionFactor = 0;
        }

        return damage * reductionFactor;
    }

    // Constructor

    public Unit(String name, float damage, float health, int armor, AttackType attackType, Team team) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.fullHealth = health;
        this.armor = armor;
        this.attackType = attackType;
        this.team = team;
    }


    // --> Principle of encapsulation <--
    // Refers to the bundling of attributes and methods that operates on the data,
    // preventing external code from being concerned with the internal workings of an object.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public Unit getTarget() {
        return target;
    }

    public void setTarget(Unit target) {
        this.target = target;
    }

    public float getFullHealth() {
        return fullHealth;
    }

    public void setFullHealth(float fullHealth) {
        this.fullHealth = fullHealth;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
