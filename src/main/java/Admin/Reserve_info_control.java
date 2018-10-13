package Admin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Reserve_info_control {

    private String nowLogin = "--";

    @FXML
    private Label roomnumber , test , typeRoom;

    @FXML
    private Button confirm , cancel;


    @FXML
    public void roomNumber(String number) {
        roomnumber.setText(number);
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
    public void back(ActionEvent event){
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
}
