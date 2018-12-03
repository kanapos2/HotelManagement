package Admin;

import Model.User;
import Store.DBConnector;
import Store.UserDBControl;
import com.sun.javafx.cursor.CursorFrame;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

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
    protected AnchorPane superPane;

    @FXML
    public void login(ActionEvent event) {
        String user = username.getText();
        String passwd = password.getText();
        String checkLogin = user+passwd;
        boolean canLogin = false;
        UserDBControl userDBControl = DBConnector.openUserDB();
        ArrayList<User> userList = userDBControl.readUser();
        for (User anUserList : userList) {
            if (((anUserList.getUserName()) + (anUserList.getPassWord())).equals(checkLogin)) {
                System.out.println(((anUserList.getUserName()) + (anUserList.getPassWord())));
                canLogin = true;
            }
        }
        if (canLogin && event.getSource().equals(btn_login)) {

            Stage stage = (Stage) btn_login.getScene().getWindow();

            FXMLLoader loader_Manu = new FXMLLoader(getClass().getResource("/fontUI/Manu.fxml"));

            try {
                stage.setScene(new Scene(loader_Manu.load(), 1280, 720));
                stage.setTitle("Login hotel management for admin");

                Manu_control controller = (Manu_control) loader_Manu.getController();
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
