package Model;

public class Room {
    private String roomNumber ;
    private int roomStatus;
    private String firstName;

    public Room(String roomNumber, int roomStatus) {
        this.roomNumber = roomNumber;
        this.roomStatus = roomStatus;
    }

    public Room() {
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(int roomStatus) {
        this.roomStatus = roomStatus;
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomStatus='" + roomStatus + '\'' +
                '}';
    }
}
