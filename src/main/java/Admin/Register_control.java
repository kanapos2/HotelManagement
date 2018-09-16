package Admin;

import Model.User;
import Store.ArrayDatabase;
import Store.DBConnector;
import Store.UserDBControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;


public class Register_control {

    @FXML
    private TextField accountID,userNamefield ,firstnameField,lastnameField,emailField;

    @FXML
    private Button btn_cancle , btn_confirm ,check_btn;

    @FXML
    private TextField  password , current_password ;

    @FXML
    private Label wrong_passwd ;

    private ArrayList<User> listofUser;

    protected boolean checkBTNstate = false; // false ห้ามกด confirm
    protected int checkintsame = 0;


    @FXML
    public boolean checkSameuser(){
        for (int i = 0; i < listofUser.size(); i++) {
            if ((listofUser.get(i).getUserName() + "").equals(userNamefield.getText() + "")) { // ซ้ำหรือไม่
                checkBTNstate = false;
                checkintsame ++;
                break;
            }
        }if (checkintsame >= 1){
            userNamefield.setStyle("-fx-border-color: red");
            btn_confirm.setDisable(true);
            userNamefield.clear();
            checkintsame = 0;
        }else{
            userNamefield.setStyle("-fx-border-color: green");
            btn_confirm.setDisable(false);
            checkBTNstate = true;
        }
        return checkBTNstate;
    }

    public boolean isCheckBTNstate() {
        return checkBTNstate;
    }

    @FXML
    public void checkPassword(ActionEvent event) {
        Button b = (Button) event.getSource();
        String passwd = "" + password.getText();
        String current_passwd = "" + current_password.getText();
        DBConnector db = new DBConnector();
        Connection connect = db.openDatabase();
        UserDBControl list = new UserDBControl(connect);
        listofUser = list.readUser();
        if (b.equals(check_btn)) {
            checkSameuser();
        }
        if (b.equals(btn_confirm)){
            int addLetter = 0;
            for (int i = 0; i < emailField.getText().length(); i++) {
                if ((emailField.getText()).charAt(i) == '@'){
                    addLetter ++;
                }
            }
            if (passwd.length() >= 6 && current_passwd.equals(passwd) && isCheckBTNstate() == true && !accountID.getText().equals("") && !firstnameField.getText().equals("")
                    && !lastnameField.getText().equals("") && !emailField.getText().equals("") && addLetter == 1) {
                Confirm();
                checkBTNstate =false;
            } else if (passwd.length() < 6) {
                wrong_passwd.setTextFill(Color.RED);
                wrong_passwd.setText("* Minimum password length: 6");
            } else {
                if (!passwd.equals(current_passwd)) {
                    wrong_passwd.setTextFill(Color.RED);
                    wrong_passwd.setText("wrong");
                } else {
                    wrong_passwd.setTextFill(Color.GREEN);
                    wrong_passwd.setText("Correct");
                }
            }
        }
    }

    @FXML
    public void cancel(ActionEvent event) {
        btn_cancle = (Button) event.getSource();
        Stage cancleStage = (Stage) btn_cancle.getScene().getWindow();
        toLoginPage(cancleStage);
    }

    public void Confirm(){ // Stored data and back to log-in page
        DBConnector db = new DBConnector();
        Connection connection = db.openDatabase();
        UserDBControl userDBControl = new UserDBControl(connection);
//        User newUser = new User(accountID.getText(),userNamefield.getText(),firstnameField.getText(),lastnameField.getText(),
//                emailField.getText(),password.getText());
//        userDBControl.addUser(newUser);
        accountID.clear();
        userNamefield.clear();
        firstnameField.clear();
        lastnameField.clear();
        emailField.clear();
        password.clear();
        current_password.clear();
        Stage comfirmStage = (Stage) btn_confirm.getScene().getWindow();
        toLoginPage(comfirmStage);
    }
    @FXML
    public void toLoginPage(Stage stage){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Login_as_admin.fxml")) ;
        try {
            stage.setScene(new Scene(loader.load(),1280,720));
            stage.setTitle("Hotel Management");

            Login_as_admin_control controller = (Login_as_admin_control) loader.getController();

            stage.show();
        } catch (IOException e1){
            e1.printStackTrace();
        }
    }









}
