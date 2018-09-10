import Home.Home_page_control;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Enter_web_control {

    @FXML
    protected Button btn_enter ;

    @FXML
    public void enterNextPage(ActionEvent event) {
        Button btn_enter = (Button) event.getSource();
        Stage stage = (Stage) btn_enter.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Home_page.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 1000, 800));

            Home_page_control controller = (Home_page_control) loader.getController();
//            controller.set("Due");

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
