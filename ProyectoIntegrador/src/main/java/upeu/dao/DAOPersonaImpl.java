package upeu.dao;

import upeu.interfaces.DAOPersona;
import upeu.pojo.Persona;
import upeu.conexion.Conexion;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOPersonaImpl extends Conexion implements DAOPersona{
    @Override
    public List<Persona> listar() {
        List<Persona>lista = new ArrayList<>();
        try {
            PreparedStatement pstmt =conectar().prepareStatement("SELECT * FROM persona");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Persona p = new Persona();
                p.setId_Persona(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setAp_Paterno(rs.getString(3));
                p.setAp_Materno(rs.getString(4));
                p.setFechaNacimiento(rs.getString(5));
                p.setSexo(rs.getString(6));
                p.setDocumento(rs.getString(7));
                p.setCelular(rs.getInt(8));
                p.setDireccion(rs.getString(9));
                lista.add(p);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOPersonaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return lista; 
    }

    @Override
    public void registrar(Persona p) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("INSERT INTO persona(" +
                    "Nombres, ApPaterno, ApMaterno, FechaNacimeinto, Sexo, Documento, Direccion, Celular)" +
                    " VALUES(?,?,?,?,?,?,?,?)");
            pstmt.setString(1, p.getNombres());
            pstmt.setString(2, p.getAp_Paterno());
            pstmt.setString(3, p.getAp_Materno());
            pstmt.setString(4, p.getFechaNacimiento());
            pstmt.setString(5, p.getSexo());
            pstmt.setString(6, p.getDocumento());
            pstmt.setInt(7, p.getCelular());
            pstmt.setString(8, p.getDireccion());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOPersonaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }

    @Override
    public void actualizar(Persona p) {
        try {
            PreparedStatement pstmt =conectar().prepareStatement("UPDATE persona SET"+
                   " Nombres = ?, " +
                   " ApPaterno = ?, " +
                   " ApMaterno = ?, " +
                   " FechaNacimiento = ?, " +
                   " Sexo = ?, " +
                   " Documento  = ?, " +
                   " Direccion = ?, " +
                   " Celular = ? " +
                   " WHERE ID_Persona = ?");
            pstmt.setString(1, p.getNombres());
            pstmt.setString(2, p.getAp_Paterno());
            pstmt.setString(3, p.getAp_Materno());
            pstmt.setString(4, p.getFechaNacimiento());
            pstmt.setString(5, p.getSexo());
            pstmt.setString(6, p.getDocumento());
            pstmt.setString(7, p.getDireccion());
            pstmt.setInt(8, p.getCelular());
            pstmt.setInt(9, p.getId_Persona());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOPersonaImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }
}
