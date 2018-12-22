package Admin;

import Model.User;
import Store.DBConnector;
import Store.UserDBControl;
import animatefx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Login_as_admin_control {

    @FXML
    private Button btn_login , btn_back;

    @FXML
    private TextField username ;

    @FXML
    private Text invalid ;

    @FXML
    private PasswordField password ;



    public void initialize(){

    }

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
                ////// skeleton pattern //////
                User currentLoginUser = User.getInstance();
                currentLoginUser.setiDentify(anUserList.getiDentify());
                currentLoginUser.setUserName(anUserList.getUserName());
                currentLoginUser.setFirstName(anUserList.getFirstName());
                currentLoginUser.setLastName(anUserList.getLastName());
                currentLoginUser.setPhone(anUserList.getPhone());
                currentLoginUser.seteMail(anUserList.geteMail());

            }
        }
        if (canLogin && event.getSource().equals(btn_login)) {

            Stage stage = (Stage) btn_login.getScene().getWindow();

            FXMLLoader loader_Manu = new FXMLLoader(getClass().getResource("/fontUI/Manu.fxml"));

            try {
                stage.setScene(new Scene(loader_Manu.load(), 1280, 720));
                stage.setTitle("Login hotel management for admin");


                Manu_control controller = (Manu_control) loader_Manu.getController();
                controller.setUser();
                stage.show();
                new FadeIn(stage.getScene().getRoot()).play();


            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else {
            invalid.setText("Invalid username or password");
            new Shake(username.getScene().getRoot()).play();
        }
    }

    @FXML
    public void backToPermission(ActionEvent event) {
        btn_back = (Button) event.getSource();
        Stage stage = (Stage) btn_back.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Permission.fxml")) ;

        try {
            stage.setScene(new Scene(loader.load(),1280,720));
            stage.setTitle("Home");
            new FadeInDownBig(stage.getScene().getRoot()).play();
            Permission_control controller = (Permission_control) loader.getController();

            stage.show();
        } catch (IOException e1){
            e1.printStackTrace();
        }
    }





}
