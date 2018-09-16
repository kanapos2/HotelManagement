package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class Forth_Seven_Floor_control {

    @FXML
    private Button btn_back;

    @FXML
    public void backFloor(ActionEvent event){
        btn_back = (Button) event.getSource();

        Stage stage = (Stage) btn_back.getScene().getWindow();

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
