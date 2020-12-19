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
                cat.setNombre_Categoria(rs.getString(1));
                cat.setCodigo_Categoria(rs.getString(2));
                cat.setEstado_Categoria(rs.getInt(3));
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
    public void registrar(Categoria cat) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("INSERT INTO categoria" +
                    " (Nombre_Categoria, Codigo_Categoria, Estado_Categoria) VALUES (?, ?, ?)");
            pstmt.setString(1, cat.getNombre_Categoria());
            pstmt.setString(2, cat.getCodigo_Categoria());
            pstmt.setInt(3, cat.getEstado_Categoria());
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
                    "Codigo_Categoria = ?, " +
                    "Estado_Categoria = ? " +
                    "WHERE Nombre_Categoria = ?");
            pstmt.setString(1, cat.getCodigo_Categoria());
            pstmt.setInt(2, cat.getEstado_Categoria());
            pstmt.setString(3, cat.getNombre_Categoria());
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
