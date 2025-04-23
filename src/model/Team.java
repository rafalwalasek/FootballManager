package model;

import java.util.ArrayList;

public class Team {
    private final double budget;
    private final int points;
    private final int tier;

    private final String teamName;
    private final ArrayList<Player> players = new ArrayList<>();

    public Team(String nameName, double budget, int points, int tier) {
        this.teamName = nameName;
        this.budget = budget;
        this.points = points;
        this.tier = tier;
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public String toString() {
        return teamName + " | Punkty: " + points;
    }

    public void addPlayerToTeam(Player player) {
        player.setTeam(this);
        players.add(player);
    }
    public void removePlayerFromTeam(Player player) {
        player.setTeam(null);
        players.remove(player);
    }
    public void getTeamInfo() {
        System.out.println(teamName + " | Budżet: " + String.format("%,.2f", budget) + "€ | Liga: " + tier);
    }
    public String saveTeamToFile() {
        return teamName + "; " + String.format("%.2f", budget) + "; " + points + "; " + tier;
    }
}
