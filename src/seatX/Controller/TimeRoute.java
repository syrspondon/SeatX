package seatX.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TimeRoute implements Initializable {
    public ComboBox<String> route;
    public ComboBox<String> time;
    public Label lb1;
    public Label lb2;
    public Label lb3;
    public Label lbs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        route.getItems().addAll("Route 1","Route 2","Route 3","Route 4");
        time.getItems().addAll("2:00 pm","3:00 pm","4:00 pm","5:00 pm");
        if (Login.seatStatus==0){
            lb3.setText("No seat is booked yet");
        }
        else
        {
            lb3.setText(Login.RoutL+"\nTime "+Login.TimeL+"\nSeat no. "+Login.SeatL);
        }
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View/login.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void select(ActionEvent actionEvent) throws IOException {
        if (Login.seatStatus==1){
            lbs.setText("Seat is already booked");
        }
        else if (route.getValue()==null||time.getValue()==null)
        {
            if (route.getValue()==null)
                lb1.setText("Not Selected");
            if (time.getValue()==null)
                lb2.setText("Not Selected");
        }
        else{
            Login.RoutL = route.getValue();
            Login.TimeL = time.getValue();
            System.out.println(Login.RoutL+"  "+Login.TimeL);
            Parent root = FXMLLoader.load(getClass().getResource("View/seat.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }
    }

    public void routeB(ActionEvent actionEvent) {
        lb1.setText("");
    }

    public void timeB(ActionEvent actionEvent) {
        lb2.setText("");
    }
}