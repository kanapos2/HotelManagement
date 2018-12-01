package Admin;

import Model.Room;
import Store.DBConnector;
import Store.RoomDBConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;


public class Forth_Seven_Floor_control {

    private String lastLogin;
    private String[] roomName = {"D4","E5","F6","G7"} ;
    private String typeRoom = "";

    private ArrayList<String> numberOfRoom = new ArrayList<>();

    @FXML
    private Button btn_back;

    @FXML
    private AnchorPane thirdFloor  ;

    @FXML
    private Button D401,D402,D403,D404,D405,D406,D407,D408,D409,D410,D411,
            E501,E502,E503,E504,E505,E506,E507,E508,E509,E510,E511,
            F601,F602,F603,F604,F605,F606,F607,F608,F609,F610,F611,
            G701,G702,G703,G704,G705,G706,G707,G708,G709,G710,G711;


    @FXML
    public void nameLogin(String name) {
        lastLogin = name;
        Scene scene = thirdFloor.getScene();
        String roomNum = "";

        start();
    }




    @FXML
    public void start(){
        DBConnector db = new DBConnector();
        Connection connection = db.openDatabase();
        RoomDBConnector roomDBConnector = new RoomDBConnector(connection);

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



        Scene scene = thirdFloor.getScene();
        for (Room s : roomDBConnector.readRoom()){
            for (int i=0 ;i<numberOfRoom.size() ; i++){
                if (s.getRoomNumber().equals(numberOfRoom.get(i))){
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
    public void reserveRoom(ActionEvent event) {
        Button roomNumber = (Button) event.getSource();
        String room = "";
        int roomPrice = 0;

        String roomNum = "" ;
        Scene scene = thirdFloor.getScene();
        for (String s : roomName) {
            for (int i = 1; i <= 11; i++) {
                if (i < 10) {
                    roomNum = s + "0" + i;
                } else {
                    roomNum = s + i;
                }
                Button newRoomNum = (Button) scene.lookup("#" + roomNum);
                if (roomNumber.equals(newRoomNum)){
                    room = roomNum;
                    if (roomNum.equals("D401") || roomNum.equals("E501") || roomNum.equals("F601") || roomNum.equals("G701")){
                        typeRoom = "Family room";
                        roomPrice = 9000;
                    }
                    else if (roomNum.equals("D402") || roomNum.equals("E502") || roomNum.equals("F602") || roomNum.equals("G702")){
                        typeRoom = "Presidential suite";
                        roomPrice = 12000;
                    }
                    else if (roomNum.equals("D403") || roomNum.equals("E503") || roomNum.equals("F603") || roomNum.equals("G703")){
                        typeRoom = "Junior suite";
                        roomPrice = 6500;
                    }
                    else if (roomNum.equals("D404") || roomNum.equals("D406") || roomNum.equals("D408") || roomNum.equals("D410") ||
                            roomNum.equals("E504") || roomNum.equals("E506") || roomNum.equals("E508") || roomNum.equals("E510") ||
                            roomNum.equals("F604") || roomNum.equals("F606") || roomNum.equals("F608") || roomNum.equals("F610") ||
                            roomNum.equals("G704") || roomNum.equals("G706") || roomNum.equals("G708") || roomNum.equals("G710"))  {
                        typeRoom = "Super Deluxe";
                        roomPrice = 5500;
                    }
                    else if (roomNum.equals("D405") || roomNum.equals("D407") || roomNum.equals("D409") ||
                            roomNum.equals("E505") || roomNum.equals("E507") || roomNum.equals("E509") ||
                            roomNum.equals("F605") || roomNum.equals("F607") || roomNum.equals("F609") ||
                            roomNum.equals("G705") || roomNum.equals("G707") || roomNum.equals("G709")) {
                        typeRoom = "Deluxe";
                        roomPrice = 4600;
                    }
                    else {
                        typeRoom = "Superior" ;
                        roomPrice = 4000;
                    }
                }
            }
        }


            Stage stage = (Stage) roomNumber.getScene().getWindow();

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

    @FXML
    public void backFloor(ActionEvent event){
        btn_back = (Button) event.getSource();

        Stage stage = (Stage) btn_back.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Manu.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 1280, 720));
            stage.setTitle("Reserve hotel");

            Manu_control controller = (Manu_control) loader.getController();
            controller.setUserAfterClickRoom(lastLogin);

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
