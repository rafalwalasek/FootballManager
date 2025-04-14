package manager;

import model.Player;
import utils.RandomGenerator;
import utils.FileManager;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerManager {
    private final ArrayList<Player> players = new ArrayList<>();
    private final RandomGenerator random = new RandomGenerator();
    private final FileManager fileManager = new FileManager();

    private final Scanner scanner;

    public PlayerManager(Scanner scanner) {
        this.scanner = scanner;
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

        int age = random.isValidAge();
        int shooting = random.isValidStat();
        int passing = random.isValidStat();
        int speed = random.isValidStat();
        int form = random.isValidStat();

        Player player = new Player(name, surname, age, position, shooting, passing, speed, form, teamName);
        players.add(player);

        String playerToFile = player.saveToFile();
        String fileName = "players.txt";
        saveSinglePlayerToFile(fileName, playerToFile);
    }
    private void saveSinglePlayerToFile(String fileName, String playerToFile) {
        fileManager.checkOrCreateFile(fileName);
        fileManager.appendToFile(fileName, playerToFile);
    }
    public void displayPlayers() {
        fileManager.loadFromFile("players.txt");
    }
}
