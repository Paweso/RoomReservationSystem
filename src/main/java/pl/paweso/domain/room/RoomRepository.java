package pl.paweso.domain.room;

import java.util.ArrayList;
import java.util.List;

class RoomRepository {
    private final List<Room> rooms = new ArrayList<>();

    public Room createNewRoom(int number, BedType[] bedTypes) {
        Room newRoom = new Room(number, bedTypes);
        rooms.add(newRoom);
        return newRoom;
    }

    List<Room> getAll() {
        return this.rooms;
    }
}
