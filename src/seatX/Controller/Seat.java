package seatX.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Seat implements Initializable {

    public RadioButton A1;
    public RadioButton A2;
    public RadioButton A3;
    public RadioButton A4;
    public RadioButton B1;
    public RadioButton B2;
    public RadioButton B3;
    public RadioButton B4;
    public RadioButton C1;
    public RadioButton C2;
    public RadioButton C3;
    public RadioButton C4;
    public RadioButton D1;
    public RadioButton D2;
    public RadioButton D3;
    public RadioButton D4;
    public RadioButton E1;
    public RadioButton E2;
    public RadioButton E3;
    public RadioButton E4;
    public RadioButton F1;
    public RadioButton F2;
    public RadioButton F3;
    public RadioButton F4;
    public RadioButton G1;
    public RadioButton G2;
    public RadioButton G3;
    public RadioButton G4;
    public RadioButton H1;
    public RadioButton H2;
    public RadioButton H3;
    public RadioButton H4;
    public RadioButton I1;
    public RadioButton I2;
    public RadioButton I3;
    public RadioButton I4;
    public RadioButton I5;
    public RadioButton I6;

    public ToggleGroup radioB;
    public Label lb1;
    public static boolean confirm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        radioB = new ToggleGroup();

        this.A1.setToggleGroup(radioB);
        this.A2.setToggleGroup(radioB);
        this.A3.setToggleGroup(radioB);
        this.A4.setToggleGroup(radioB);
        this.B1.setToggleGroup(radioB);
        this.B2.setToggleGroup(radioB);
        this.B3.setToggleGroup(radioB);
        this.B4.setToggleGroup(radioB);
        this.C1.setToggleGroup(radioB);
        this.C2.setToggleGroup(radioB);
        this.C3.setToggleGroup(radioB);
        this.C4.setToggleGroup(radioB);
        this.D1.setToggleGroup(radioB);
        this.D2.setToggleGroup(radioB);
        this.D3.setToggleGroup(radioB);
        this.D4.setToggleGroup(radioB);
        this.E1.setToggleGroup(radioB);
        this.E2.setToggleGroup(radioB);
        this.E3.setToggleGroup(radioB);
        this.E4.setToggleGroup(radioB);
        this.F1.setToggleGroup(radioB);
        this.F2.setToggleGroup(radioB);
        this.F3.setToggleGroup(radioB);
        this.F4.setToggleGroup(radioB);
        this.G1.setToggleGroup(radioB);
        this.G2.setToggleGroup(radioB);
        this.G3.setToggleGroup(radioB);
        this.G4.setToggleGroup(radioB);
        this.H1.setToggleGroup(radioB);
        this.H2.setToggleGroup(radioB);
        this.H3.setToggleGroup(radioB);
        this.H4.setToggleGroup(radioB);
        this.I1.setToggleGroup(radioB);
        this.I2.setToggleGroup(radioB);
        this.I3.setToggleGroup(radioB);
        this.I4.setToggleGroup(radioB);
        this.I5.setToggleGroup(radioB);
        this.I6.setToggleGroup(radioB);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View/time&route.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void select(ActionEvent actionEvent) throws IOException, SQLException {
        confirm = false;
        RadioButton selectedRadioButton = (RadioButton) radioB.getSelectedToggle();
        if (selectedRadioButton==null){
            lb1.setText("Select a seat first");
        }
        else{
            AlertBox.display(selectedRadioButton.getText());
            if (confirm==true)
            {

                Consql connectionClass=new Consql();
                Connection con = connectionClass.getConnection();
                Statement statement = con.createStatement();
                Login.SeatL = selectedRadioButton.getText();
                String sql = "UPDATE `student` SET `seat_status`=1,`seat_number`='"+selectedRadioButton.getText()+"',`route`='"+Login.RoutL+"',`time`='"+Login.TimeL+"' WHERE id='"+Login.userIDa+"'";
                statement.executeUpdate(sql);

                Login.seatStatus = 1;
                Parent root = FXMLLoader.load(getClass().getResource("View/time&route.fxml"));
                Scene scene = new Scene(root);
                Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
        }

    }

}
