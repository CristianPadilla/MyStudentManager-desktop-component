package Modelo;

import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionBD {

    private String BD = "mystudentmanager";
    private String user = "root";
    private String password = "";
     private String timeZone = "?useTimezone=true&serverTimezone=UTC";
    private String url = "jdbc:mysql://localhost:3306/" + BD + timeZone;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql =null;
   
    public ConnectionBD () {
        //conectar al driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        //conectar a la bd
        try {
            con =   DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
}
