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
    private Button btn_signout ;

    @FXML
    public void setUser(String name) {
        user.setText(name);
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
}
