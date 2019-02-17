package by.avramenko.classes;

import java.util.ArrayList;

public class Building{

    private String name;
    private ArrayList<Room> listRoom;

    public Building(String name){
        this.name = name;
        this.listRoom = new ArrayList<Room>();
    }

    public void addRoom(Room room) {
        listRoom.add(room);
    }

    public void addRoom(String name, int area, int numberWidows) {
        listRoom.add(new Room(name, area, numberWidows));
    }

    public Room getRoom(String roomName) {
        for(Room room : listRoom)
            if(room.getName().equals(roomName))
                return room;
        return null;
    }


    public void describe() {
        System.out.println(this.name);
        for(Room room : listRoom)
            room.describe();
    }
}
