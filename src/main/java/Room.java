public class Room {

    private int number;
    private int beds;

    public Room(int number, int beds) {
        this.number = number;
        this.beds = beds;
    }

    public String getInfo() {
        return String.format("Utworzono pokój o numerze %d i (%d)", this.number, this.beds);
    }


}
