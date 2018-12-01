package Admin;

import Model.Room;
import Model.User;
import Store.DBConnector;
import Store.RoomDBConnector;
import Store.UserDBControl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class Reserve_info_control {

    private String nowLogin = "--";

    @FXML
    private TextField tf_FirstName , tf_LastName , tf_Passport , tf_Email , tf_PhoneNumber;

    @FXML
    private RadioButton rd_sex;

    @FXML
    private DatePicker chIn , chOut;


    @FXML
    protected Label roomnumber , test , typeRoom , totalPriceLabel;

    @FXML
    private Button confirm , cancel;

    @FXML
    private CheckBox boxMr , boxMrs , boxMiss;

    private String numberOfRoom = "";

    private int roomPrice ;
    private int calIn,calOut;
    private int totalPrice;

    @FXML
    public void roomNumber(String number,int price) {
        roomnumber.setText(number);
        numberOfRoom = number;
        roomPrice = price;
        boxMr.setSelected(true);
        if (boxMr.isSelected()) {
            System.out.println(boxMr.getText());
        }
        else {
            System.out.println("-!-!-!-!-!-!-");
        }

        chIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calIn  = chIn.getValue().getDayOfMonth();
                try {
                    int test = chOut.getValue().getDayOfMonth();
                    convertPrice(calIn,test);
                }
                catch (NullPointerException e){
                    e.getStackTrace();
                }

            }
        });
        chOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calOut = chOut.getValue().getDayOfMonth();
                convertPrice(calIn,calOut);
            }
        });
    }



    public void convertPrice(int in,int out){
        if (out > in){
            totalPrice=0;
            totalPrice = (out-in)*roomPrice;
            System.out.println(totalPrice);
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }else return;
    }

    @FXML
    public void name(String nameLogin){
        test.setText("Login as : "+nameLogin);
        nowLogin = nameLogin;
        System.out.println(nowLogin);
    }

    @FXML
    public void showTypeRoom(String type){
        typeRoom.setText(type);
    }

    @FXML
    public void cancelReserve(ActionEvent event){
        cancel = (Button) event.getSource();

        Stage stage = (Stage) confirm.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Manu.fxml"));

        try {
            stage.setScene(new Scene(loader.load(), 1280, 720));
            stage.setTitle("Reserve hotel");

            Manu_control controller = (Manu_control) loader.getController();
            controller.setUserAfterClickRoom(nowLogin);

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    public void handleComfirm(ActionEvent e){
        if (e.getSource().equals(confirm)){
//            checkRoomnumber();
            clickConfirmToBack(e);
        }
    }

    @FXML
    public void clickConfirmToBack(ActionEvent event){
        confirm = (Button) event.getSource();


        DBConnector db = new DBConnector();
        Connection connection = db.openDatabase();
        RoomDBConnector roomDBConnector = new RoomDBConnector(connection);

        if (rd_sex.getText().equals("Male")){
            Room room = new Room(tf_FirstName.getText(),tf_LastName.getText(),
                    tf_Passport.getText(), rd_sex.getText(), tf_Email.getText(),tf_PhoneNumber.getText(),""+chIn.getValue(),""+chOut.getValue());
            room.setRoomNumber(numberOfRoom);
            System.out.println(roomDBConnector.addInformation(room,1));

        }
        else {
            Room room = new Room(tf_FirstName.getText(),tf_LastName.getText(),
                    tf_Passport.getText(), rd_sex.getText(), tf_Email.getText(),tf_PhoneNumber.getText(),""+chIn.getValue(),""+chOut.getValue());
            room.setRoomNumber(numberOfRoom);
            System.out.println(roomDBConnector.addInformation(room,1));

        }







        Stage stage = (Stage) confirm.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Manu.fxml"));

        try {
            stage.setScene(new Scene(loader.load(), 1280, 720));
            stage.setTitle("Reserve hotel");

            Manu_control controller = (Manu_control) loader.getController();
            controller.setUserAfterClickRoom(nowLogin);

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

//    public void checkRoomnumber(){
//        DBConnector db = new DBConnector();
//        Connection connection = db.openDatabase();
//        RoomDBConnector roomDBConnector = new RoomDBConnector(connection);
//        ArrayList<Room> roomList;
//        String nowRoom = roomnumber.getText();
//        roomList = roomDBConnector.readRoom();
//        for (int i = 0; i < roomList.size() ; i++) {
//            if (roomList.get(i).getRoomNumber().equals(nowRoom)){
//                Room now = roomList.get(i);
//                if (roomList.get(i).getRoomStatus() == 0){
//                    updateRoomStatus(now);
//                    now.setRoomStatus(1);
//                }else if (roomList.get(i).getRoomStatus() == 1){
//                    System.out.println("Room not available");
//                }
//            }
//        }
//    }

    public void updateRoomStatus(Room room){
        DBConnector db = new DBConnector();
        Connection connection = db.openDatabase();
        RoomDBConnector roomDBConnector = new RoomDBConnector(connection);
        roomDBConnector.updateRoom(room,1);
    }

}
