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
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM producto p, categoria c Where p.IDC_F = c.IDC");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Producto prod = new Producto();
                prod.setID_Prod(rs.getInt(1));
                prod.setTIPO_Prod(rs.getString(3));
                prod.setPRECIO_Prod(rs.getDouble(4));
                prod.setSTOCK_Prod(rs.getString(5));
                prod.setCONTROL_Stock(rs.getString(6));
                prod.setIDC_FK(rs.getInt(7));
                prod.setIdC(rs.getInt(8));
                prod.setNombreC(rs.getString(9));
                prod.setCodC(rs.getString(10));
                listar.add(prod);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
        return listar;
    }

    @Override
    public Producto buscarProducto(int id) {
        Producto prod = new Producto();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM producto p, categoria c Where p.IDC_F = c.IDC and ID_Prod = "+id+"");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                prod.setID_Prod(rs.getInt(1));
                prod.setTIPO_Prod(rs.getString(3));
                prod.setPRECIO_Prod(rs.getDouble(4));
                prod.setSTOCK_Prod(rs.getString(5));
                prod.setCONTROL_Stock(rs.getString(6));
                prod.setIDC_FK(rs.getInt(7));
                prod.setIdC(rs.getInt(8));
                prod.setNombreC(rs.getString(9));
                prod.setCodC(rs.getString(10));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
        return prod;
    }

    @Override
    public void registrar(Producto prod) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("INSERT INTO producto(" +
                    "NOMBRE_Prod, TIPO_Prod, PRECIO_Prod, STOCK_Prod, CONTROL_Stock, IDC_FK)" +
                    "VALUES (?,?,?,?,?,?)");
            pstmt.setString(1,prod.getNOMBRE_Prod());
            pstmt.setString(2,prod.getTIPO_Prod());
            pstmt.setDouble(3,prod.getPRECIO_Prod());
            pstmt.setString(4,prod.getSTOCK_Prod());
            pstmt.setString(5,prod.getCONTROL_Stock());
            pstmt.setInt(6,prod.getIDC_FK());
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void actualizar(Producto prod) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("UPDATE producto SET" +
                    "NOMBRE_Prod = ?, " +
                    "TIPO_Prod = ?, " +
                    "PRECIO_Prod = ?, " +
                    "STOCK_Prod = ?, " +
                    "CONTROL_Stock ?, " +
                    "IDC_FK = ? " +
                    "WHERE ID_Prod = ?");
            pstmt.setString(1,prod.getNOMBRE_Prod());
            pstmt.setString(2,prod.getTIPO_Prod());
            pstmt.setDouble(3,prod.getPRECIO_Prod());
            pstmt.setString(4,prod.getSTOCK_Prod());
            pstmt.setString(5,prod.getCONTROL_Stock());
            pstmt.setInt(6,prod.getIDC_FK());
            pstmt.setInt(7,prod.getID_Prod());
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void eliminar(Producto prod) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("DELETE FROM producto WHERE ID_Prod = ?");
            pstmt.setInt(1,prod.getID_Prod());
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }
}
