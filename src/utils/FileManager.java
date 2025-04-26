package utils;

import manager.TeamManager;
import model.Player;
import model.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    private TeamManager teamManager;

    public void setTeamManager(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    public void checkOrCreateFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File has been created.");
            } catch (IOException e) {
                System.out.println("Error while creating the file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists.");
        }
    }
    public void appendToFile(String fileName, String text) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(text + "\n");
            System.out.println("Data has been appended.");
        } catch (IOException e) {
            System.out.println("Error while appending to the file.");
            e.printStackTrace();
        }
    }
    public void loadPlayersFromFile(String fileName, ArrayList<Player> players) {
        File file = new File(fileName);
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {

                String player = reader.nextLine();
                String[] playerData = player.split(";\\s*");

                String name = playerData[0];
                String surname = playerData[1];
                int age = Integer.parseInt(playerData[2]);
                String position = playerData[3];
                String teamName = playerData[4];
                Team team = teamManager.getTeamByName(teamName);
                double worth = Double.parseDouble(playerData[5].replace(",", "."));

                players.add(new Player(name, surname, age, position, team, worth));

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void loadTeamsFromFile(String fileName, ArrayList<Team> teams) {
        File file = new File(fileName);
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {

                String team = reader.nextLine();
                String[] teamData = team.split(";\\s*");

                String name = teamData[0];
                double budget = Double.parseDouble(teamData[1].replace(",", "."));
                int points = Integer.parseInt(teamData[2]);
                int tier = Integer.parseInt(teamData[3]);
                int matchesPlayed = Integer.parseInt(teamData[4]);
                int goalsScored = Integer.parseInt(teamData[5]);
                int goalsConceded = Integer.parseInt(teamData[6]);

                teams.add(new Team(name, budget, points, tier, matchesPlayed, goalsScored, goalsConceded));

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void updateTeamInFile(String fileName, Team updateTeam_1, Team updateTeam_2) {
        ArrayList<Team> teams = new ArrayList<>();

        loadTeamsFromFile(fileName, teams);
        for (Team team : teams) {
            if (team.getTeamName().equalsIgnoreCase(updateTeam_1.getTeamName())) {
                updateTeam(team, updateTeam_1);
            } else if (team.getTeamName().equalsIgnoreCase(updateTeam_2.getTeamName())) {
                updateTeam(team, updateTeam_2);
            }
        }
        saveTeamsToFile(fileName, teams);
    }
    private void updateTeam(Team team, Team updateTeam) {
        team.setPoints(updateTeam.getPoints());
        team.setGoalsScored(updateTeam.getGoalsScored());
        team.setGoalsConceded(updateTeam.getGoalsConceded());
        team.setMatchesPlayed(updateTeam.getMatchesPlayed());
    }
    private void saveTeamsToFile(String fileName, ArrayList<Team> teams) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Team team : teams) {
                writer.write(team.saveTeamToFile());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving the teams.");
            e.printStackTrace();
        }
    }
}
