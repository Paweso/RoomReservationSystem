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
        GuestService repo = new GuestService();

        if (option == 1) {
            textUI.readNewGuestData(input);
        } else if (option == 2) {
            Room room = createNewRoom(input);
        } else if (option == 3) {
            System.out.println("Wybrano opcję 3.");
        } else {
            throw new WrongOptionException("Wrong option in main menu");
        }
    }

    private static Room createNewRoom(Scanner input) {
        System.out.println("Tworzymy nowy pokój.");
        try {
            System.out.println("Numer: ");
            int number = input.nextInt();

            BedType[] bedTypes = getBedType(input);
            Room createRoom = new Room(number, bedTypes);
            System.out.println(createRoom.getInfo());
            return createRoom;
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong characters used instead of numbers");
        }
    }

    private static BedType[] getBedType(Scanner input) {
        System.out.println("Ile łóżek w pokoju?:");
        int bedNumber = input.nextInt();

        BedType[] bedTypes = new BedType[bedNumber];

        for (int i = 0; i < bedNumber; i++) {

            System.out.println("Typy łóżek: ");
            System.out.println("\t1. Pojedyncze");
            System.out.println("\t2. Podwójne");
            System.out.println("\t3. Królewskie");
            BedType bedType;
            int beds = input.nextInt();

            if (beds == 1) {
                bedType = BedType.SINGLE;
            } else if (beds == 2) {
                bedType = BedType.DOUBLE;
            } else if (beds == 3) {
                bedType = BedType.KING_SIZE;
            } else {
                throw new WrongOptionException("Wrong option when selecting bed type");
            }
            bedTypes[i] = bedType;
        }
        return bedTypes;
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
