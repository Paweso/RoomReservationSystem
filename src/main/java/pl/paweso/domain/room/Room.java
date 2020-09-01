package pl.paweso.domain.room;

public class Room {

    private int number;
    private BedType[] bedTypes;

    Room(int number, BedType[] bedType) {
        this.number = number;
        this.bedTypes = bedType;
    }

    public String getInfo() {

        StringBuilder bedInfo = new StringBuilder("Rodzaje łóżek w pokoju.\n");
        for (BedType bedType : bedTypes) bedInfo.append("\t").append(bedType).append("\n");

        return String.format("%d %s", this.number, bedInfo.toString());
    }

    String toCSV() {
        String[] bedsAsString = new String[this.bedTypes.length];
        for (int i = 0; i < this.bedTypes.length; i++) {
            bedsAsString[i] = this.bedTypes[i].toString();
        }
        String bedTypes = String.join("#", bedsAsString);
        return String.format("%d,%s%s", this.number, bedTypes, System.getProperty("line.separator"));
    }
}
