import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String hotelName = "Overlook";
        int systemVersion = 1;
        boolean isDeveloperVersion = true;

        showSystemInformation(hotelName, systemVersion, isDeveloperVersion);

        Scanner input = new Scanner(System.in);

        int option = readOption(input);

        if (option == 1) {
            Guest guest = readCreateGuest(input);
        } else if (option == 2) {
            Room room = readCreateRoom(input);
        } else if (option == 3) {
            System.out.println("Wybrano opcję 3.");
        } else {
            System.out.println("Wybrano niepoprawną akcję.");
        }
    }

    private static Guest readCreateGuest(Scanner input) {
        System.out.println("Tworzymy nowego gościa.");
        try {
            System.out.print("Podaj imię: ");
            String firstName = input.next();
            System.out.print("Podaj nazwisko: ");
            String lastName = input.next();
            System.out.print("Podaj wiek: ");
            int age = input.nextInt();
            Guest createdGuest = new Guest(firstName, lastName, age);
            String info = String.format("Stworzono gościa: %s %s (%d)", createdGuest.getFirstName(), createdGuest.getLastName(), createdGuest.getAge());
            System.out.println(info);
            return createdGuest;
        } catch (Exception e) {
            System.out.println("Wiek nierozpoznany, używaj liczb.");
            return null;
        }
    }

    private static Room readCreateRoom(Scanner input) {
        System.out.println("Tworzymy nowy pokój.");
        try {
            System.out.println("Numer: ");
            int number = input.nextInt();
            System.out.println("Ilość łóżek: ");
            int beds = input.nextInt();
            Room createdRoom = new Room(number, beds);
            String info = String.format("Utworzono pokój o numerze %d i (%d)", createdRoom.getNumber(), createdRoom.getBeds());
            System.out.println(info);
            return createdRoom;
        } catch (Exception e) {
            System.out.println("Nierozpoznane dane, użyj liczb.");
            return null;
        }
    }

    private static int readOption(Scanner input) {
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
        return option;
    }

    private static void showSystemInformation(String hotelName, int systemVersion, boolean isDeveloperVersion) {
        System.out.println("Witam w systemie rezerwacji dla hotelu " + hotelName);
        System.out.println("Aktualna wersja systemu: " + systemVersion);
        System.out.println("Wersja developerska: " + isDeveloperVersion);
        System.out.println("\n=========================\n");
    }
}
