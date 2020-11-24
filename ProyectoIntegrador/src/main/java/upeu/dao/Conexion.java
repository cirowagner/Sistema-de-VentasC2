package upeu.dao;

import javax.swing.*;
import java.sql.*;

public class Conexion {
    public Connection connect(){
        Connection conn = null;
        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:D:\\ZIROJAVA-SegundoCiclo\\PROYECTO_INTEGRADOR\\ProyectoIntegrador\\DB";
            if(conn == null){
                conn = DriverManager.getConnection(url);
                System.out.println("|> La conexion se realizo correctamente...100%");
            }
        }catch (SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        return conn;
    }
}
