public class Room {

    private int number;
    private BedType[] bedTypes;

    public Room(int number, BedType[] bedType) {
        this.number = number;
        this.bedTypes = bedType;
    }

    public String getInfo() {

        int numberOfBeds = bedTypes.length;
        System.out.println("Rodzaje łóżek w pokoju.");
        for (BedType bedType : bedTypes) System.out.println(bedType);

        return String.format("Utworzono pokój o numerze %d ", this.number);
    }


}
