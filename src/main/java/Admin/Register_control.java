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
import java.util.regex.Pattern;


public class Register_control {

    @FXML
    private TextField accountID,userNamefield ,firstnameField,lastnameField,emailField,phoneField;

    @FXML
    private Button btn_cancle , btn_confirm ,check_btn;

    @FXML
    private TextField  password , current_password ;


    private ArrayList<User> listofUser;

    protected boolean checkBTNstate = false; // false ห้ามกด confirm
    protected int checkintsame = 0;
    protected boolean pwdPass = false; // เช็คพาสเวิด ห้ามมีอัขระ และมีตัวเลขอย่างน้อย 1 ตัว


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
            passWordinputletter(password.getText()+"");
            int addLetter = 0;
            for (int i = 0; i < emailField.getText().length(); i++) {
                if ((emailField.getText()).charAt(i) == '@'){
                    addLetter ++;
                }
            }
            if (passwd.length() >= 6 && current_passwd.equals(passwd) && isCheckBTNstate() == true && !accountID.getText().equals("") && !firstnameField.getText().equals("")
                    && !lastnameField.getText().equals("")&& !phoneField.getText().equals("") && !emailField.getText().equals("") && addLetter == 1 && pwdPass == true) {
                Confirm();
                checkBTNstate =false;
                pwdPass = false;
            }if (accountID.getText().equals("")){
                accountID.setStyle("-fx-border-color: red");
            }if (firstnameField.getText().equals("")){
                firstnameField.setStyle("-fx-border-color: red");
            }if (lastnameField.getText().equals("")){
                lastnameField.setStyle("-fx-border-color: red");
            }if (phoneField.getText().equals("")){
                phoneField.setStyle("-fx-border-color: red");
            }if (emailField.getText().equals("")) {
                emailField.setStyle("-fx-border-color: red");
            }if (addLetter == 0){
                emailField.setStyle("-fx-border-color: red");
            }if (!accountID.getText().equals("")){
                accountID.setStyle("-fx-border-color: green");
            }if (!firstnameField.getText().equals("")){
                firstnameField.setStyle("-fx-border-color: green");
            }if (!lastnameField.getText().equals("")){
                lastnameField.setStyle("-fx-border-color: green");
            }if (!phoneField.getText().equals("")){
                phoneField.setStyle("-fx-border-color: green");
            }if (!emailField.getText().equals("")){
                emailField.setStyle("-fx-border-color: green");
            }else if (passwd.length() < 6) {
                password.setStyle("-fx-border-color: red");
                current_password.setStyle("-fx-border-color: red");
            }else {
                if (!passwd.equals(current_passwd)) {
                    password.setStyle("-fx-border-color: red");
                } else {
                    password.setStyle("-fx-border-color: red");
                    current_password.setStyle("-fx-border-color: red");
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
        User newUser = new User(accountID.getText(),userNamefield.getText(),firstnameField.getText(),lastnameField.getText(),phoneField.getText(),
                emailField.getText(),password.getText());
        userDBControl.addUser(newUser);
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
    public boolean passWordinputletter(String input){
        String checkNumber =""; //แทนตัวเลข
        for (int i = 0; i < input.length() ; i++) {
            if (input.charAt(i) == '1' || input.charAt(i) == '2' || input.charAt(i) == '3' || input.charAt(i) == '4' || input.charAt(i) == '5'
            || input.charAt(i) == '6' || input.charAt(i) == '7' || input.charAt(i) == '8' || input.charAt(i) == '9' || input.charAt(i) == '0'){
                checkNumber += "a";
            } else {
                checkNumber += input.charAt(i);
            }
        }
        if (Pattern.matches("[a-zA-Z]+", checkNumber) && !checkNumber.equals(input)){
            this.pwdPass = true;
        }else {
            this.pwdPass = false;
            password.setStyle("-fx-border-color: red");
        }
        System.out.println(pwdPass+"");
        return isPwdPass();
    }

    public boolean isPwdPass() {
        return pwdPass;
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
