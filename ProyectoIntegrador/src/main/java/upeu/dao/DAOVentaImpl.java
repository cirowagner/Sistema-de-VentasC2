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
                vnt.setNumeroComprovante_Venta(rs.getInt(2));
                vnt.setFechaHora_Venta(rs.getString(3));
                vnt.setEstado_Venta(rs.getInt(4));
                vnt.setImpuesto_Venta(rs.getDouble(5));
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
                    " usuario u, persona p WHERE u.ID_PersonaFK = p.ID_Persona and u.Estado_Usuario = 1");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                vnt.setId_Venta(rs.getInt(1));
                vnt.setNumeroComprovante_Venta(rs.getInt(2));
                vnt.setFechaHora_Venta(rs.getString(3));
                vnt.setEstado_Venta(rs.getInt(4));
                vnt.setImpuesto_Venta(rs.getDouble(5));
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
            PreparedStatement pstmt = conectar().prepareStatement("");
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
            PreparedStatement pstmt = conectar().prepareStatement("");
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
            PreparedStatement pstmt = conectar().prepareStatement("");
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
