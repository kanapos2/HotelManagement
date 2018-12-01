package Model;

public class Room {
    private String roomNumber ;
    private int roomStatus;

    private String firstName;
    private String lastName;
    private String passport;
    private String sex;
    private String email;
    private String phoneNumber;
    private String checkIn;
    private String checkOut;

    public Room(String roomNumber, int roomStatus) {
        this.roomNumber = roomNumber;
        this.roomStatus = roomStatus;
    }

    public Room() {
    }

    public Room(String firstName, String lastName, String passport, String sex, String email, String phoneNumber,
                String checkIn , String checkOut){
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomStatus='" + roomStatus + '\'' +
                '}';
    }
}
