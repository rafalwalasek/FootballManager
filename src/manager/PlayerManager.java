package manager;

import model.Player;
import model.Team;
import utils.RandomGenerator;
import utils.FileManager;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerManager {
    private final ArrayList<Player> players = new ArrayList<>();
    private final RandomGenerator random = new RandomGenerator();
    private final FileManager fileManager = new FileManager();
    private TeamManager teamManager;

    private final Scanner scanner;

    public PlayerManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setTeamManager(TeamManager teamManager) {
        this.teamManager = teamManager;
        fileManager.setTeamManager(teamManager);
    }

    public void addPlayer() {
        System.out.print("Imię: ");
        String name = scanner.nextLine();

        System.out.print("Nazwisko: ");
        String surname = scanner.nextLine();

        System.out.print("Pozycja: ");
        String position = scanner.nextLine();

        System.out.print("Drużyna: ");
        String teamName = scanner.nextLine();
        Team team = findTeamByName(teamName);
//        Team team = null;
//        if (!teamName.isBlank()) {
//            team = findTeamByName(teamName);
//            if (team == null) {
//                System.out.println("Nie znaleziono drużyny o podanej nazwie.");
//            }
//        }

        int age = random.isValidAge();
        double worth = random.worth();

        Player player = new Player(name, surname, 0, position, team, worth);
        player.setAge(age);
        players.add(player);

        String playerToFile = player.savePlayerToFile();
        String fileName = "players.txt";
        saveSinglePlayerToFile(fileName, playerToFile);
    }
    private void saveSinglePlayerToFile(String fileName, String playerToFile) {
        fileManager.checkOrCreateFile(fileName);
        fileManager.appendToFile(fileName, playerToFile);
    }
    public void displayPlayers() {
        int number = 1;
        fileManager.loadPlayersFromFile("players.txt", players);
        for (Player player : players) {
            System.out.print(number++ + ". ");
            player.displayPlayer();
        }
    }
    private Team findTeamByName(String teamName) {
        for (Team team : teamManager.getTeams()) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null;
    }
}
