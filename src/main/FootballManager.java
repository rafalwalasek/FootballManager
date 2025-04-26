package main;

import manager.LeagueManager;
import manager.PlayerManager;
import manager.TeamManager;
import ui.Menu;

import java.util.Scanner;

public class FootballManager {
    private final Scanner scanner = new Scanner(System.in);
    private final Menu menu = new Menu();
    private final PlayerManager playerManager = new PlayerManager(scanner);
    private final TeamManager teamManager = new TeamManager(scanner);
    private final LeagueManager leagueManager = new LeagueManager(teamManager, scanner);

    private boolean shouldContinue;

    public FootballManager() {
        this.shouldContinue = true;
        playerManager.setTeamManager(teamManager);
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
                    //case 3 -> teamManager.addTeam(); // Dodanie drużyny ręcznie
                    case 4 -> teamManager.displayTeams();
                    case 5 -> leagueManager.displayTable();
                    case 6 -> leagueManager.simulateMatchAndUpdateStats();
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
