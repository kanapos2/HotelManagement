package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Manu_control {

    @FXML
    private Label user ;

    @FXML
    private Button btn_signout, btn_next ;

    @FXML
    private Button A101,A102,A103,A104,A105,A106,A107,A108,A109,A110,A111,
            B201,B202,B203,B204,B205,B206,B207,B208,B209,B210,B211,
            C301,C302,C303,C304,C305,C306,C307,C308,C309,C310,C311;

    @FXML
    public void setUser(String name) {
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

        if (roomNumber.equals(A101)){ room = "A101"; }
        else if (roomNumber.equals(A102)){ room = "A102"; }
        else if (roomNumber.equals(A103)){ room = "A103"; }
        else if (roomNumber.equals(A104)){ room = "A104"; }
        else if (roomNumber.equals(A105)){ room = "A105"; }
        else if (roomNumber.equals(A106)){ room = "A106"; }
        else if (roomNumber.equals(A107)){ room = "A107"; }
        else if (roomNumber.equals(A108)){ room = "A108"; }
        else if (roomNumber.equals(A109)){ room = "A109"; }
        else if (roomNumber.equals(A110)){ room = "A110"; }
        else if (roomNumber.equals(A111)){ room = "A111"; }

        else if (roomNumber.equals(B201)){ room = "B201"; }
        else if (roomNumber.equals(B202)){ room = "B202"; }
        else if (roomNumber.equals(B203)){ room = "B203"; }
        else if (roomNumber.equals(B204)){ room = "B204"; }
        else if (roomNumber.equals(B205)){ room = "B205"; }
        else if (roomNumber.equals(B206)){ room = "B206"; }
        else if (roomNumber.equals(B207)){ room = "B207"; }
        else if (roomNumber.equals(B208)){ room = "B208"; }
        else if (roomNumber.equals(B209)){ room = "B209"; }
        else if (roomNumber.equals(B210)){ room = "B210"; }
        else if (roomNumber.equals(B211)){ room = "B211"; }

        else if (roomNumber.equals(C301)){ room = "C301"; }
        else if (roomNumber.equals(C302)){ room = "C302"; }
        else if (roomNumber.equals(C303)){ room = "C303"; }
        else if (roomNumber.equals(C304)){ room = "C304"; }
        else if (roomNumber.equals(C305)){ room = "C305"; }
        else if (roomNumber.equals(C306)){ room = "C306"; }
        else if (roomNumber.equals(C307)){ room = "C307"; }
        else if (roomNumber.equals(C308)){ room = "C308"; }
        else if (roomNumber.equals(C309)){ room = "C309"; }
        else if (roomNumber.equals(C310)){ room = "C310"; }
        else if (roomNumber.equals(C311)){ room = "C311"; }








        Stage stage = (Stage) roomNumber.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Reserve_info.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 1280, 720));
            stage.setTitle("Reserve info");

            Reserve_info_control controller = (Reserve_info_control) loader.getController();
            controller.roomNumber(room);

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
