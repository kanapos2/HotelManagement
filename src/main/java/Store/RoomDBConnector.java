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
            DBConnector.closeAllConfigure(resultSet,stmt,connection);
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
            DBConnector.closeAllConfigure(resultSet,stmt,connection);
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
            DBConnector.closeAllConfigure(resultSet,stmt,connection);
        }
        return updateResult;
    }

    public boolean updateRoomCheckOut(Room room,int newStatus){
        boolean updateResult = false;
        try{
            String sqlText = "UPDATE room_status SET roomStatus=?,FirstName=NULL ,LastName=NULL ,Passport=NULL ,Sex=NULL ,Email=NULL ,PhoneNumber=NULL ,CheckIn=NULL ,CheckOut=NULL WHERE roomNumber=?";
            PreparedStatement prepare = connection.prepareStatement(sqlText);
            prepare.setInt(1,newStatus);
            prepare.setString(2,room.getRoomNumber());

            if (prepare.executeUpdate() == 1){
                updateResult = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnector.closeAllConfigure(resultSet,stmt,connection);
        }
        return updateResult;
    }



    public ArrayList<Room> readRoom(){ // Review User //
        ArrayList<Room> roomsArray = new ArrayList<>();
        Room room = null;
        try{
            stmt = connection.createStatement();
            String query1 = "SELECT * FROM room_status";
            resultSet = stmt.executeQuery(query1);
            while (resultSet.next()){
                roomsArray.add(newRoomFromDB(resultSet));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnector.closeAllConfigure(resultSet,stmt,connection);
        }
        return roomsArray;
    }

    private Room newRoomFromDB(ResultSet resultSet){
        Room roomHistory = new Room();
        try {
            roomHistory.setRoomNumber(resultSet.getString(1));
            roomHistory.setRoomStatus(resultSet.getInt(2));
            roomHistory.setFirstName(resultSet.getString(3));
            roomHistory.setLastName(resultSet.getString(4));
            roomHistory.setPassport(resultSet.getString(5));
            roomHistory.setSex(resultSet.getString(6));
            roomHistory.setEmail(resultSet.getString(7));
            roomHistory.setPhoneNumber(resultSet.getString(8));
            roomHistory.setCheckIn(resultSet.getString(9));
            roomHistory.setCheckOut(resultSet.getString(10));
        }catch (SQLException e){
            e.printStackTrace();
        }

        return roomHistory;
    }

    public ArrayList<Room> readHistory(){ // Review User //
        ArrayList<Room> roomsArray = new ArrayList<>();
        try{
            stmt = connection.createStatement();
            String query = "SELECT * FROM history";
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()){
                roomsArray.add(newRoomFromDB(resultSet));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnector.closeAllConfigure(resultSet,stmt,connection);
        }
        return roomsArray;
    }

    public boolean addHistory(Room room,int historyStatus){
        boolean addResult = false;
        try {
            Room newRoom = room;
            String sqlText = "INSERT INTO history VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prepare = connection.prepareStatement(sqlText);
            prepare.setString(1,newRoom.getRoomNumber());
            prepare.setInt(2,historyStatus);
            prepare.setString(3,newRoom.getFirstName());
            prepare.setString(4,newRoom.getLastName());
            prepare.setString(5,newRoom.getPassport());
            prepare.setString(6,newRoom.getSex());
            prepare.setString(7,newRoom.getEmail());
            prepare.setString(8,newRoom.getPhoneNumber());
            prepare.setString(9,newRoom.getCheckIn());
            prepare.setString(10,newRoom.getCheckOut());
            if (prepare.executeUpdate() == 1){
                addResult = true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnector.closeAllConfigure(resultSet,stmt,connection);
        }
        return addResult;
    }
}
