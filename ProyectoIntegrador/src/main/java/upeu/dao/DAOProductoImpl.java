package upeu.dao;

import upeu.conexion.Conexion;
import upeu.interfaces.DAOProducto;
import upeu.pojo.Producto;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOProductoImpl extends Conexion implements DAOProducto {
    @Override
    public List<Producto> listar() {
        List<Producto>listar = new ArrayList<>();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM producto");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                Producto prod = new Producto();
                prod.setId_Producto(rs.getInt(1));
                prod.setNombre_Producto(rs.getString(2));
                prod.setImagen_Producto(rs.getBytes(3));
                prod.setPrecio_Producto(rs.getDouble(4));
                prod.setEstado_Producto(rs.getInt(5));
                prod.setStockInicial_Producto(rs.getInt(6));
                prod.setStockActual_Producto(rs.getInt(7));
                prod.setID_CategoriaFK(rs.getInt(8));
                listar.add(prod);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
            Logger.getLogger(DAOProductoImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return listar;
    }



    @Override
    public Producto buscarProducto(int id) {
        Producto prod = new Producto();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM" +
                    "producto p, categoria c Where p.ID_CategoriaFK = c.ID_Categoria and ID_Producto = "+id+"");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                prod.setId_Producto(rs.getInt(1));
                prod.setNombre_Producto(rs.getString(3));
                prod.setPrecio_Producto(rs.getDouble(4));
                prod.setEstado_Producto(rs.getInt(5));
                prod.setStockInicial_Producto(rs.getInt(6));
                prod.setStockActual_Producto(rs.getInt(7));
                prod.setID_CategoriaFK(rs.getInt(8));
                prod.setId_Categoria(rs.getInt(9));
                prod.setNombre_Categoria(rs.getString(10));
                prod.setCodigo_Categoria(rs.getString(11));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
            Logger.getLogger(DAOProductoImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return prod;
    }

    @Override
    public void registrar(Producto prod) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("INSERT INTO producto(" +
                    "Nombre_Producto, Imagen_Producto, Precio_Producto, Estado_Producto, StockInicial_Producto, StockActual_Producto, ID_CategoriaFK)" +
                    "VALUES (?,?,?,?,?,?,?)");
            pstmt.setString(1,prod.getNombre_Producto());
            pstmt.setBytes(2,prod.getImagen_Producto());
            pstmt.setDouble(3,prod.getPrecio_Producto());
            pstmt.setInt(4,prod.getEstado_Producto());
            pstmt.setInt(5,prod.getStockInicial_Producto());
            pstmt.setInt(6,prod.getStockActual_Producto());
            pstmt.setInt(7,prod.getID_CategoriaFK());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
            Logger.getLogger(DAOProductoImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }

    @Override
    public void actualizar(Producto prod) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("UPDATE producto SET" +
                    "Nombre_Producto = ?, " +
                    "Imagen_Producto = ?, " +
                    "Precio_Producto = ?, " +
                    "Estado_Producto = ?, " +
                    "StockInicial_Producto = ?, " +
                    "StockActual_Producto ?, " +
                    "ID_CategoriaFK = ? " +
                    "WHERE ID_Producto = ?");
            pstmt.setString(1,prod.getNombre_Producto());
            pstmt.setBytes(2,prod.getImagen_Producto());
            pstmt.setDouble(3,prod.getPrecio_Producto());
            pstmt.setInt(4,prod.getEstado_Producto());
            pstmt.setInt(5,prod.getStockInicial_Producto());
            pstmt.setInt(6,prod.getStockActual_Producto());
            pstmt.setInt(7,prod.getID_CategoriaFK());
            pstmt.setInt(8,prod.getId_Producto());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
            Logger.getLogger(DAOProductoImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }

    public void eliminar(Producto prod) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("DELETE FROM producto WHERE ID_Producto = ?");
            pstmt.setInt(1,prod.getId_Producto());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
            Logger.getLogger(DAOProductoImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }
}
