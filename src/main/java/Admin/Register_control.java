package Admin;

import Store.Database;
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


public class Register_control {

    @FXML
    private TextField accountID,userNamefield ;

    @FXML
    private Button btn_cancle , btn_confirm ;

    @FXML
    private TextField username , password , current_password ;

    @FXML
    private Label wrong_passwd ;

    Database database = new Database();

    @FXML
    public void genID(String id) {
        accountID.setText(id);
        accountID.setDisable(true);
    }

    @FXML
    public void checkPassword(ActionEvent event) {
        btn_confirm = (Button) event.getSource();
        String passwd = "" + password.getText();
        String current_passwd = "" + current_password.getText();
        if (passwd.length() >= 6 && current_passwd.equals(passwd)){
            Confirm(passwd);
        } else if (passwd.length() < 6) {
            wrong_passwd.setTextFill(Color.RED);
            wrong_passwd.setText("* Minimum password length: 6");
        }else {
            if (!passwd.equals(current_passwd)) {
                wrong_passwd.setTextFill(Color.RED);
                wrong_passwd.setText("wrong");
            }
            else {
                wrong_passwd.setTextFill(Color.GREEN);
                wrong_passwd.setText("Correct");
            }
        }
    }

    @FXML
    public void cancel(ActionEvent event) {
        btn_cancle = (Button) event.getSource();
        Stage cancleStage = (Stage) btn_cancle.getScene().getWindow();
        toLoginPage(cancleStage);
    }

    public void Confirm(String pw){ // Stored data and back to log-in page
        database.addDataRegister(String.valueOf(userNamefield.getText()),pw);
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
