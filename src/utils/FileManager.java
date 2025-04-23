package utils;

import manager.TeamManager;
import model.Player;
import model.Team;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
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
                String[] playerData = player.split(";\\s");

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
    public void loadTeamsFromFile(String fileName, Set<Team> teams) {
        File file = new File(fileName);
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {

                String team = reader.nextLine();
                String[] teamData = team.split(";\\s");

                String name = teamData[0];
                double budget = Double.parseDouble(teamData[1].replace(",", "."));
                int points = Integer.parseInt(teamData[2]);
                int league = Integer.parseInt(teamData[3]);

                teams.add(new Team(name, budget, points, league));

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
