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
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM producto ORDER BY Estado_Producto = 1 DESC");
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
                prod.setNombre_CategoriaFK(rs.getString(8));
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
    public List<Producto> buscarProd2 (String filtro){
        List<Producto>lista = new ArrayList<>();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM " +
                    "producto WHERE (ID_Producto LIKE '"+filtro+"%' OR Nombre_Producto LIKE '"+filtro+"%')");
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
                prod.setNombre_CategoriaFK(rs.getString(8));
                lista.add(prod);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
            Logger.getLogger(DAOProductoImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return lista;
    }

    @Override
    public void registrar(Producto prod) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("INSERT INTO producto (" +
                    "Nombre_Producto, Precio_Producto, Estado_Producto, StockInicial_Producto, StockActual_Producto, Nombre_CategoriaFK)" +
                    " VALUES (?,?,?,?,?,?)");
            pstmt.setString(1,prod.getNombre_Producto());
            //pstmt.setBytes(2,prod.getImagen_Producto());
            pstmt.setDouble(2,prod.getPrecio_Producto());
            pstmt.setInt(3,prod.getEstado_Producto());
            pstmt.setInt(4,prod.getStockInicial_Producto());
            pstmt.setInt(5,prod.getStockActual_Producto());
            pstmt.setString(6,prod.getNombre_CategoriaFK());
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
            PreparedStatement pstmt = conectar().prepareStatement("UPDATE producto SET " +
                    "Nombre_Producto = ?, " +
                    "Imagen_Producto = ?, " +
                    "Precio_Producto = ?, " +
                    "Estado_Producto = ?, " +
                    "StockInicial_Producto = ?, " +
                    "StockActual_Producto = ?, " +
                    "Nombre_CategoriaFK = ? " +
                    "WHERE ID_Producto = ?");
            pstmt.setString(1,prod.getNombre_Producto());
            pstmt.setBytes(2,prod.getImagen_Producto());
            pstmt.setDouble(3,prod.getPrecio_Producto());
            pstmt.setInt(4,prod.getEstado_Producto());
            pstmt.setInt(5,prod.getStockInicial_Producto());
            pstmt.setInt(6,prod.getStockActual_Producto());
            pstmt.setString(7,prod.getNombre_CategoriaFK());
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
