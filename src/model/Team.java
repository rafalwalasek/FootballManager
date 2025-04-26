package model;

import java.util.ArrayList;

public class Team {
    private final double budget;
    private int points;
    private final int tier;
    private int matchesPlayed;
    private int goalsScored;
    private int goalsConceded;

    private final String teamName;
    private final ArrayList<Player> players = new ArrayList<>();

    public Team(String nameName, double budget, int points, int tier,
                int matchesPlayed, int goalsScored, int goalsConceded) {
        this.teamName = nameName;
        this.budget = budget;
        this.points = points;
        this.tier = tier;
        this.matchesPlayed = matchesPlayed;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
    }

    public String getTeamName() {
        return teamName;
    }
    public int getPoints() {
        return points;
    }
    public int getTier() {
        return tier;
    }
    public int getMatchesPlayed() {
        return matchesPlayed;
    }
    public int getGoalsScored() {
        return goalsScored;
    }
    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }
    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }
    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return teamName + " \t\t " + matchesPlayed + " \t  " + goalsScored + ":" + goalsConceded + " \t " + points;
    }

    private void addPlayerToTeam(Player player) {
        player.setTeam(this);
        players.add(player);
    }
    private void removePlayerFromTeam(Player player) {
        player.setTeam(null);
        players.remove(player);
    }
    public void getTeamInfo() {
        System.out.println(teamName + " | Budżet: " + String.format("%,.2f", budget) + "€ | Liga: " + tier);
    }
    public String saveTeamToFile() {
        return teamName + "; " + String.format("%.2f", budget) + "; " + points + "; " + tier + "; " +
                matchesPlayed + "; " + goalsScored + "; " + goalsConceded;
    }
}
