package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Helper.DBHandler;
import sample.Model.Staff;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Signup_Controller implements Initializable {


    @FXML
    private JFXButton back_signup;

    @FXML
    private JFXTextField signup_username;

    @FXML
    private JFXTextField signup_firstname;

    @FXML
    private JFXTextField signup_lastname;

    @FXML
    private JFXTextField signup_phone;

    @FXML
    private JFXPasswordField signup_password;

    @FXML
    private JFXButton signup_submit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        signup_submit.setOnAction(event->{
            createStaff();
        });
    }
    public void createStaff(){
        DBHandler handler = new DBHandler();
        String firstname = signup_firstname.getText();
        String lastname = signup_lastname.getText();
        String username = signup_username.getText();
        String password = signup_password.getText();
        String phone = signup_phone.getText();
        Staff newstaff = new Staff(firstname,lastname,username,password,phone);
        handler.addStaff(newstaff);
    }
}
