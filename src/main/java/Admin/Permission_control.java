package Admin;

import animatefx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.Optional;

public class Permission_control {

    @FXML
    private Button btn_Admin, btn_User ;

    @FXML
    protected AnchorPane superStage;


    @FXML
    public void clickUser(ActionEvent event){
        btn_User = (Button) event.getSource();

        Stage stage = (Stage) btn_User.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Login_as_admin.fxml"));
        try {
            stage.setScene(new Scene(loader.load(),1280,720));
            stage.setTitle("Hotel Management");
            new Pulse(stage.getScene().getRoot()).play();
            Login_as_admin_control controller = (Login_as_admin_control) loader.getController();

            stage.show();
        } catch (IOException e1){
            e1.printStackTrace();
        }
    }

    @FXML
    public void clickAdmin(ActionEvent event){
        btn_Admin= (Button) event.getSource();

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login as admin");

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        TextField id = new TextField();
        id.setPromptText("ID");
        TextField pass = new TextField();
        pass.setPromptText("Password");

        gridPane.add(id, 0, 0);
        gridPane.add(new Label("Pass :"), 1, 0);
        gridPane.add(pass, 2, 0);

        dialog.getDialogPane().setContent(gridPane);

        // Request focus on the username field by default.
        Platform.runLater(() -> id.requestFocus());

        // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(id.getText(), pass.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(pair -> {
            System.out.println("From=" + pair.getKey() + ", To=" + pair.getValue());
            if (pair.getKey().equals("admin") && pair.getValue().equals("admin")){
                System.out.println("-------- Login --------");
                Stage stage = (Stage) btn_Admin.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fontUI/Register.fxml")) ;
                try {
                    stage.setScene(new Scene(loader.load(),1280,720));
                    stage.setTitle("Hotel Management");
                    new FadeInDownBig(stage.getScene().getRoot()).play();
                    Register_control controller = (Register_control) loader.getController();

                    stage.show();
                } catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        });





    }
}
