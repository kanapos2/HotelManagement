package Admin;

import Store.ArrayDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Login_as_admin_control {

    @FXML
    private Button btn_login , btn_register;

    @FXML
    private TextField username ;

    @FXML
    private Text invalid ;

    @FXML
    private PasswordField password ;

    @FXML
    public void login(ActionEvent event) {
        String user = username.getText();
        String passwd = password.getText();
        String checkLogin = user+passwd;
        boolean canLogin = false;
        for (String i: ArrayDatabase.getUserName()) {
            if (i.equals(checkLogin));
            canLogin = true;
            break;
        }
        if (canLogin == true && event.getSource().equals(btn_login)) {

            Stage stage = (Stage) btn_login.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Manu.fxml"));
            try {
                stage.setScene(new Scene(loader.load(), 1280, 720));
                stage.setTitle("Login hotel management for admin");

                Manu_control controller = (Manu_control) loader.getController();
                controller.setUser(username.getText());

                stage.show();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else {
            invalid.setText("Invalid username or password");
        }
    }

    @FXML
    public void register(ActionEvent event) {
        btn_register = (Button) event.getSource();
        Stage stage = (Stage) btn_register.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Register.fxml")) ;

        try {
            stage.setScene(new Scene(loader.load(),1280,720));
            stage.setTitle("Register user");

            Register_control controller = (Register_control) loader.getController();

            stage.show();
        } catch (IOException e1){
            e1.printStackTrace();
        }
    }



}
