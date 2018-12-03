package Admin;

import Model.Clock;
import Model.Room;
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

public class Information_control extends Clock {

    @FXML
    protected Label timeInformation,chIn,chOut,fName,lName,sexual,mail,phone,pass;

    @FXML
    protected Label thisPrice,roomID;

    @FXML
    private Button close ;

    protected Room nowInfo;

    protected Manu_control manu_control;

    public void setNowInfo(Room nowInfo) {
        this.nowInfo = nowInfo;
        setShowInformation();
    }

    public void setManu_control(Manu_control manu_control) {
        this.manu_control = manu_control;
    }
    @FXML
    public void initialize(){
        super.showClock(timeInformation);
    }

    @FXML
    public void setShowInformation(){
        roomID.setText(nowInfo.getRoomNumber());
        chIn.setText(nowInfo.getCheckIn());
        chOut.setText(nowInfo.getCheckOut());
        fName.setText(nowInfo.getFirstName());
        lName.setText(nowInfo.getLastName());
        pass.setText(nowInfo.getPassport());
        sexual.setText(nowInfo.getSex());
        mail.setText(nowInfo.getEmail());
        phone.setText(nowInfo.getPhoneNumber());
        thisPrice.setText(nowInfo.getTotalprice());
    }





    @FXML
    public void closeInfor(){
       Stage stage = (Stage) timeInformation.getScene().getWindow();
       manu_control.openVbox();
       stage.close();
    }
}
