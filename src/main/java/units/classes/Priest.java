package units.classes;

import teams.Team;
import units.MagicalUnit;
import units.enums.AttackType;

public class Priest extends MagicalUnit implements Healer {

    public Priest(String name, Team team){
        super("Healer", 1, 8, 0, AttackType.RANGED, 10, team);
        this.setName(name);
    }

    @Override
    public void castHealing(String spell) {
        if(target != null){
            String targetName = target.getName();
            float targetHealth = target.getHealth();
            float spellHealing = 0;
            int manaCost = 0;
            if(spell.equals("Flash Heal")){
                spellHealing = 2;
                manaCost = 1;
            } else if(spell.equals("Greater Heal")){
                spellHealing = 4;
                manaCost = 2;
            }else {
                System.out.println(this.getName() + " try to use " + spell + " but the spell it's not learned");
                return;
            }
            if(!target.getTeam().getName().equals(this.getTeam().getName())){
                System.out.println(this.getName() + " tries to heal " + targetName + " but they're in different teams");
                return;
            }
            if(targetHealth <= 0){
                System.out.println(this.getName() + " tries to heal " + targetName + " but is dead");
                return;
            }
            if(this.getMana() < manaCost){
                System.out.println(this.getName() + "tries to use a spell but is out of mana");
            }
            System.out.println(this.getName() + " cast a " + spell + " to " + targetName);

            this.setMana(this.getMana() - manaCost);
            float targetNewHealth = targetHealth + spellHealing;
            target.setHealth(targetNewHealth);
            System.out.println(this.getName() + " now have " + this.getMana() + "MP");
            System.out.println(targetName + " receives " + spellHealing + " points of healing and now have " + target.getHealth() + "HP" );
        }else{
            System.out.println(this.getName() + " do not have a target.");
        }
    }
}
