package Admin;

import Model.Room;
import Model.User;
import Store.DBConnector;
import Store.RoomDBConnector;
import Store.UserDBControl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;

public class Reserve_info_control {

    private String nowLogin = "--";

    @FXML
    private TextField tf_FirstName , tf_LastName , tf_Passport , tf_Email , tf_PhoneNumber;

    @FXML
    protected RadioButton rd_male,rd_female;

    @FXML
    private DatePicker chIn , chOut;


    @FXML
    protected Label roomnumber , test , typeRoom , totalPriceLabel;

    @FXML
    private Button confirm , cancel;

    @FXML
    private CheckBox boxMr , boxMrs , boxMiss;

    private String numberOfRoom = "";

    private int roomPrice ;
    private int totalPrice;
    private LocalDate date1,date2;

    @FXML
    public void roomNumber(String number,int price) {
        roomnumber.setText(number);
        numberOfRoom = number;
        roomPrice = price;
        boxMr.setSelected(true);
        if (boxMr.isSelected()) {
            System.out.println(boxMr.getText());
        }
        else {
            System.out.println("-!-!-!-!-!-!-");
        }

        chIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (chOut.getValue()==null){
                    date1 = chIn.getValue();
                }else{
                    date1 = chIn.getValue();
                    calDate(date1,date2);
                }
            }
        });
        chOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                date2 = chOut.getValue();
                calDate(date1,date2);
            }
        });
    }

    public void calDate(LocalDate d1,LocalDate d2){
        long p2 = ChronoUnit.DAYS.between(d1, d2);
        totalPrice=0;
        totalPrice = (int) p2*roomPrice;
        if (totalPrice >= 0){
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }
    }


    @FXML
    public void name(){
        nowLogin = User.loginUser().getUserName();
        test.setText("Login as : "+nowLogin);
    }

    @FXML
    public void showTypeRoom(String type){
        typeRoom.setText(type);
    }

    @FXML
    public void cancelReserve(ActionEvent event){
        cancel = (Button) event.getSource();

        Stage stage = (Stage) confirm.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Manu.fxml"));

        try {
            stage.setScene(new Scene(loader.load(), 1280, 720));
            stage.setTitle("Reserve hotel");

            Manu_control controller = (Manu_control) loader.getController();
            controller.setUserAfterClickRoom();

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    public void handleComfirm(ActionEvent e){
        if (e.getSource().equals(confirm)){
//            checkRoomnumber();
            clickConfirmToBack(e);
        }
    }

    @FXML
    public void clickConfirmToBack(ActionEvent event){
        confirm = (Button) event.getSource();


        RoomDBConnector roomDBConnector = DBConnector.openRoomDB();
        RoomDBConnector historyDBConnector = DBConnector.openRoomDB();

        if ((!tf_FirstName.getText().equals("")) && (!tf_LastName.getText().equals("")) && !tf_Passport.getText().equals("") && !tf_Email.getText().equals("")
                && !tf_PhoneNumber.getText().equals("")  && chIn.getValue()!=null && chOut.getValue()!=null && (rd_male.isSelected() || rd_female.isSelected())){

            Room room = new Room(tf_FirstName.getText(),tf_LastName.getText(),
                    tf_Passport.getText(), tf_Email.getText(),tf_PhoneNumber.getText(),""+chIn.getValue(),""+chOut.getValue());
            room.setRoomNumber(numberOfRoom);
            room.setTotalprice(String.valueOf(totalPrice));
            if (rd_male.isSelected()){
                room.setSex(rd_male.getText());
                System.out.println(roomDBConnector.addInformation(room,1));
                System.out.println("Add to history :"+historyDBConnector.addHistory(room,3));
            }
            else {
                room.setSex(rd_female.getText());
                System.out.println(roomDBConnector.addInformation(room,1));
                System.out.println("Add to history :"+historyDBConnector.addHistory(room,3));
            }

            Stage stage = (Stage) confirm.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Manu.fxml"));

            try {
                stage.setScene(new Scene(loader.load(), 1280, 720));
                stage.setTitle("Reserve hotel");

                Manu_control controller = (Manu_control) loader.getController();
                controller.setUserAfterClickRoom();

                stage.show();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING,"Please complete the form.", ButtonType.OK);
            alert.setHeaderText("");
            alert.show();
        }
    }

//    public void checkRoomnumber(){
//        DBConnector db = new DBConnector();
//        Connection connection = db.openDatabase();
//        RoomDBConnector roomDBConnector = new RoomDBConnector(connection);
//        ArrayList<Room> roomList;
//        String nowRoom = roomnumber.getText();
//        roomList = roomDBConnector.readRoom();
//        for (int i = 0; i < roomList.size() ; i++) {
//            if (roomList.get(i).getRoomNumber().equals(nowRoom)){
//                Room now = roomList.get(i);
//                if (roomList.get(i).getRoomStatus() == 0){
//                    updateRoomStatus(now);
//                    now.setRoomStatus(1);
//                }else if (roomList.get(i).getRoomStatus() == 1){
//                    System.out.println("Room not available");
//                }
//            }
//        }
//    }

    public void updateRoomStatus(Room room){
        RoomDBConnector roomDBConnector = DBConnector.openRoomDB();
        roomDBConnector.updateRoom(room,1);
    }

}
