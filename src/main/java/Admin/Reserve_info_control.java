package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Reserve_info_control {

    @FXML
    private Label roomnumber;

    @FXML
    private Button testback;

    @FXML
    public void roomNumber(String number) {
        roomnumber.setText(number);
    }


    @FXML
    public void back(ActionEvent event){
        testback = (Button) event.getSource();

        Stage stage = (Stage) testback.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Manu.fxml"));

        try {
            stage.setScene(new Scene(loader.load(), 1280, 720));
            stage.setTitle("Reserve hotel");

            Manu_control controller = (Manu_control) loader.getController();

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}