package Admin;

import animatefx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Permission_control {

    @FXML
    private Button btn_Admin, btn_User ;

    @FXML
    protected AnchorPane superStage;


    @FXML
    public void clickUser(ActionEvent event){
        btn_User = (Button) event.getSource();

        Stage stage = (Stage) btn_User.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Login_as_admin.fxml"));
        try {
            stage.setScene(new Scene(loader.load(),1280,720));
            stage.setTitle("Hotel Management");
            new Pulse(stage.getScene().getRoot()).play();
            Login_as_admin_control controller = (Login_as_admin_control) loader.getController();

            stage.show();
        } catch (IOException e1){
            e1.printStackTrace();
        }
    }

    @FXML
    public void clickAdmin(ActionEvent event){
        btn_Admin= (Button) event.getSource();

        Stage stage = (Stage) btn_Admin.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Register.fxml")) ;
        try {
            stage.setScene(new Scene(loader.load(),1280,720));
            stage.setTitle("Hotel Management");
            new FadeInDownBig(stage.getScene().getRoot()).play();
            Register_control controller = (Register_control) loader.getController();

            stage.show();
        } catch (IOException e1){
            e1.printStackTrace();
        }
    }
}
