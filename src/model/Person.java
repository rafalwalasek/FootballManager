package model;

public class Person {
    private final String name;
    private final String surname;
    private final int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }

    public void displayPerson() {
        System.out.println("\tImię\t\tNazwisko\t\tWiek\t");
        System.out.println("\t" + name + "\t\t" + surname + "\t\t" + age + "\t");
    }
}
