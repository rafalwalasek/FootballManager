package model;

public abstract class Person {
    private final String name;
    private final String surname;
    private int age;

    protected Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    protected String getName() {
        return name;
    }

    protected String getSurname() {
        return surname;
    }

    protected int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Wiek nie może być ujemny!");
        } else {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return name + " " + surname + " | Wiek: " + age;
    }
}
