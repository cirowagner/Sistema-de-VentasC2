package upeu.dao;

import upeu.conexion.Conexion;
import upeu.interfaces.DAOCategoria;
import upeu.pojo.Categoria;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCategoriaImpl extends Conexion implements DAOCategoria {
    @Override
    public List<Categoria> listar() {
        List<Categoria>lista = new ArrayList<>();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM categoria");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId_Categoria(rs.getInt(1));
                cat.setNombre_Categoria(rs.getString(2));
                cat.setCodigo_Categoria(rs.getString(3));
                lista.add(cat);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOCategoriaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return lista;
    }

    @Override
    public Categoria buscarCategoria(int id) {
        Categoria cat = new Categoria();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM categoria WHERE ID_Categoria = "+id+"");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                cat.setId_Categoria(rs.getInt(1));
                cat.setNombre_Categoria(rs.getString(2));
                cat.setCodigo_Categoria(rs.getString(3));
            }else{
                cat.setId_Categoria(0);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOCategoriaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return cat;
    }

    @Override
    public void registrar(Categoria cat) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("INSERT INTO categoria" +
                    " (Nombre_Categoria, Codigo_Categoria) VALUES (?, ?)");
            pstmt.setString(1, cat.getNombre_Categoria());
            pstmt.setString(2, cat.getCodigo_Categoria());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOCategoriaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }

    @Override
    public void actualizar(Categoria cat) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("UPDATE categoria SET" +
                    "Nombre_Categoria = ?, " +
                    "Codigo_Categoria = ? " +
                    "WHERE ID_Categoria = ?");
            pstmt.setString(1, cat.getNombre_Categoria());
            pstmt.setString(2, cat.getCodigo_Categoria());
            pstmt.setInt(3, cat.getId_Categoria());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOCategoriaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }

    @Override
    public void eliminar(Categoria cat) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("DELETE FROM categoria WHERE ID_Categoria = ?");
            pstmt.setInt(1, cat.getId_Categoria());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOCategoriaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }
}
