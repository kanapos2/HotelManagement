package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Manu_control {

    private String lastLogin = "";
    private String[] roomName = {"A1","B2","C3"} ;

    @FXML
    private Label user ;

    @FXML
    private AnchorPane firstFloor ;

    @FXML
    private Button btn_signout, btn_next ;

    @FXML
    private Button A101,A102,A103,A104,A105,A106,A107,A108,A109,A110,A111,
            B201,B202,B203,B204,B205,B206,B207,B208,B209,B210,B211,
            C301,C302,C303,C304,C305,C306,C307,C308,C309,C310,C311;



    @FXML
    public void setUser(String name) {
        user.setText(name);
        lastLogin = name;


    }

    @FXML
    public void setUserAfterClickRoom(String name){
        lastLogin = name;
        user.setText(name);
    }


    @FXML
    public void nextFloor(ActionEvent event){
        btn_next = (Button) event.getSource();
        Stage stage = (Stage) btn_signout.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Forth_Seven_Floor.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 1280, 720));
            stage.setTitle("4th-7th");

            Forth_Seven_Floor_control controller = (Forth_Seven_Floor_control) loader.getController();
            controller.nameLogin(lastLogin);

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    @FXML
    public void signOut(ActionEvent event) {
        System.out.println("Sign out");

        btn_signout = (Button) event.getSource();

        Stage stage = (Stage) btn_signout.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Login_as_admin.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 1280, 720));
            stage.setTitle("Login hotel management for admin");

            Login_as_admin_control controller = (Login_as_admin_control) loader.getController();

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    public void reserveRoom(ActionEvent event){
        Button roomNumber = (Button) event.getSource();
        String room = "" ;

        Scene scene = firstFloor.getScene();
        String roomNum = "" ;
        for (String s : roomName){
            for (int i=1 ; i<=11 ; i++){
                if (i<10) {
                    roomNum = s + "0" +i ;
                }
                else {
                    roomNum = s + i ;
                }

                Button newRoomNum = (Button) scene.lookup("#"+roomNum);
                if (roomNumber.equals(newRoomNum)){
                    room = roomNum;
                }
            }
        }


        Stage stage = (Stage) roomNumber.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Reserve_info.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 1280, 720));
            stage.setTitle("Reserve info");

            Reserve_info_control controller = (Reserve_info_control) loader.getController();
            controller.roomNumber(room);
            controller.name(lastLogin);

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

}
