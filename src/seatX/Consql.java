package seatX;

import java.sql.*;

public class Consql {
    public Connection connection;
    public  Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/BusV","root","");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
