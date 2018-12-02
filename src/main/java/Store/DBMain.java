//package Store;
//
//import Model.Room;
//import Model.User;
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleStringProperty;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
////public class DBMain {
////    public static void main(String[] args) throws SQLException {
////        RoomDBConnector f = DBConnector.openRoomDB();
////        for (Room s: f.readHistory()) {
////            System.out.println(s);
////        }
//
//
////        Room r1 = new Room("B211",0);
////        System.out.println(rcb.addRoom(r1));
//
////        for (Room s : rcb.readRoom()){
////            System.out.println(s);
////        }
////        ArrayList<Room> roomList = rcb.readRoom();
////        for (Room i:roomList) {
////            System.out.println(i);
//////
////        String c = "G7";
////        for (int i=1 ; i<=11 ; i++) {
////            DBConnector db = new DBConnector();
////            Connection connection = db.openDatabase();
////            UserDBControl userDBControl = new UserDBControl(connection);
////            RoomDBConnector rcb = new RoomDBConnector(connection);
////            if (i<10) {
////                rcb.addRoom(new Room(c+"0"+i,0));
////            }
////            else {
////                rcb.addRoom(new Room(c+i,0));
////            }
////
////        }
////        }
//
////        User user = new User("000","admin","Admin",
////                "Superadmin","8888888888","adminHR@hr.com","adminadmin");
////        System.out.println(userDBControl.addUser(user));
//
//        /////////////////////////////////////////////////////// เอาไว้อ่านข้อมูลจาก database
//
////        ArrayList<User> userList = userDBControl.readUser();
////        for (User i: userList) {
////            System.out.println(i);
////        }
//    }
//
//}
