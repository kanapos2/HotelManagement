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
    private Label roomnumber , test , typeRoom;

    @FXML
    private Button confirm , cancel;

    @FXML
    private CheckBox boxMr , boxMrs , boxMiss;

    @FXML
    public void roomNumber(String number) {
        roomnumber.setText(number);

        boxMr.setSelected(true);
        if (boxMr.isSelected()) {
            System.out.println(boxMr.getText());
        }
        else {
            System.out.println("-!-!-!-!-!-!-");
        }


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
            checkRoomnumber();
            clickConfirmToBack(e);
        }
    }

    @FXML
    public void clickConfirmToBack(ActionEvent event){
        confirm = (Button) event.getSource();

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

    public void checkRoomnumber(){
        RoomDBConnector roomDBConnector = DBConnector.openRoomDB();
        ArrayList<Room> roomList;
        String nowRoom = roomnumber.getText();
        roomList = roomDBConnector.readRoom();
        for (int i = 0; i < roomList.size() ; i++) {
            if (roomList.get(i).getRoomNumber().equals(nowRoom)){
                Room now = roomList.get(i);
                if (roomList.get(i).getRoomStatus() == 0){
                    updateRoomStatus(now);
                    now.setRoomStatus(1);
                }else if (roomList.get(i).getRoomStatus() == 1){
                    System.out.println("Room not available");
                }
            }
        }
    }

    public void updateRoomStatus(Room room){
        RoomDBConnector roomDBConnector = DBConnector.openRoomDB();
        roomDBConnector.updateRoom(room,1);
    }

}
