package upeu.dao;

import upeu.interfaces.DAOPersona;
import upeu.pojo.Persona;
import upeu.conexion.Conexion;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonaImpl extends Conexion implements DAOPersona{
    @Override
    public List<Persona> listar() {
        List<Persona>lista = new ArrayList<>();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            ResultSet rs = pstmt.executeQuery();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
        return null;
    }

    @Override
    public void registrar(Persona p) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void actualizar(Persona p) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void eliminar(Persona p) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }
}
