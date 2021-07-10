package sample;


import db.DBConnection;
import Classes.User;
import Classes.encryption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controller {

    @FXML
    private TextField txtname;

    @FXML
    private Button login;

    @FXML
    private PasswordField txtpw;

    @FXML
    private Button btnClose;

    Stage stage;
    Scene scene;
    Parent root;

    String sessionID;
    DBConnection dbcon= new DBConnection();
    ResultSet rs;
    PreparedStatement ps;
    User user;
    encryption enc;
    @FXML
    void onCloseClick(ActionEvent event) throws Exception{

        stage = (Stage) btnClose.getScene().getWindow();
        stage.close();


    }

    @FXML
    void switchtotest(ActionEvent event) throws Exception {
        enc= new encryption();
        user = new User();

        user.setUsername(txtname.getText().trim());
        user.setPassword(enc.encryptPass(txtpw.getText().trim()));


        try{
            Connection con= dbcon.getConnection();
            String query = "SELECT U_Id,U_Name,U_Password,usertype FROM user WHERE U_Name=? AND U_Password=?";
            ps = con.prepareStatement(query);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            rs= ps.executeQuery();
            if(rs.next()){
                if(rs.getString("usertype").equals("admin")){
                    root = FXMLLoader.load(getClass().getResource("admin_nav.fxml"));
                    scene = new Scene(root);
                }
                else{
//                    root = FXMLLoader.load(getClass().getResource("user_nav.fxml"));
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("user_nav.fxml")
                    );
                    scene = new Scene((Parent) loader.load());

                    user_nav_Controller controller =
                            loader.<user_nav_Controller>getController();
                    controller.initSessionID(rs.getInt("U_Id")); //get the id of the current user
                }

                stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
//              scene = new Scene;
                stage.setScene(scene);
                stage.show();
            }
            else{
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setHeaderText("Username or Password incorrect.");
                StringWriter sw = new StringWriter();
//                alert1.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(sw.toString())));
                alert1.showAndWait();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }


}
