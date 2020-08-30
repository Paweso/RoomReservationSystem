import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static TextUI textUI = new TextUI();

    public static void main(String[] args) {

        String hotelName = "Overlook";
        int systemVersion = 1;
        boolean isDeveloperVersion = true;

        showSystemInformation(hotelName, systemVersion, isDeveloperVersion);

        Scanner input = new Scanner(System.in);
        try {
            performAction(input);
        } catch (WrongOptionException | OnlyNumberException e) {
            System.out.println("Wystąpił niespodziewany błąd.");
            System.out.println("Kod błędu: " + e.getCode());
            System.out.println("Komunikat błędu: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Wystąpił niespodziewany błąd.");
            System.out.println("Nieznany kod błędu");
            System.out.println("Komunikat błędu: " + e.getMessage());
        } finally {
            System.out.println("Wychodzę z aplikacji");
        }
    }

    private static void performAction(Scanner input) {
        int option = readOption(input);

        if (option == 1) {
            textUI.readNewGuestData(input);
        } else if (option == 2) {
            textUI.readNewRoomData(input);
        } else if (option == 3) {
            System.out.println("Wybrano opcję 3.");
        } else {
            throw new WrongOptionException("Wrong option in main menu");
        }
    }

    private static int readOption(Scanner input) {
        System.out.println("1. Dodaj nowego gościa.");
        System.out.println("2. Dodaj nowy pokój.");
        System.out.println("3. Wyszukaj gościa.");
        System.out.println("Wybierz opcję: ");

        int option;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers in main menu");
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
