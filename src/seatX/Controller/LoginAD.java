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
import seatX.Model.Consql;

public class LoginAD {
    public TextField user;
    public TextField password;
    public Label lb;

    public void login(ActionEvent actionEvent) throws SQLException, IOException {

        Consql connectionClass = new Consql();
        Connection con = connectionClass.getConnection();
        Statement statement = con.createStatement();

        String id = user.getText();
        String pass = password.getText();
        String sql = "SELECT * FROM `administrator`";
        ResultSet rs = statement.executeQuery(sql);

        boolean logged = false;
        while (rs.next()){
            if (id.equals(rs.getString(1))&&pass.equals(rs.getString(2))) {
                System.out.println(user.getText()+" logged in ");
                logged = true;
                lb.setText("");
                Parent root = FXMLLoader.load(getClass().getResource("View/studentdata.fxml"));
                Scene scene = new Scene(root);
                Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
                break;
            }
        }
        if (logged==false)
        {
            lb.setText("Wrong ID or Password");
            password.setText("");
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View/login.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}