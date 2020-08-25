import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String hotelName = "Overlook";
        int systemVersion = 1;
        boolean isDeveloperVersion = true;
        System.out.print("Witam w systemie rezerwacji dla hotelu");
        System.out.println(hotelName);
        System.out.println("Aktualna wersja systemu: ");
        System.out.println(systemVersion);
        System.out.println("Wersja developerska: ");
        System.out.println(isDeveloperVersion);
        System.out.println("\n=========================\n");
        Scanner input = new Scanner(System.in);
        System.out.println("1. Dodaj nowego gościa.");
        System.out.println("2. Dodaj nowy pokój.");
        System.out.println("3. Wyszukaj gościa.");
        System.out.println("Wybierz opcję: ");
        int option = 0;
        try {
            option = input.nextInt();
        } catch (Exception e) {
            System.out.println("Niepoprawne dane wejściowe, wprowadź liczbę.");
            e.printStackTrace();
        }
        if (option == 1) {
            System.out.println("Tworzymy nowego gościa.");
            try {
                System.out.println("Podaj imię: ");
                String firstName = input.next();
                System.out.println("Podaj nazwisko: ");
                String lastName = input.next();
                System.out.println("Podaj wiek: ");
                int age = input.nextInt();
                Guest createdGuest = new Guest(firstName, lastName, age);
            } catch (Exception e) {
                System.out.println("Wiek nierozpoznany, używaj liczb.");
            }
        } else if (option == 2) {
            System.out.println("Tworzymy nowy pokój.");
            try {
                System.out.println("Numer: ");
                int number = input.nextInt();
                System.out.println("Ilość łóżek: ");
                int beds = input.nextInt();
                Room createdRoom = new Room(number, beds);
            } catch (Exception e) {
                System.out.println("Nierozpoznane dane, użyj liczb.");
            }
        } else if (option == 3) {
            System.out.println("Wybrano opcję 3.");
        } else {
            System.out.println("Wybrano niepoprawną akcję.");
        }
    }
}
