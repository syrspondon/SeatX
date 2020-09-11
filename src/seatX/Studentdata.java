package seatX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Studentdata implements Initializable {

    ObservableList<Student> data=FXCollections.observableArrayList();
    @FXML TableView table;
    @FXML public TableColumn<Student, String> col_id;
    @FXML public TableColumn<Student, String> col_route;
    @FXML public TableColumn<Student, String> col_time;
    @FXML public TableColumn<Student, String> col_seat;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            showintable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void showintable() throws SQLException {
        start();
        col_id.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
        col_route.setCellValueFactory(new PropertyValueFactory<Student,String>("route"));
        col_time.setCellValueFactory(new PropertyValueFactory<Student,String>("time"));
        col_seat.setCellValueFactory(new PropertyValueFactory<Student,String>("seat"));
        table.setItems(data);
    }

    public void start() throws SQLException {
        Consql connectionClass = new Consql();
        Connection con = connectionClass.getConnection();
        Statement statement = con.createStatement();
        String sql = "SELECT * FROM `student`";
        ResultSet rs = statement.executeQuery(sql);
        String stringvalue[]=new String[4];
        while (rs.next()){
            stringvalue[0] = rs.getString(1);
            stringvalue[1] = rs.getString(5);
            stringvalue[2] = rs.getString(6);
            stringvalue[3] = rs.getString(4);
            data.add(new Student(stringvalue[0],stringvalue[1],stringvalue[2],stringvalue[3]));
        }
    }

    public void delete(ActionEvent actionEvent) throws SQLException {
        ObservableList<Student> selected;
        if (!table.getSelectionModel().getSelectedItems().isEmpty()) {
            selected = table.getSelectionModel().getSelectedItems();
            String a = selected.get(0).getId();
            Consql connectionClass = new Consql();
            Connection con = connectionClass.getConnection();
            Statement statement = con.createStatement();
            String sql = "UPDATE `student` SET `seat_status`=0,`seat_number`=null,`route`=null,`time`=null WHERE id='"+a+"'";
            statement.execute(sql);
            data.clear();
            showintable();
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginAD.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
