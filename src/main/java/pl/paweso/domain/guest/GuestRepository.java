package pl.paweso.domain.guest;

public class GuestRepository {

    public Guest creadNewGuest(String firstName, String lastName, int age, Gender gender) {

        return new Guest(firstName,lastName,age,gender);
    }
}
