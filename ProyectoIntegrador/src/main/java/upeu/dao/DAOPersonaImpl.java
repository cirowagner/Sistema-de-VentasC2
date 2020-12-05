package upeu.dao;

import java.sql.Connection;
import upeu.interfaces.DAOPersona;
import upeu.pojo.Persona;
import upeu.conexion.Conexion;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonaImpl extends Conexion implements DAOPersona{
    @Override
    public List<Persona> listar() {
        List<Persona>lista = new ArrayList<>();
        try {
            PreparedStatement pstmt =conectar().prepareStatement("SELECT * FROM persona");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Persona p = new Persona();
                p.setNombre(rs.getString(2));
                p.setAp_Paterno(rs.getString(3));
                p.setAp_Materno(rs.getString(4));
                p.setF_Nacimiento(rs.getString(5));
                p.setSexo(rs.getString(6));
                p.setDirection(rs.getString(7));
                p.setTelefono(rs.getInt(8));
                p.setCorreo(rs.getString(9));
                p.setDni(rs.getString(10));
                lista.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
        return lista; 
    }

    @Override
    public void registrar(Persona p) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("INSERT INTO persona(NOMBRE,ApPATERNO,ApMATERNO,FECHAN,SEXO,DIRECCION,TELEFONO,CORREO,DNI) VALUES(?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, p.getNombre());
            pstmt.setString(2, p.getAp_Paterno());
            pstmt.setString(3, p.getAp_Materno());
            pstmt.setString(4, p.getF_Nacimiento());
            pstmt.setString(5, p.getSexo());
            pstmt.setString(6, p.getDirection());
            pstmt.setInt(7, p.getTelefono());
            pstmt.setString(8, p.getCorreo());
            pstmt.setString(9, p.getDni());
            pstmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        
    }

    @Override
    public void actualizar(Persona p) {
        try {
            PreparedStatement pstmt =conectar().prepareStatement("UPDATE persona SET"+
                   " NOMBRE = ?, " +
                   " ApPATERNO = ?, " +
                   " ApMATERNO = ?, " +
                   " FECHAN = ?, " +
                   " SEXO  = ? " +
                   " DIRECCION  = ? " +
                   " TELEFONO = ? " +
                   " CORREO  = ? " +
                   " DNI  = ? " +
                   " WHERE IDP = ?");
            pstmt.setString(1, p.getNombre());
            pstmt.setString(2, p.getAp_Paterno());
            pstmt.setString(3, p.getAp_Materno());
            pstmt.setString(4, p.getF_Nacimiento());
            pstmt.setString(5, p.getSexo());
            pstmt.setString(6, p.getDirection());
            pstmt.setInt(7, p.getTelefono());
            pstmt.setString(8, p.getCorreo());
            pstmt.setString(9, p.getDni());  
            pstmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        
    }

    @Override
    public void eliminar(Persona p) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("DELETE FROM persona WHERE IDP = ?");
            pstmt.setInt(1, p.getId());
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }
    
    public static void main(String[] args) {
        DAOPersonaImpl pdi = new DAOPersonaImpl();
        System.out.println(pdi.listar());
        
    }
}
