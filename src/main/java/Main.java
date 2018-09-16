import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fontUI/Login_as_admin.fxml"));
        primaryStage.setTitle("Hotel Management");
        primaryStage.setScene(new Scene(root, 1280 , 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
