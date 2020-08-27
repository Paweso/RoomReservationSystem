public class Room {

    private int number;
    private BedType[] bedTypes;

    public Room(int number, BedType[] bedType) {
        this.number = number;
        this.bedTypes = bedType;
    }

    public String getInfo() {

        String bedInfo = "\nRodzaje łóżek w pokoju.\n";
        for (BedType bedType : bedTypes) bedInfo = bedInfo + "\t" + bedType + "\n";

        return String.format("Utworzono pokój o numerze %d %s", this.number,bedInfo);
    }
}
