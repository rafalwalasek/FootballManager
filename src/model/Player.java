package model;

public class Player extends Person {
    private final String position;
    private final double worth;

    private Team team;

    public Player(String name, String surname, int age,
                  String position, Team team, double worth) {
        super(name, surname, age);
        this.position = position;
        this.team = team;
        this.worth = worth;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void displayPlayer() {
        System.out.println(super.toString() +
                " | Pozycja: " + position +
                " | Drużyna: " + team +
                " | Wartość: " + formatWorth(worth));
    }
    private String formatWorth(double worth) {
        if (worth >= 1000000) {
            return String.format("%.1f mln €", worth/1000000);
        } else if (worth >= 1000) {
            return String.format("%.0f tys. €", worth/1000);
        } else {
            return String.format("%.0f €", worth);
        }
    }
    public String savePlayerToFile() {
        return getName() + "; " + getSurname() + "; " + getAge() + "; " +
                position + "; " + team.getTeamName() + "; " + String.format("%.2f", worth);
    }
}
