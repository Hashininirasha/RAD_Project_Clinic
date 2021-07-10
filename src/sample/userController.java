package sample;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class userController implements Initializable {

    @FXML AnchorPane holderpane;
    AnchorPane home;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        createPage();

    }
    private void setNode(Node node){
        holderpane.getChildren().clear();
        holderpane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();

    }

    private void createPage() {


        try {
            home = FXMLLoader.load(getClass().getResource("/FXML/give_token-2.fxml"));
            setNode(home);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            home = FXMLLoader.load(getClass().getResource("/FXML/add_Patient-3.fxml"));
            setNode(home);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            home = FXMLLoader.load(getClass().getResource("/FXML/User_Details-4.fxml"));
            setNode(home);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            home = FXMLLoader.load(getClass().getResource("/FXML/Change_pw-5.fxml"));
            setNode(home);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
