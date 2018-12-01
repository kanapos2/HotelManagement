package Admin;

import Model.Room;
import Store.DBConnector;
import Store.RoomDBConnector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Optional;

public class CheckOut_control {
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
    protected Label phone;

    @FXML
    protected Button canclebt,checkoutbt;

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
        firstName.setText(nowRoom.getFirstName());
        lastName.setText(nowRoom.getLastName());
        ID.setText(nowRoom.getPassport());
        sexual.setText(nowRoom.getSex());
        email.setText(nowRoom.getEmail());
        phone.setText(nowRoom.getPhoneNumber());
        Inday.setText(nowRoom.getCheckIn());
        Outday.setText(nowRoom.getCheckOut());

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
                DBConnector db = new DBConnector();
                Connection connection = db.openDatabase();
                RoomDBConnector roomDBConnector = new RoomDBConnector(connection);
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
