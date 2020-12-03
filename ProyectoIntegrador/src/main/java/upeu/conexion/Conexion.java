package upeu.conexion;

import javax.swing.*;
import java.sql.*;

public class Conexion {
    Connection conn = null;
    public Connection conectar(){
        try{
            Class.forName("org.sqlite.JDBC");
            if(conn == null){
                conn = DriverManager.getConnection("jdbc:sqlite:DB\\DataBases.db");
                conn.createStatement().executeQuery("PRAGMA foreign_keys = ON;");
                System.out.println("|> Conexion exitosa...100%");
            }
        }catch (SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        return conn;
    }

    public void cerrarConexion(Connection conn){
        try {
            if (conn != null) {
                conn.close();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
    }
}
