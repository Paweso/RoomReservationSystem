package pl.paweso.domain.guest;

public class GuestService {
    private GuestRepository guestRepository = new GuestRepository();

    public Guest createNewGuest(String firstName, String lastName, int age, int genderOption) {
        Gender gender = Gender.MALE;

        if (genderOption == 1) {
            gender = Gender.MALE;
        } else if (genderOption == 2) {
            gender = Gender.FEMALE;
        }
        return guestRepository.creadNewGuest(firstName, lastName, age, gender);
    }
}
