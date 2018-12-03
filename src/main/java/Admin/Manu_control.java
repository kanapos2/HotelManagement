package Admin;

import Model.Clock;
import Model.Room;
import Store.DBConnector;
import Store.RoomDBConnector;
import Store.UserDBControl;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class Manu_control extends Clock {

    private String lastLogin = "";
    private String[] roomName = {"B2","C3"} ;
    private String typeRoom = "";

    @FXML
    protected VBox vBox;

    private int second , hour , minute;

    @FXML
    private Label user , timeZone ,datefield  ;

    @FXML
    private AnchorPane firstFloor ;

    @FXML
    protected Button btn_signout, btn_next , btn_information,historyBtn ;

    @FXML
    private Button B201,B202,B203,B204,B205,B206,B207,B208,B209,B210,B211,
            C301,C302,C303,C304,C305,C306,C307,C308,C309,C310,C311;


    private ArrayList<String> numberOfRoom = new ArrayList<>();

    @FXML
    public void setUser(String name) {
        user.setText("Login as : " + name);
        lastLogin = name;

        start();
        super.showClock(timeZone);
        datefield.setText(super.showDate());
    }



    @FXML
    public void start(){
        RoomDBConnector roomDBConnector = DBConnector.openRoomDB();

        System.out.println("@@@@@@@@@");


        String roomNum = "" ;
        for (String s : roomName) {
            for (int i = 1; i <= 11; i++) {
                if (i < 10) {
                    roomNum = s + "0" + i;
                } else {
                    roomNum = s + i;
                }
                numberOfRoom.add(roomNum);
            }
        }



        Scene scene = firstFloor.getScene();
        for (Room s : roomDBConnector.readRoom()){
//            System.out.println(numberOfRoom);
            for (int i=0 ;i<numberOfRoom.size() ; i++){
//                System.out.println("OUTSIDE");
                if (s.getRoomNumber().equals(numberOfRoom.get(i))){
//                    System.out.println("DEBUG");
                    Button newRoomNum = (Button) scene.lookup("#"+numberOfRoom.get(i));
                    if (s.getRoomStatus()==1){
                        newRoomNum.setStyle("-fx-background-color: #ff3333");
                    }
                    else {
                        newRoomNum.setStyle("-fx-background-color: lightblue");
                    }
                }
            }
        }

    }



    @FXML
    public void setUserAfterClickRoom(String name){
        lastLogin = name;
        user.setText("Login as : "+name);

        start();
    }


    @FXML
    public void nextFloor(ActionEvent event){
        btn_next = (Button) event.getSource();
        Stage stage = (Stage) btn_signout.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Forth_Seven_Floor.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 1280, 720));
            stage.setTitle("4th-7th");

            Forth_Seven_Floor_control controller = (Forth_Seven_Floor_control) loader.getController();
            controller.nameLogin(lastLogin);

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    @FXML
    public void setHistoryBtn(ActionEvent event){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/History.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 1000, 600));
            stage.setTitle("Reserve History Information");
            History_Control controller = (History_Control) loader.getController();
            controller.setShow();
            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    public void signOut(ActionEvent event) {
        System.out.println("Sign out");

        btn_signout = (Button) event.getSource();

        Stage stage = (Stage) btn_signout.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Login_as_admin.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 1280, 720));
            stage.setTitle("Login hotel management for admin");

            Login_as_admin_control controller = (Login_as_admin_control) loader.getController();

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    public void reserveRoom(ActionEvent event){
        Button roomNumber = (Button) event.getSource();
        String room = "" ;
        int roomPrice = 0;

        RoomDBConnector roomDBConnector = DBConnector.openRoomDB();

        Scene scene = firstFloor.getScene();
        String roomNum = "";
        for (String s : roomName){
            for (int i=1 ; i<=11 ; i++){
                if (i<10) {
                    roomNum = s + "0" +i ;
                }
                else {
                    roomNum = s + i ;
                }
                //numberOfRoom.add(roomNum);

                Button newRoomNum = (Button) scene.lookup("#"+roomNum);
                if (roomNumber.equals(newRoomNum)){
                    if (roomNum.equals("B201") || roomNum.equals("C301")){
                        typeRoom = "Family room";
                        room = newRoomNum.getText();
                        roomPrice = 9000;
                    }
                    else if (roomNum.equals("B202") || roomNum.equals("C302")) {
                        typeRoom = "Presidential suite";
                        room = newRoomNum.getText();
                        roomPrice = 12000;
                    }
                    else if (roomNum.equals("B203") || roomNum.equals("C303")) {
                        typeRoom = "Junior suite" ;
                        room = newRoomNum.getText();
                        roomPrice = 6500;
                    }
                    else if (roomNum.equals("B204") || roomNum.equals("B206") || roomNum.equals("B208") || roomNum.equals("B210") ||
                            roomNum.equals("C304") || roomNum.equals("C306") || roomNum.equals("C308") || roomNum.equals("C310")) {
                        typeRoom = "Super Deluxe";
                        room = newRoomNum.getText();
                        roomPrice = 5500;
                    }
                    else if (roomNum.equals("B205") || roomNum.equals("B207") || roomNum.equals("B209") ||
                            roomNum.equals("C305") || roomNum.equals("C307") || roomNum.equals("C309")) {
                        typeRoom = "Deluxe";
                        room = newRoomNum.getText();
                        roomPrice = 4600;
                    }
                    else {
                        typeRoom = "Superior";
                        room = newRoomNum.getText();
                        roomPrice = 4000;
                    }
                }
            }
        }


        for (Room s : roomDBConnector.readRoom()){
            if (room.equals(s.getRoomNumber())){
                System.out.println("----------- DEBUG ----------");
                System.out.println(room);
                System.out.println(s.getRoomNumber());
                System.out.println(s.getRoomStatus());
                System.out.println("----------- DEBUG ----------");
                if (s.getRoomStatus()==0){
                    Stage stage = (Stage) roomNumber.getScene().getWindow();
                    System.out.println(roomPrice);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Reserve_info.fxml"));
                    try {
                        stage.setScene(new Scene(loader.load(), 1280, 720));
                        stage.setTitle("Reserve info");

                        Reserve_info_control controller = (Reserve_info_control) loader.getController();
                        controller.roomNumber(room,roomPrice);
                        controller.name(lastLogin);
                        controller.showTypeRoom(typeRoom);

                        stage.show();

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
                else {
                    Stage stage = new Stage();

                    vBox.setDisable(true);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/CheckOut.fxml"));
                    try {
                        stage.setScene(new Scene(loader.load(), 580, 400));
                        stage.setTitle("Reserve info");
                        CheckOut_control controller = (CheckOut_control) loader.getController();
                        controller.setNowRoom(s);
                        controller.setManu_control(this);

                        stage.show();

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
            }
        }
    }


    @FXML
    public void informationPage(ActionEvent event){
        boolean status = true;
        while (status){
            RoomDBConnector roomDBConnector = DBConnector.openRoomDB();
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Enter your room number");
            dialog.setContentText("Number:");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                for (Room room:roomDBConnector.readRoom()) {
                    if ((result.get().equals(room.getRoomNumber())) && room.getRoomStatus() == 1){
                        status = false;
                        Stage stage = new Stage();
                        vBox.setDisable(true);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Information.fxml"));
                        try {
                            stage.setScene(new Scene(loader.load(), 580, 400));
                            stage.setTitle("Information");
                            Information_control controller = (Information_control) loader.getController();
                            System.out.println(room.getTotalprice());
                            controller.setNowInfo(room);
                            controller.setManu_control(this);
                            stage.show();

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }else{
                status = false;
            }
        }
    }

    @FXML
    public void openVbox(){
        vBox.setDisable(false);
    }

}
