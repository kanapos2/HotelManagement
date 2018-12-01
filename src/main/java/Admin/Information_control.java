package Admin;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Information_control {

    @FXML
    private Label timeInformation;

    @FXML
    private Button close ;

    protected Manu_control manu_control;

    public void setManu_control(Manu_control manu_control) {
        this.manu_control = manu_control;
    }

    @FXML
    public void initialize(){
        Timeline c = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String timer = now.format(formatter);
            timeInformation.setText(timer);

        }),
                new KeyFrame(Duration.seconds(1))
        );
        c.setCycleCount(Animation.INDEFINITE);
        c.play();
    }

    @FXML
    public void closeInfor(){
       Stage stage = (Stage) timeInformation.getScene().getWindow();
       manu_control.openVbox();
       stage.close();
    }
}
