package Admin;

import Model.Room;
import Model.User;
import Store.DBConnector;
import Store.RoomDBConnector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Optional;

public class CheckOut_control {
    public String setLogin;

    protected Room nowRoom;
    @FXML
    protected Label typeRoom;

    @FXML
    protected Label roomnumber;

    @FXML
    protected Label loginAs;

    @FXML
    protected Label Inday;

    @FXML
    protected Label Outday;

    @FXML
    protected Label firstName;

    @FXML
    protected Label lastName;

    @FXML
    protected Label ID;

    @FXML
    protected Label sexual;

    @FXML
    protected Label email;

    @FXML
    protected Label phone,checkoutPrice;

    @FXML
    protected Button canclebt,checkoutbt;

    public void setSetLogin(String room) {
        this.setLogin = User.getUserObject().getUserName();
        loginAs.setText("Login as: "+setLogin);
        typeRoom.setText(room);
    }

    protected Manu_control manu_control;

    public void setManu_control(Manu_control manu_control) {
        this.manu_control = manu_control;
    }

    public void setNowRoom(Room nowRoom) {
        this.nowRoom = nowRoom;
        System.out.println(this.nowRoom);
        startSetScene();
    }

    public void startSetScene(){
        roomnumber.setText(nowRoom.getRoomNumber());
        firstName.setText(nowRoom.getFirstName());
        lastName.setText(nowRoom.getLastName());
        ID.setText(nowRoom.getPassport());
        sexual.setText(nowRoom.getSex());
        email.setText(nowRoom.getEmail());
        phone.setText(nowRoom.getPhoneNumber());
        Inday.setText(nowRoom.getCheckIn());
        Outday.setText(nowRoom.getCheckOut());
        checkoutPrice.setText(nowRoom.getTotalprice());

        canclebt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING,"Do you want to cancel ?", ButtonType.YES,ButtonType.NO);
                alert.setHeaderText("");
                Optional optional = alert.showAndWait();
                if (optional.get().equals(ButtonType.YES)){
                    Stage stage = (Stage) ID.getScene().getWindow();
                    manu_control.vBox.setDisable(false);
                    stage.close();
                }else {
                    return;
                } }});

        checkoutbt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RoomDBConnector roomDBConnector = DBConnector.openRoomDB();
                Alert alert = new Alert(Alert.AlertType.WARNING,"Do you want to confirm check-out ?", ButtonType.YES,ButtonType.NO);
                alert.setHeaderText("");
                Optional optional = alert.showAndWait();
                if (optional.get().equals(ButtonType.YES)){
                    roomDBConnector.updateRoomCheckOut(nowRoom,0);
                    Stage stage = (Stage) ID.getScene().getWindow();
                    manu_control.vBox.setDisable(false);
                    manu_control.start();
                    stage.close();
                }else {
                    return;
                }
            }
        });
    }

}
