package seatX.Controller;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Login {
    public TextField userID;
    public TextField password;
    public Label label;
    public static String userIDa;
    public static int seatStatus;
    public static String SeatL;
    public static String RoutL;
    public static String TimeL;

    public void login(ActionEvent actionEvent) throws SQLException, IOException {

        Consql connectionClass = new Consql();
        Connection con = connectionClass.getConnection();
        Statement statement = con.createStatement();

        String id = userID.getText();
        String pass = password.getText();
        String sql = "SELECT * FROM `student`";
        ResultSet rs = statement.executeQuery(sql);

        boolean logged = false;
        while (rs.next()){
            if (id.equals(rs.getString(1))&&pass.equals(rs.getString(2))) {
                userIDa = rs.getNString(1);
                seatStatus = rs.getInt(3);
                SeatL = rs.getString(4);
                RoutL = rs.getString(5);
                TimeL = rs.getString(6);
                System.out.println(userIDa+" logged in "+seatStatus);
                logged = true;
                label.setText("");
                Parent root = FXMLLoader.load(getClass().getResource("View/time&route.fxml"));
                Scene scene = new Scene(root);
                Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
                break;
            }
        }
        if (logged==false) {
            label.setText("Wrong ID or Password");
            password.setText("");
        }
    }

    public void admin(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View/loginAD.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}