package pl.paweso.domain.guest;

import java.util.List;

public class GuestService {
    private final GuestRepository guestRepository = new GuestRepository();

    public Guest createNewGuest(String firstName, String lastName, int age, boolean isMale) {
        Gender gender = Gender.FEMALE;

        if (isMale) {
            gender = Gender.MALE;
        }
        return guestRepository.createNewGuest(firstName, lastName, age, gender);
    }

    public List<Guest> getAllGuests() {
        return this.guestRepository.getAll();
    }

    public void saveAll() {
        this.guestRepository.saveAll();
    }
    public void readAll(){
        this.guestRepository.readAll();
    }
}
