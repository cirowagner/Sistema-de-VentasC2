package upeu.dao;

import upeu.conexion.Conexion;
import upeu.interfaces.DAOCategoria;
import upeu.pojo.Categoria;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCategoriaImpl extends Conexion implements DAOCategoria {
    @Override
    public List<Categoria> listar() {
        List<Categoria>lista = new ArrayList<>();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM categoria");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setNombreC(rs.getString(2));
                cat.setCodC(rs.getString(3));
                lista.add(cat);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
        return lista;
    }

    @Override
    public Categoria buscarProv(int id) {
        Categoria cat = new Categoria();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM categoria WHERE IDC = "+id+"");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                cat = new Categoria();
                cat.setIdC(rs.getInt(1));
                cat.setNombreC(rs.getString(2));
                cat.setCodC(rs.getString(3));
            }else{
                cat.setIdC(0);
            }
            pstmt.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
        return cat;
    }

    @Override
    public void registrar(Categoria cat) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("INSERT INTO categoria" +
                    "NOMBREC, CODIGOC");
            pstmt.setString(1, cat.getNombreC());
            pstmt.setString(2, cat.getCodC());
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void actualizar(Categoria cat) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("UPDATE categoria SET" +
                    "NOMBREC = ?, " +
                    "CODIGOC = ?, " +
                    " WHERE IDC = ?");
            pstmt.setString(1, cat.getNombreC());
            pstmt.setString(2, cat.getCodC());
            pstmt.setInt(3, cat.getIdC());
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void eliminar(Categoria cat) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("DELETE FROM categoria WHERE IDC = ?");
            pstmt.setInt(1, cat.getIdC());
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }
}
