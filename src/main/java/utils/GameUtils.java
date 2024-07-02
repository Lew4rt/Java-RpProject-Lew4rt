package utils;

import teams.Team;
import units.Unit;

public class GameUtils {

    public static void checkWinner(Team team1, Team team2) {
        boolean team1Wipe = true;
        boolean team2Wipe = true;

        for (Unit member : team1.getMembers()) {
            if (member.getHealth() > 0) {
                team1Wipe = false;
                break;
            }
        }

        for (Unit member : team2.getMembers()) {
            if (member.getHealth() > 0) {
                team2Wipe = false;
                break;
            }
        }

        if (team1Wipe && !team2Wipe) {
            System.out.println("\n" + team2.getName() + " WINS!");
        } else if (!team1Wipe && team2Wipe) {
            System.out.println("\n" + team1.getName() + " WINS!");
        }
    }
}
