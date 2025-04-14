package main;

import manager.PlayerManager;
import ui.Menu;

import java.util.Scanner;

public class FootballManager {
    private final Scanner scanner = new Scanner(System.in);
    private final PlayerManager playerManager = new PlayerManager(scanner);
    private final Menu menu = new Menu();

    private boolean shouldContinue;

    public FootballManager() {
        this.shouldContinue = true;
    }

    public void start() {
        while (shouldContinue) {

            menu.showGameMenu();
            if (scanner.hasNextInt()) {

                int userChoice = scanner.nextInt();
                scanner.nextLine();
                switch (userChoice) {
                    case 0 -> exitProgram();
                    case 1 -> playerManager.addPlayer(); // Dodanie zawodnika ręcznie
                    case 2 -> playerManager.displayPlayers();
                    default -> System.out.println("Błąd: Nieznana opcja! Wybierz ponownie.");
                }

            } else {
                System.out.println("To nie jest cyfra! Spróbuj ponownie.");
                scanner.nextLine();
            }

        }

        scanner.close();
    }
    private void exitProgram() {
        System.out.println("Kończenie programu...");
        shouldContinue = false;
    }
}
