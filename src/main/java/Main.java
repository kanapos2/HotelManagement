import animatefx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fontUI/Permission.fxml"));
        primaryStage.setTitle("Hotel Management");
        primaryStage.setScene(new Scene(root, 1280 , 720));
        primaryStage.show();
        new Pulse(root).play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
