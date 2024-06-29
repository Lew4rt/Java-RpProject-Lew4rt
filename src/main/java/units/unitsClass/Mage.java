package units.unitsClass;

import teams.Team;
import units.MagicalUnit;
import units.Unit;
import units.enums.AttackType;

// --> Interface Implementation <--
// A class that implements an interface must provide implementations for all of the interface’s abstract methods.
// To implement an interface use the implements keyword.

public class Mage extends MagicalUnit implements MageInterface {

    public Mage(String name, Team team){
        super("Mage", 2, 7, 0, AttackType.RANGED, 12, team);
        this.setName(name);
    }

    // --> Polymorphism <--
    // Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance.
    // Inheritance lets us inherit attributes and methods from another class. Polymorphism uses those methods to perform different tasks.
    // This allows us to perform a single action in different ways

    @Override
    public void castSpell(String spell) {
        if(target != null){
            String targetName = target.getName();
            float targetHealth = target.getHealth();
            float spellDamage = 0;
            int manaCost = 0;
            if(spell.equals("Pyroblast")){
                spellDamage = 6;
                manaCost = 4;
            } else if(spell.equals("Fireball")){
                spellDamage = 3;
                manaCost = 1;
            }else {
                System.out.println(this.getName() + " try to use " + spell + " but the spell it's not learned");
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
            if(this.getMana() < manaCost){
                System.out.println(this.getName() + "tries to use a spell but is out of mana");
            }
            System.out.println(this.getName() + " cast a " + spell + " to " + targetName);

            this.setMana(this.getMana() - manaCost);
            float targetNewHealth = targetHealth - spellDamage;
            target.setHealth(targetNewHealth);
            if(targetNewHealth <= 0){
                System.out.println(this.getName() + " now have " + this.getMana() + "MP");
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
            System.out.println(this.getName() + " now have " + this.getMana() + "MP");
            System.out.println(targetName + " receives " + spellDamage + " points of damage and now have " + target.getHealth() + "HP" );
        }else{
            System.out.println(this.getName() + " do not have a target.");
        }
    }
}
