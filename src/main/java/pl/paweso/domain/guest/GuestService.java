package pl.paweso.domain.guest;

public class GuestService {
    private GuestRepository guestRepository = new GuestRepository();

    public Guest createNewGuest(String firstName, String lastName, int age, boolean isMale) {
        Gender gender = Gender.FEMALE;

        if (isMale) {
            gender = Gender.MALE;
        }
        return guestRepository.creadNewGuest(firstName, lastName, age, gender);
    }
}
