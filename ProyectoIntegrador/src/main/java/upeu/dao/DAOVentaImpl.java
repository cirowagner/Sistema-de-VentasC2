package upeu.dao;

import upeu.conexion.Conexion;
import upeu.interfaces.DAOVenta;
import upeu.pojo.Venta;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOVentaImpl extends Conexion implements DAOVenta {

    @Override
    public List<Venta> listar() {
        List<Venta>lista = new ArrayList<>();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM venta");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Venta vnt = new Venta();
                vnt.setId_Venta(rs.getInt(1));
                vnt.setNumeroComprobante_Venta(rs.getInt(2));
                vnt.setFechaHora_Venta(rs.getString(3));
                vnt.setEstado_Venta(rs.getInt(4));
                vnt.setIgv_Venta(rs.getDouble(5));
                vnt.setTotalTotales_Venta(rs.getDouble(6));
                vnt.setId_UsuarioFK(rs.getInt(7));
                vnt.setId_DetalleVentaFK(rs.getInt(8));
                lista.add(vnt);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOVentaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return lista;
    }

    @Override
    public Venta buscarVenta(int id) {
        Venta vnt = new Venta();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM venta" +
                    "  WHERE ID_Venta = "+id+"");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                vnt.setId_Venta(rs.getInt(1));
                vnt.setNumeroComprobante_Venta(rs.getInt(2));
                vnt.setFechaHora_Venta(rs.getString(3));
                vnt.setEstado_Venta(rs.getInt(4));
                vnt.setIgv_Venta(rs.getDouble(5));
                vnt.setTotalTotales_Venta(rs.getDouble(6));
                vnt.setId_UsuarioFK(rs.getInt(7));
                vnt.setId_DetalleVentaFK(rs.getInt(8));
            }else {
                vnt.setId_Venta(0);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOVentaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return vnt;
    }

    @Override
    public void registrar(Venta vnt) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("INSERT INTO venta" +
                    " (NumeroComprobante_Venta, FechaHora_Venta, Estado_Venta, Impuesto_Venta, TotalTotales_Venta, ID_UsuarioFK, ID_DetalleVentaFK)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1,vnt.getNumeroComprobante_Venta());
            pstmt.setString(2,vnt.getFechaHora_Venta());
            pstmt.setInt(3,vnt.getEstado_Venta());
            pstmt.setDouble(4,vnt.getIgv_Venta());
            pstmt.setDouble(5,vnt.getTotalTotales_Venta());
            pstmt.setInt(6,vnt.getId_UsuarioFK());
            pstmt.setInt(7,vnt.getId_DetalleVentaFK());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOVentaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }

    @Override
    public void actualizar(Venta vnt) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("UPDATE venta SET " +
                    "NumeroComprobante_Venta = ?, " +
                    "FechaHora_Venta = ?, " +
                    "Estado_Venta = ?, " +
                    "Impuesto_Venta = ?, " +
                    "TotalTotales_Venta = ?, " +
                    "ID_UsuarioFK = ?, " +
                    "ID_DetalleVentaFK = ? " +
                    "WHERE ID_Venta = ?");
            pstmt.setInt(1,vnt.getNumeroComprobante_Venta());
            pstmt.setString(2,vnt.getFechaHora_Venta());
            pstmt.setInt(3,vnt.getEstado_Venta());
            pstmt.setDouble(4,vnt.getIgv_Venta());
            pstmt.setDouble(5,vnt.getTotalTotales_Venta());
            pstmt.setInt(6,vnt.getId_UsuarioFK());
            pstmt.setInt(7,vnt.getId_DetalleVentaFK());
            pstmt.setInt(8,vnt.getId_Venta());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOVentaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }

    @Override
    public void eliminar(Venta vnt) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("DELETE FROM venta WHERE ID_Venta = ?");
            pstmt.setInt(1,vnt.getId_Venta());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOVentaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }
}
