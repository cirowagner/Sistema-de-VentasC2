package upeu.dao;

import upeu.conexion.Conexion;
import upeu.interfaces.DAODetalleVenta;
import upeu.pojo.DetalleVenta;

import javax.swing.*;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAODetalleVImpl extends Conexion implements DAODetalleVenta{
    @Override
    public List<DetalleVenta> listar() {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){

            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return null;
    }

    @Override
    public DetalleVenta buscarDetalleV(int id) {
        DetalleVenta dtll = new DetalleVenta();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return dtll;
    }

    @Override
    public void registrar(DetalleVenta dtll) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }

    @Override
    public void actualizar(DetalleVenta dtll) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }

    @Override
    public void eliminar(DetalleVenta dtll) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }
}
