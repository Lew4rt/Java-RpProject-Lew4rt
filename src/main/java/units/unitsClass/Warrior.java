package units.unitsClass;

import teams.Team;
import units.PhysicalUnit;
import units.Unit;
import units.enums.AttackType;

// --> Inheritance <--
// In Java, it is possible to inherit attributes and methods from one class to another. We group the "inheritance concept" into two categories:
//      subclass (child) - the class that inherits from another class
//      superclass (parent) - the class being inherited from
// To inherit from a class, use the extends keyword.

public class Warrior extends PhysicalUnit implements WarriorInterface{

    public Warrior(String name, Team team){
        super("Warrior", 2, 10, 2, AttackType.MELEE, 10, team);
        this.setName(name);
    }

    @Override
    public void useAbility(String ability) {
        if(target != null){
            String targetName = target.getName();
            float targetHealth = target.getHealth();
            float abilityDamage = 0;
            int staminaCost = 0;
            if(ability.equals("Execute")){
                abilityDamage = 6;
                staminaCost = 2;
            } else if(ability.equals("Slam")){
                abilityDamage = 3;
                staminaCost = 1;
            }else {
                System.out.println(this.getName() + " try to use " + ability + " but the ability it's not learned");
                return;
            }
            if(targetHealth <= 0){
                System.out.println(this.getName() + " tries to attack " + targetName + " but is dead");
                return;
            }
            if(target.getTeam().getName().equals(this.getTeam().getName())){
                System.out.println(this.getName() + " tries to attack " + targetName + " but they're in the same team");
                return;
            }
            if(this.getStamina() < staminaCost){
                System.out.println(this.getName() + "tries to use an ability but is out of stamina");
            }
            System.out.println(this.getName() + " use " + ability + " against " + targetName);
            if(ability.equals("Execute")) {
                if (targetHealth > target.getFullHealth() * 0.35) {
                    System.out.println("Target must be under 35% health to be executed");
                    return;
                }
            }
            this.setStamina(this.getStamina() - staminaCost);
            float targetNewHealth = targetHealth - abilityDamage;
            target.setHealth(targetNewHealth);
            if(targetNewHealth <= 0){
                System.out.println(this.getName() + " now have " + this.getStamina() + "SP");
                System.out.println(targetName + " has been killed by " + this.getName());
                boolean allDead = true;

                for (Unit member : target.getTeam().getMembers()){
                    if (member.getHealth() > 0) {
                        allDead = false;
                        break;
                    }
                }
                if (allDead) {
                    System.out.println("\n" + this.getTeam().getName() + " WINS!");
                }
                return;
            }
            System.out.println(this.getName() + " now have " + this.getStamina() + "SP");
            System.out.println(targetName + " receives " + abilityDamage + " points of damage and now have " + target.getHealth() + "HP" );
        }else{
            System.out.println(this.getName() + " do not have a target.");
        }
    }
}
