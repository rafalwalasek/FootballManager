package model;

public class Player extends Person {
    private final String position;
    private final int shooting, passing, speed;
    private final int form;
    private final String teamName;

    public Player(String name, String surname, int age,
                  String position, int shooting, int passing, int speed, int form, String teamName) {
        super(name, surname, age);
        this.position = position;
        this.shooting = shooting;
        this.passing = passing;
        this.speed = speed;
        this.form = form;
        this.teamName = teamName;
    }

    public String getPosition() {
        return position;
    }
    public int getShooting() {
        return shooting;
    }
    public int getPassing() {
        return passing;
    }
    public int getSpeed() {
        return speed;
    }
    public int getForm() {
        return form;
    }
    public String getTeamName() {
        return teamName;
    }

    public void displayPlayer() {
        super.displayPerson();
        System.out.println("\tPozycja\t\tDrużyna\t");
        System.out.println("\t" + position + "\t\t" + teamName + "\t");
        System.out.println("\tStrzały\t\tPodania\t\tSzybkość\t");
        System.out.println("\t" + shooting + "\t\t" + passing + "\t\t" + speed + "\t");
        System.out.println("\tForma\t");
        System.out.println("\t" + form + "\t");
    }
    public String saveToFile() {
        return getName() + ", " + getSurname() + ", " + getAge() + ", " +
                getPosition() + ", " + getShooting() + ", " + getPassing() + ", " +
                getSpeed() + ", " + getForm() + ", " + getTeamName();
    }
}
