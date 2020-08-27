import java.util.InputMismatchException;
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
            Room room = createNewRoom(input);
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

            Gender gender = getGender(input);
            Guest createGuest = new Guest(firstName, lastName, age, gender);
            System.out.println(createGuest.getInfo());
            return createGuest;
        } catch (Exception e) {
            System.out.println("Wiek nierozpoznany, używaj liczb.");
            return null;
        }
    }

    private static Gender getGender(Scanner input) {
        System.out.println("Podaj płeć:");
        System.out.println("\t1. Mężczyzna");
        System.out.println("\t2. Kobieta");
        int number = input.nextInt();
        Gender gender = Gender.MALE;
        if (number == 1) {
            gender = Gender.MALE;
        } else if (number == 2) {
            gender = Gender.FEMALE;
        }
        return gender;
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
            System.out.println("Nierozpoznane dane, użyj liczb.");
            return null;
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
            BedType bedType = BedType.SINGLE;
            int beds = input.nextInt();

            if (beds == 1) {
                bedType = BedType.SINGLE;
            } else if (beds == 2) {
                bedType = BedType.DOUBLE;
            } else if (beds == 3) {
                bedType = BedType.KING_SIZE;
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
