package sample;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminController implements Initializable {

    @FXML
    private Button btnTodayDetails;

    @FXML
    private Button btnUserDetails;

    @FXML
    private Button btnSetting;

    @FXML
    private AnchorPane home;



    AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {

            root = FXMLLoader.load(getClass().getResource("Today_Details-6.fxml"));
            home.getChildren().addAll(root);
        }catch (Exception e) {
            return;
        }
    }

    @FXML
    void onClickSetting(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("User_Settings-8.fxml"));
        home.getChildren().addAll(root);
    }

    @FXML
    void onClickTodayDetails(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Today_Details-6.fxml"));
        home.getChildren().addAll(root);
    }

    @FXML
    void onClickUserDetails(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("User_Details_Admin-7.fxml"));
        home.getChildren().addAll(root);
    }



}
