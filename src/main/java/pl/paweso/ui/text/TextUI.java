package pl.paweso.ui.text;

import pl.paweso.domain.guest.Guest;
import pl.paweso.domain.guest.GuestService;
import pl.paweso.exceptions.OnlyNumberException;
import pl.paweso.exceptions.WrongOptionException;
import pl.paweso.domain.room.Room;
import pl.paweso.domain.room.RoomService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUI {
    private GuestService guestService = new GuestService();
    private RoomService roomService = new RoomService();

    private void readNewGuestData(Scanner input) {
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
            boolean isMale = false;
            if (genderOption == 1) {
                isMale = true;
            }
            Guest newGuest = guestService.createNewGuest(firstName, lastName, age, isMale);
            System.out.println(newGuest.getInfo());
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers when choosing gender");
        }
    }

    private void readNewRoomData(Scanner input) {
        System.out.println("Tworzymy nowy pokój.");
        try {
            System.out.println("Numer: ");
            int number = input.nextInt();
            int[] bedTypes = chooseBedType(input);
            Room createRoom = roomService.createNewRoom(number, bedTypes);
            System.out.println(createRoom.getInfo());
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong characters used instead of numbers");
        }
    }

    private int[] chooseBedType(Scanner input) {
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

    public void showSystemInfo(String hotelName, int systemVersion, boolean isDeveloperVersion) {
        System.out.println("Witam w systemie rezerwacji dla hotelu " + hotelName);
        System.out.println("Aktualna wersja systemu: " + systemVersion);
        System.out.println("Wersja developerska: " + isDeveloperVersion);
        System.out.println("\n=========================\n");
    }

    public void showMainMenu() {
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

    private void performAction(Scanner input) {
        int option;

        while (true) {
            option = readOption(input);

            if (option == 1) {
                readNewGuestData(input);
            } else if (option == 2) {
                readNewRoomData(input);
            } else if (option == 3) {
                System.out.println("Wybrano opcję 3.");
            } else if (option == 0) {
                break;
            } else {
                throw new WrongOptionException("Wrong option in main menu");
            }
        }
    }

    private int readOption(Scanner input) {
        System.out.println("1. Dodaj nowego gościa.");
        System.out.println("2. Dodaj nowy pokój.");
        System.out.println("3. Wyszukaj gościa.");
        System.out.println("0. Wyjście z aplikacji.");
        System.out.println("Wybierz opcję: ");

        int option;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers in main menu");
        }
        return option;
    }
}
