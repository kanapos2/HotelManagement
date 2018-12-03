import animatefx.animation.BounceIn;
import animatefx.animation.FadeIn;
import animatefx.animation.FadeInDownBig;
import animatefx.animation.JackInTheBox;
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
        new FadeIn(root).play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
