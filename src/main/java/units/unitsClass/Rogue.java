package units.unitsClass;

import teams.Team;
import units.PhysicalUnit;
import units.Unit;
import units.enums.AttackType;

public class Rogue extends PhysicalUnit implements RogueInterface {

    public Rogue(String name, Team team){
        super("Rogue", 2, 7, 1, AttackType.MELEE, 12, team);
        this.setName(name);
    }

    @Override
    public void useAbility(String ability) {
        if(target != null){
            String targetName = target.getName();
            float targetHealth = target.getHealth();
            float abilityDamage = 0;
            int staminaCost = 0;
            if(ability.equals("Eviscerate")){
                abilityDamage = 5;
                staminaCost = 4;
            } else if(ability.equals("Backstab")){
                abilityDamage = 3;
                staminaCost = 2;
            }else {
                System.out.println(this.getName() + " try to use " + ability + " but the ability it's not learned");
                return;
            }
            if(target.getTeam().getName().equals(this.getTeam().getName())){
                System.out.println(this.getName() + " tries to attack " + targetName + " but they're in the same team");
                return;
            }
            if(targetHealth <= 0){
                System.out.println(this.getName() + " tries to attack " + targetName + " but is dead");
                return;
            }
            if(this.getStamina() < staminaCost){
                System.out.println(this.getName() + "tries to use an ability but is out of stamina");
            }
            System.out.println(this.getName() + " use " + ability + " against " + targetName);
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
