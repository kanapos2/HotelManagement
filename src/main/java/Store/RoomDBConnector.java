package Store;

import Model.Room;

import java.sql.*;
import java.util.ArrayList;

public class RoomDBConnector {
    private Connection connection;
    private ResultSet resultSet = null;
    private Statement stmt = null;

    public RoomDBConnector(Connection connection) {
        this.connection = connection;
    }

    public boolean addRoom(Room room){
        boolean addResult = false;
        try {
            Room newRoom = room;
            String sqlText = "INSERT INTO room_status VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prepare = connection.prepareStatement(sqlText);
            prepare.setString(1,newRoom.getRoomNumber());
            prepare.setInt(2,newRoom.getRoomStatus());

            if (prepare.executeUpdate() == 1){
                addResult = true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }
        return addResult;
    }

    public boolean addInformation(Room room,int newStatus){
        boolean updateResult = false;
        try{
            String sqlText = "UPDATE room_status SET roomStatus=?,FirstName=?,LastName=?,Passport=?,Sex=?,Email=?,PhoneNumber=?,CheckIn=?,CheckOut=? WHERE roomNumber=?";
            PreparedStatement prepare = connection.prepareStatement(sqlText);
            prepare.setInt(1,newStatus);
            prepare.setString(2,room.getFirstName());
            prepare.setString(3,room.getLastName());
            prepare.setString(4,room.getPassport());
            prepare.setString(5,room.getSex());
            prepare.setString(6,room.getEmail());
            prepare.setString(7,room.getPhoneNumber());
            prepare.setString(8,room.getCheckIn());
            prepare.setString(9,room.getCheckOut());
            prepare.setString(10,room.getRoomNumber());

            if (prepare.executeUpdate() == 1){
                updateResult = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }
        return updateResult;
    }

    public boolean updateRoom(Room room,int newStatus){
        boolean updateResult = false;
        try{
            String sqlText = "UPDATE room_status SET roomStatus=? WHERE roomNumber=?";
            PreparedStatement prepare = connection.prepareStatement(sqlText);
            prepare.setInt(1,newStatus);
            prepare.setString(2,room.getRoomNumber());

            if (prepare.executeUpdate() == 1){
                updateResult = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }
        return updateResult;
    }



    public ArrayList<Room> readRoom(){ // Review User //
        ArrayList<Room> roomsArray = new ArrayList<>();
        Room room = null;
        try{
            stmt = connection.createStatement();
            String query = "SELECT * FROM room_status";
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()){
                room = new Room();
                room.setRoomNumber(resultSet.getString(1));
                room.setRoomStatus(resultSet.getInt(2));
                roomsArray.add(room);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }
        return roomsArray;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
