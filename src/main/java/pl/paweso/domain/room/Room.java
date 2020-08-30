package pl.paweso.domain.room;

public class Room {

    private int number;
    private BedType[] bedTypes;

    Room(int number, BedType[] bedType) {
        this.number = number;
        this.bedTypes = bedType;
    }

    public String getInfo() {

        StringBuilder bedInfo = new StringBuilder("\nRodzaje łóżek w pokoju.\n");
        for (BedType bedType : bedTypes) bedInfo.append("\t").append(bedType).append("\n");

        return String.format("Utworzono pokój o numerze %d %s", this.number, bedInfo.toString());
    }
}
