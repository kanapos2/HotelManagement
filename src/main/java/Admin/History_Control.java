package Admin;

import Model.Room;
import Store.DBConnector;
import Store.RoomDBConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class History_Control {

    protected ObservableList<Room> showReserve = FXCollections.observableArrayList();

    @FXML
    public ListView<Room> list;

    public void setShow(){
        readRoomHistory();
        list.setItems(showReserve);
    }

    public void readRoomHistory(){
        RoomDBConnector roomDBConnector = DBConnector.openRoomDB();
        showReserve.addAll(roomDBConnector.readHistory());
        for (Room room : showReserve) {
            System.out.println(room);
        }
    }


}
