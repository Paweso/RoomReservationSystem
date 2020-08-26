public class Room {

    private int number;
    private BedType bedType;

    public Room(int number, BedType bedType) {
        this.number = number;
        this.bedType = bedType;
    }

    public String getInfo() {
        return String.format("Utworzono pokój o numerze %d (%s)", this.number, this.bedType);
    }


}
