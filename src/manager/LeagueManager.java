package manager;

import model.Match;
import model.Team;
import utils.FileManager;

import java.util.*;

public class LeagueManager {
    private static final int MAX_TEAMS = 8;

    private final ArrayList<Team> teams = new ArrayList<>();
    private final FileManager fileManager = new FileManager();

    private final TeamManager teamManager;
    private final Scanner scanner;

    public LeagueManager(TeamManager teamManager, Scanner scanner) {
        this.teamManager = teamManager;
        this.scanner = scanner;
    }

    public void simulateMatchAndUpdateStats() {
        System.out.print("W której lidze rozegrać mecz? (1/2): ");
        int choiceLeague = scanner.nextInt();
        scanner.nextLine();

        teams.clear();
        fileManager.loadTeamsFromFile("teams.txt", teams);
        ArrayList<Team> leagueTeam = new ArrayList<>();

        for (Team team : teams) {
            if (team.getTier() == choiceLeague) {
                leagueTeam.add(team);
            }
        }

        System.out.println("Dostępne drużyny: ");
        int number = 1;
        for (Team team : leagueTeam) {
            System.out.print(number++ + ". " + team.getTeamName() + ", ");
        }
        System.out.println();

        if (leagueTeam.isEmpty()) {
            System.out.println("Brak drużyn w lidze. Nie można rozegrać meczu.");
        } else {
            System.out.print("Podaj nr pierwszej drużyny: ");
            int teamIndex_1 = scanner.nextInt();
            System.out.print("Podaj nr drugiej drużyny: ");
            int teamIndex_2 = scanner.nextInt();
            scanner.nextLine();

            System.out.println("=== MECZ LIGA " + choiceLeague + " ===");
            Team team_1 = leagueTeam.get(teamIndex_1 - 1);
            Team team_2 = leagueTeam.get(teamIndex_2 - 1);

            Match match = new Match(team_1, team_2);
            match.simulateMatch();
            match.displayResult();
            match.updateTeamsStats();

            fileManager.updateTeamInFile("teams.txt", team_1, team_2);
        }
    }
    public void displayTable() {
        teams.clear();
        System.out.print("Którą tabelę wypisać (1/2): ");
        int tier = scanner.nextInt();
        scanner.nextLine();

        for (Team team : teamManager.getTeams()) {
            if (team.getTier() == tier) {
                addTeam(team);
            }
        }
        System.out.println("Wszystkie drużyny zostały dodane do Ligi: " + tier);

        teams.sort(new Comparator<Team>() {
            @Override
            public int compare(Team team1, Team team2) {
                return Integer.compare(team2.getPoints(), team1.getPoints());
            }
        });

        int number = 1;
        System.out.println("#  DRUŻYNA \t\t M \t   B \t P");
        System.out.println("-------------------------------");
        for (Team team : teams) {
            System.out.print(number++ + ". ");
            System.out.println(team);
        }
    }
    private void addTeam(Team team) {
        if (teams.size() < MAX_TEAMS) {
            teams.add(team);
        }
    }
}
