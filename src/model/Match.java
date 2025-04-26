package model;

import manager.TeamManager;
import utils.FileManager;
import utils.RandomGenerator;

public class Match {
    private int scoreTeam_1;
    private int scoreTeam_2;

    private final RandomGenerator randomGenerator = new RandomGenerator();
    private final FileManager fileManager = new FileManager();
    private TeamManager teamManager;
    private final Team team_1;
    private final Team team_2;

    public Match(Team team_1, Team team_2) {
        this.team_1 = team_1;
        this.team_2 = team_2;
    }

    public void simulateMatch() {
        this.scoreTeam_1 = randomGenerator.goals();
        this.scoreTeam_2 = randomGenerator.goals();
    }
    public void displayResult() {
        System.out.println(team_1.getTeamName() + " " + scoreTeam_1 + ":" + scoreTeam_2 + " " + team_2.getTeamName());
    }
    public void updateTeamsStats() {
        team_1.setMatchesPlayed(team_1.getMatchesPlayed() + 1);
        team_2.setMatchesPlayed(team_2.getMatchesPlayed() + 1);
        team_1.setGoalsScored(team_1.getGoalsScored() + scoreTeam_1);
        team_2.setGoalsScored(team_2.getGoalsScored() + scoreTeam_2);
        team_1.setGoalsConceded(team_1.getGoalsConceded() + scoreTeam_2);
        team_2.setGoalsConceded(team_2.getGoalsConceded() + scoreTeam_1);

        if (scoreTeam_1 > scoreTeam_2) {
            team_1.setPoints(team_1.getPoints() + 3);
        } else if (scoreTeam_2 > scoreTeam_1) {
            team_2.setPoints(team_2.getPoints() + 3);
        } else {
            team_1.setPoints(team_1.getPoints() + 1);
            team_2.setPoints(team_2.getPoints() + 1);
        }

        fileManager.updateTeamInFile("teams.txt", team_1, team_2);
    }
}
