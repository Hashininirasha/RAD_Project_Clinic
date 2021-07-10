package sample;

import db.DBConnection;
import Classes.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.PathElement;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;

public class addPatient_Controller {

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtnic;

    @FXML
    private TextField txthome;

    @FXML
    private TextField txtcity;

    @FXML
    private TextField txtstreet;

    @FXML
    private DatePicker txtdob;

    @FXML
    private RadioButton checkmale;

    @FXML
    private ToggleGroup sex;

    @FXML
    private RadioButton checkfemale;

    @FXML
    private TextField txtphone;

    @FXML
    private Button register;

    DBConnection dbcon= new DBConnection();
    ResultSet rs;
    PreparedStatement ps;
    Patient patient;

    void cleatTexts(){
        txtname.setText("");
        txtnic.setText("");
        txthome.setText("");
        txtstreet.setText("");
        txthome.setText("");
        txtphone.setText("");
        txtdob.setValue(LocalDate.now());
        checkfemale.setSelected(false);
        checkmale.setSelected(false);
    }

    @FXML
    void onClickRegister(ActionEvent event) {
        patient = new Patient();
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);


        try{
            patient.setName(txtname.getText());
            patient.setNic(txtnic.getText());
            patient.setHomeNo(txthome.getText());
            patient.setStreetName(txtstreet.getText());
            patient.setCity(txtcity.getText());
            patient.setPhoneNumber(txtphone.getText());

            RadioButton selectedRB= (RadioButton) sex.getSelectedToggle();
            patient.setSex(selectedRB.getText());

            patient.setDob((LocalDate) txtdob.getValue());

            String query="INSERT INTO patient (P_Name,P_NIC,P_HomeNo,P_StreetName,P_City,P_DOB,P_Sex,P_pno) values (?,?,?,?,?,?,?,?)";
            Connection con = dbcon.getConnection();
            ps=con.prepareStatement(query);
            ps.setString(1,patient.getName());
            ps.setString(2,patient.getNic());
            ps.setString(3,patient.getHomeNo());
            ps.setString(4,patient.getStreetName());
            ps.setString(5,patient.getCity());
            ps.setObject(6, patient.getDob());
            ps.setString(7,patient.getSex());
            ps.setString(8,patient.getPhoneNumber());

            int i=ps.executeUpdate();
            if(i>0){
                alert1.setHeaderText("Successfully added the patient");
                alert1.showAndWait();
            }


        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Something wrong");
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(sw.toString())));
            alert.showAndWait();
        }

    }
}
