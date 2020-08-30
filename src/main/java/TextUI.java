import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUI {
    GuestService guestService = new GuestService();
    RoomService roomService = new RoomService();

    public void readNewGuestData(Scanner input) {
        System.out.println("Tworzymy nowego gościa.");
        try {
            System.out.print("Podaj imię: ");
            String firstName = input.next();
            System.out.print("Podaj nazwisko: ");
            String lastName = input.next();
            System.out.print("Podaj wiek: ");
            int age = input.nextInt();

            System.out.println("Podaj płeć (1. Mężczyzna, 2. Kobieta");
            int genderOption = input.nextInt();
            if (genderOption != 1 && genderOption != 2) {
                throw new WrongOptionException("Wrong option in gender selection");
            }
            Guest newGuest = guestService.createNewGuest(firstName, lastName, age, genderOption);
            System.out.println(newGuest.getInfo());
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers when choosing gender");
        }
    }

    public void readNewRoomData(Scanner input) {
        System.out.println("Tworzymy nowy pokój.");
        try {
            System.out.println("Numer: ");
            int number = input.nextInt();
            int[] bedTypes = getBedType(input);
            Room createRoom = roomService.createNewRoom(number, bedTypes);
            System.out.println(createRoom.getInfo());
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong characters used instead of numbers");
        }
    }

    private static int[] getBedType(Scanner input) {
        System.out.println("Ile łóżek w pokoju?:");
        int bedNumber = input.nextInt();

        int[] bedTypes = new int[bedNumber];

        for (int i = 0; i < bedNumber; i++) {

            System.out.println("Typy łóżek: ");
            System.out.println("\t1. Pojedyncze");
            System.out.println("\t2. Podwójne");
            System.out.println("\t3. Królewskie");

            int bedTypesOption = input.nextInt();

            bedTypes[i] = bedTypesOption;
        }
        return bedTypes;
    }
}
