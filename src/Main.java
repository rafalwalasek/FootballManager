import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Football Manager Started!");

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        boolean isProgramRuuning = true;
        while (isProgramRuuning) {

            menu.menu();
            System.out.print("Wybierz pozycję z menu: ");

            try {
                switch (scanner.nextInt()) {
                    case 1 -> System.out.println("wybór 1");
                    case 2 -> System.out.println("wybór 2");
                    case 3 -> isProgramRuuning = false;
                    default -> System.out.println("Błąd: podaj cyfrę z MENU!");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); //czyszczenie bufora
                System.out.println("Niepoprawne dane! Spróbuj jeszcze raz!");
            }

        }

        scanner.close();
        System.out.println("Football Manager Finish!!");

    }
}