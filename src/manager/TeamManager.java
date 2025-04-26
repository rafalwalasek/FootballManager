package manager;

import model.Team;
import utils.FileManager;
import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamManager {
    private final ArrayList<Team> teams = new ArrayList<>();
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private final FileManager fileManager = new FileManager();

    private final Scanner scanner;

    public TeamManager(Scanner scanner) {
        this.scanner = scanner;
        fileManager.loadTeamsFromFile("teams.txt", teams);
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void addTeam() {
        System.out.print("Nazwa drużyny: ");
        String name = scanner.nextLine();

        double budget = randomGenerator.budget();
        int points = 0;

        System.out.print("Liga (1/2): ");
        int league = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Mecze: ");
        int matchesPlayed = scanner.nextInt();
        scanner.nextLine();

        int goalsScored = randomGenerator.goals();
        int goalsConceded = randomGenerator.goals();

        Team team = new Team(name, budget, points, league, matchesPlayed, goalsScored, goalsConceded);
        teams.add(team);

        String teamToFile = team.saveTeamToFile();
        String fileName = "teams.txt";
        saveSingleTeamToFile(fileName, teamToFile);
    }
    private void saveSingleTeamToFile(String fileName, String teamToFile) {
        fileManager.checkOrCreateFile(fileName);
        fileManager.appendToFile(fileName, teamToFile);
    }
    public void displayTeams() {
        int number = 1;
        for (Team team : teams) {
            System.out.print(number++ + ". ");
            team.getTeamInfo();
        }
    }
    public Team getTeamByName(String name) {
        for (Team team : teams) {
            if (team.getTeamName().equalsIgnoreCase(name.trim())) {
                return team;
            }
        }
        return null;
    }
}
