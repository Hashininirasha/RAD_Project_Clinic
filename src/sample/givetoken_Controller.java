package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class givetoken_Controller {

    @FXML
    private Button search;

    @FXML
    private Button token;

    @FXML
    private Label lblname;

    @FXML
    private Label lbladdress;

    @FXML
    private Label lbldob;

    @FXML
    private Label lblgender;

    @FXML
    private Label lblphone;

    int sessId;

    public void initSessionID(int sessionID) {
        sessId=sessionID;
        System.out.println(sessId);
    }
}
