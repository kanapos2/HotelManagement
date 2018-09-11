package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login_as_admin_control {

    @FXML
    private Button btn_login ;

    @FXML
    private TextField username ;

    @FXML
    private PasswordField password ;

    @FXML
    public void login(ActionEvent event) {
        String user = username.getText();
        String passwd = password.getText();

        if (user.equals("admin") && passwd.equals("admin") && event.getSource().equals(btn_login)) {

            Stage stage = (Stage) btn_login.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Manu.fxml"));
            try {
                stage.setScene(new Scene(loader.load(), 1280, 720));

                Manu_control controller = (Manu_control) loader.getController();
                controller.setUser(username.getText());

                stage.show();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }



}
