import java.util.InputMismatchException;
import java.util.Scanner;

public class GuestRepository {

    public Guest creadNewGuest(String firstName, String lastName, int age, Gender gender) {

        return new Guest(firstName,lastName,age,gender);
    }
}
