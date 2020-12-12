package upeu.dao;

import upeu.conexion.Conexion;
import upeu.interfaces.DAOUsuario;
import upeu.pojo.Usuario;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOUsuarioImpl extends Conexion implements DAOUsuario {
    @Override
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM" +
                    " usuario u, persona p WHERE u.ID_PersonaFK = p.ID_Persona and u.Estado_Usuario = 1");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Usuario user = new Usuario();
                user.setId_Usuario(rs.getInt(1));
                user.setNombre_Usuario(rs.getString(2));
                user.setClave_Usuario(rs.getString(3));
                user.setCorreo_Usuario(rs.getString(4));
                user.setCartera_Usuario(rs.getDouble(5));
                user.setTipo_Usuario(rs.getString(6));
                user.setEstado_Usuario(rs.getInt(7));
                user.setId_PersonaFK(rs.getInt(8));
                user.setNombres(rs.getString(9));
                user.setAp_Paterno(rs.getString(10));
                user.setAp_Materno(rs.getString(11));
                user.setFechaNacimiento(rs.getString(12));
                user.setSexo(rs.getString(13));
                user.setDocumento(rs.getString(14));
                user.setDireccion(rs.getString(15));
                user.setCelular(rs.getInt(16));
                lista.add(user);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOUsuarioImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return lista;
    }

    @Override
    public Usuario buscarUsuario(int id) {
        Usuario user = new Usuario();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM" +
                    " usuario u, persona p WHERE u.ID_PersonaFK = p.ID_Persona and  ID_Usuario = "+id+"");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                user.setId_Usuario(rs.getInt(1));
                user.setNombre_Usuario(rs.getString(2));
                user.setClave_Usuario(rs.getString(3));
                user.setCorreo_Usuario(rs.getString(4));
                user.setCartera_Usuario(rs.getDouble(5));
                user.setTipo_Usuario(rs.getString(6));
                user.setEstado_Usuario(rs.getInt(7));
                user.setId_PersonaFK(rs.getInt(8));
                user.setNombres(rs.getString(9));
                user.setAp_Paterno(rs.getString(10));
                user.setAp_Materno(rs.getString(11));
                user.setFechaNacimiento(rs.getString(12));
                user.setSexo(rs.getString(13));
                user.setDocumento(rs.getString(14));
                user.setDireccion(rs.getString(15));
                user.setCelular(rs.getInt(16));
            }else {
                user.setId_Usuario(0);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOUsuarioImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
        return user;
    }

    @Override
    public void registrar(Usuario user) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("INSERT INTO usuario" +
                    "(Nombre_Usuario, Contraseña_Usuario, Correo_Usuario, Cartera_Usuario, Tipo_Usuario, Estado_Usuario, ID_PersonaFK)" +
                    " VALUES (?,?,?)");
            pstmt.setString(1,user.getNombre_Usuario());
            pstmt.setString(2,user.getClave_Usuario());
            pstmt.setString(3,user.getCorreo_Usuario());
            pstmt.setDouble(4,user.getCartera_Usuario());
            pstmt.setString(5,user.getTipo_Usuario());
            pstmt.setInt(6,user.getEstado_Usuario());
            pstmt.setInt(7,user.getId_PersonaFK());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOUsuarioImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }

    @Override
    public void actualizar(Usuario user) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("UPDATE usuario SET " +
                    "Nombre_Usuario = ?, " +
                    "Contraseña_Usuario = ?, " +
                    "Correo_Usuario = ?, " +
                    "Cartera_Usuario = ?, " +
                    "Tipo_Usuario = ?, " +
                    "Estado_Usuario = ?, " +
                    "ID_PersonaFK = ? " +
                    "WHERE ID_Usuario = ?");
            pstmt.setString(1, user.getNombre_Usuario());
            pstmt.setString(2, user.getClave_Usuario());
            pstmt.setString(3, user.getCorreo_Usuario());
            pstmt.setDouble(4, user.getCartera_Usuario());
            pstmt.setString(5, user.getTipo_Usuario());
            pstmt.setInt(6, user.getEstado_Usuario());
            pstmt.setInt(7, user.getId_PersonaFK());
            pstmt.setInt(8, user.getId_Usuario());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOUsuarioImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }

    @Override
    public void eliminar(Usuario user) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("UPDATE usuario SET Estado_Usuario = 0 WHERE IDC = ?");
            pstmt.setInt(1, user.getId_Usuario());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error:: "+e.getMessage());
        }catch (Exception e){
            Logger.getLogger(DAOUsuarioImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            cerrarConexion(conectar());
        }
    }
}
