package manager;

import model.Team;

import java.util.ArrayList;

public class LeagueManager {
    private static final int MAX_TEAMS = 8;

    private String name;
    private int tier;
    private final ArrayList<Team> teams = new ArrayList<>();

    public void addTeam(Team team) {
        if (teams.size() < MAX_TEAMS) {
            teams.add(team);
        } else {
            System.out.println("Nie można dodać więcej drużyn do Ligi: " + tier);
        }
    }
    public void displayTable() {
        int number = 1;
        for (Team team : teams) {
            System.out.print(number++ + ". ");
            System.out.println(team);
        }
    }
}
