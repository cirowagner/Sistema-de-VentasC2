package upeu.dao;

import upeu.conexion.Conexion;
import upeu.interfaces.DAODetalleVenta;
import upeu.pojo.DetalleVenta;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAODetalleVImpl extends Conexion implements DAODetalleVenta{

    @Override
    public List<DetalleVenta> listar() {
        List<DetalleVenta>lista = new ArrayList<>();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FORM detalleVenta");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                DetalleVenta dtll = new DetalleVenta();
                dtll.setId_DetalleV(rs.getInt(1));
                dtll.setCantidad_DetalleV(rs.getInt(2));
                dtll.setPrecioUnitario_DetalleV(rs.getDouble(3));
                dtll.setDescuento_DetalleV(rs.getDouble(4));
                dtll.setPrecioTotal_DetalleV(rs.getDouble(5));
                dtll.setId_UsuarioFK(rs.getInt(6));
                dtll.setId_ProductoFK(rs.getInt(7));
                lista.add(dtll);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return lista;
    }

    public List<DetalleVenta> listar2(int Id_Vtn) {
        List<DetalleVenta>lista = new ArrayList<>();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FORM detalleVenta WHERE ID_Venta = "+Id_Vtn+"");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                DetalleVenta dtll = new DetalleVenta();
                dtll.setId_DetalleV(rs.getInt(1));
                dtll.setCantidad_DetalleV(rs.getInt(2));
                dtll.setPrecioUnitario_DetalleV(rs.getDouble(3));
                dtll.setDescuento_DetalleV(rs.getDouble(4));
                dtll.setPrecioTotal_DetalleV(rs.getDouble(5));
                dtll.setId_UsuarioFK(rs.getInt(6));
                dtll.setId_ProductoFK(rs.getInt(7));
                dtll.setId_VentaFK(rs.getInt(8));
                lista.add(dtll);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return lista;
    }

    @Override
    public DetalleVenta buscarDetalleV(int id) {
        DetalleVenta dtll = new DetalleVenta();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FORM detalleVenta" +
                    " WHERE ID_DetalleV = "+id+"");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                dtll.setId_DetalleV(rs.getInt(1));
                dtll.setCantidad_DetalleV(rs.getInt(2));
                dtll.setPrecioUnitario_DetalleV(rs.getDouble(3));
                dtll.setDescuento_DetalleV(rs.getDouble(4));
                dtll.setPrecioTotal_DetalleV(rs.getDouble(5));
                dtll.setId_UsuarioFK(rs.getInt(6));
                dtll.setId_ProductoFK(rs.getInt(7));
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
            PreparedStatement pstmt = conectar().prepareStatement("INSERT INTO detalleVenta" +
                    " (CANTIDAD_Detalle, PrecioUnitario_Detalle, Descuento_Detalle, PrecioTotal_Detalle, ID_UsuarioFK, ID_ProductoFK, ID_VentaFK)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, dtll.getCantidad_DetalleV());
            pstmt.setDouble(2, dtll.getPrecioUnitario_DetalleV());
            pstmt.setDouble(3, dtll.getDescuento_DetalleV());
            pstmt.setDouble(4, dtll.getPrecioTotal_DetalleV());
            pstmt.setInt(5, dtll.getId_UsuarioFK());
            pstmt.setInt(6, dtll.getId_ProductoFK());
            pstmt.setInt(7,dtll.getId_VentaFK());
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
            PreparedStatement pstmt = conectar().prepareStatement("UPDATE detalleVenta SET" +
                    " CANTIDAD_Detalle = ?, " +
                    " PrecioUnitario_Detalle = ?, " +
                    " Descuento_Detalle = ?, " +
                    " PrecioTotal_Detalle = ?, " +
                    " ID_UsuarioFK = ?, " +
                    " ID_ProductoFK = ? " +
                    " WHERE ID_DetalleV = ?");
            pstmt.setInt(1, dtll.getCantidad_DetalleV());
            pstmt.setDouble(2, dtll.getPrecioUnitario_DetalleV());
            pstmt.setDouble(3, dtll.getDescuento_DetalleV());
            pstmt.setDouble(4, dtll.getPrecioTotal_DetalleV());
            pstmt.setInt(5, dtll.getId_UsuarioFK());
            pstmt.setInt(6, dtll.getId_ProductoFK());
            pstmt.setInt(7, dtll.getId_DetalleV());
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
            PreparedStatement pstmt = conectar().prepareStatement("DELETE FROM detalleVenta WHERE ID_DetalleV = ?");
            pstmt.setInt(1, dtll.getId_DetalleV());
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
