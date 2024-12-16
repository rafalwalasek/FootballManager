package pl.footballManager;

public class Player {
    private String name;
    private String position;
    private int age;
    private int overallSkill;

    public Player(String name, String position, int age, int overallSkill) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.overallSkill = overallSkill;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", overallSkill=" + overallSkill +
                '}';
    }
}
