package Admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Manu_control {

    @FXML
    private Label user ;

    @FXML
    public void setUser(String name) {
        user.setText(name);
    }
}
