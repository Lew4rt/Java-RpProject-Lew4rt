import teams.Team;
import units.Unit;
import units.classes.Priest;
import units.classes.Mage;
import units.classes.Rogue;
import units.classes.Warrior;

public class Main {
    public static void main(String[] args){
        Team teamBlue = new Team("Los Trompeteros");
        Team teamRed = new Team("Noo La Maravilla No");

        Mage lewi = new Mage("Lewi", teamBlue);
        Warrior tami = new Warrior("Tamilsson", teamBlue);
        Rogue brandon = new Rogue("Brancas", teamRed);
        Priest dema = new Priest("DeMaa", teamRed);

        Unit[] teamBlueMembers = {lewi, tami};
        teamBlue.setMembers(teamBlueMembers);

        Unit[] teamRedMembers = {brandon, dema};
        teamRed.setMembers(teamRedMembers);

        System.out.println(teamBlue.getName() + " (" + teamBlue.getMembers()[0].getName() + " & " +
                teamBlue.getMembers()[1].getName() + ")" + " VS " + teamRed.getName() + " (" +
                teamRed.getMembers()[0].getName() + " & " + teamRed.getMembers()[1].getName() + ")");

        // Wait for x seconds
        preparationTime(3000, false);

        System.out.println("FIGHT");

        preparationTime(4000, false);

        tami.setTarget(brandon);
        tami.attack();

        preparationTime(4000, true);

        brandon.setTarget(lewi);
        brandon.useAbility("Backstab");

        preparationTime(4000, true);

        dema.setTarget(brandon);
        dema.castHealing("Flash Heal");

        preparationTime(4000, true);

        lewi.setTarget(brandon);
        lewi.castSpell("Pyroblast");

        preparationTime(4000, true);

        tami.setTarget(dema);
        tami.useAbility("Execute");

        preparationTime(4000, true);

        brandon.setTarget(dema);
        brandon.useAbility("Backstab");

        preparationTime(4000, true);

        dema.setTarget(lewi);
        dema.castHealing("Greater Heal");

        preparationTime(4000, true);

        lewi.setTarget(dema);
        lewi.castSpell("Scorch");

        preparationTime(4000, true);

        tami.setTarget(brandon);
        tami.useAbility("Execute");

        preparationTime(4000, true);

        dema.setTarget(tami);
        dema.attack();

        preparationTime(4000, true);

        lewi.setTarget(brandon);
        lewi.castSpell("Fireball");

        preparationTime(4000, true);

        tami.setTarget(dema);
        tami.useAbility("Slam");

        preparationTime(4000, true);

        dema.attack();

        preparationTime(4000, true);

        lewi.setTarget(dema);
        lewi.castSpell("Pyroblast");

        preparationTime(4000, false);

    }

    private static void preparationTime(int time, boolean nextTurn){
        if (nextTurn){
            System.out.println("--> NEXT TURN <--");
        }
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
