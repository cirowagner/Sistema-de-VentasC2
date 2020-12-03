package upeu.dao;

import upeu.conexion.Conexion;
import upeu.interfaces.DAOProducto;
import upeu.pojo.Producto;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOProductoImpl extends Conexion implements DAOProducto {
    @Override
    public List<Producto> listar() {
        List<Producto>listar = new ArrayList<>();
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
    public Producto buscarProv(int id) {
        Producto prod = new Producto();
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
    public void registrar(Producto prod) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void actualizar(Producto prod) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void eliminar(Producto prod) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }
}
