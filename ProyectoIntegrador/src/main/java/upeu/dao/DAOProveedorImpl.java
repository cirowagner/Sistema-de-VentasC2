package upeu.dao;

import upeu.conexion.Conexion;
import upeu.interfaces.DAOProveedor;
import upeu.pojo.Proveedor;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOProveedorImpl extends Conexion implements DAOProveedor {
    @Override
    public List<Proveedor> listar() {
        List<Proveedor>lista = new ArrayList<>();
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
    public Proveedor buscarProv(int id) {
        Proveedor pvr = new Proveedor();
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
    public void registrar(Proveedor pvr) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void actualizar(Proveedor pvr) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void eliminar(Proveedor pvr) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }
}
