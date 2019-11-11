package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Login_Controller implements Initializable{

    @FXML
    private JFXTextField login_username;

    @FXML
    private JFXTextField login_password;

    @FXML
    private JFXButton login_Button;

    @FXML
    private JFXButton signup_Button;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        signup_Button.setOnAction(event->{
            signup_Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/View/Signup.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    }
}
