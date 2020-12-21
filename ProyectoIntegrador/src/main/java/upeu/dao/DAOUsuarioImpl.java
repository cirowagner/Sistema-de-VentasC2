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
    PreparedStatement pstmtL = null;
    ResultSet rsL = null;
    @Override
    public List<Usuario> listar(String filtro) {
        List<Usuario> lista = new ArrayList<>();
        try {
            if (filtro.equals("")){
                pstmtL = conectar().prepareStatement("SELECT * FROM " +
                        "usuario u, persona p WHERE u.ID_PersonaFK = p.ID_Persona");
                rsL = pstmtL.executeQuery();
            }else{
                pstmtL = conectar().prepareStatement("SELECT * FROM " +
                        "usuario u, persona p WHERE u.ID_PersonaFK = p.ID_Persona AND (u.ID_Usuario LIKE '"+filtro+"%' " +
                        "OR u.Nombre_Usuario LIKE '"+filtro+"%')");
                rsL = pstmtL.executeQuery();
            }
            while (rsL.next()){
                Usuario user = new Usuario();
                user.setId_Usuario(rsL.getInt(1));
                user.setNombre_Usuario(rsL.getString(2));
                user.setClave_Usuario(rsL.getString(3));
                user.setCorreo_Usuario(rsL.getString(4));
                user.setCartera_Usuario(rsL.getDouble(5));
                user.setTipo_Usuario(rsL.getString(6));
                user.setEstado_Usuario(rsL.getInt(7));
                user.setFechaCreacion_Usuario(rsL.getString(8));
                user.setId_PersonaFK(rsL.getInt(9));
                user.setId_Persona(rsL.getInt(10));
                user.setNombres(rsL.getString(11));
                user.setAp_Paterno(rsL.getString(12));
                user.setAp_Materno(rsL.getString(13));
                user.setFechaNacimiento(rsL.getString(14));
                user.setSexo(rsL.getString(15));
                user.setDocumento(rsL.getString(16));
                user.setDireccion(rsL.getString(17));
                user.setCelular(rsL.getInt(18));
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
    public Usuario validarUsuario(String name, String clave) {
        Usuario user = new Usuario();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT Nombre_Usuario, Contraseña_Usuario FROM usuario WHERE Nombre_Usuario = '"+name+"' AND Contraseña_Usuario = '"+clave+"'");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                user.setNombre_Usuario(rs.getString(1));
                user.setClave_Usuario(rs.getString(2));
            }else {
                user.setNombre_Usuario("F");
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
    public Usuario recuperarClave(String name, String correo){
        Usuario user = new Usuario();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT Nombre_Usuario, Correo_Usuario, Contraseña_Usuario FROM usuario WHERE Nombre_Usuario = '"+name+"' AND Correo_Usuario = '"+correo+"'");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                user.setNombre_Usuario(rs.getString(1));
                user.setCorreo_Usuario(rs.getString(2));
                user.setClave_Usuario(rs.getString(3));
            }else {
                user.setNombre_Usuario("F");
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
    public Usuario validarRegistro(String name, String correo, String doc){
        Usuario user = new Usuario();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT u.Nombre_Usuario, u.Correo_Usuario, p.Documento FROM" +
                    " usuario u, persona p Where u.Nombre_Usuario = '"+name+"' OR u.Correo_Usuario = '"+correo+"' OR p.Documento = '"+doc+"'");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                user.setNombre_Usuario(rs.getString(1));
                user.setCorreo_Usuario(rs.getString(2));
                user.setDocumento(rs.getString(3));
            }else {
                user.setNombre_Usuario("F");
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
                    "(Nombre_Usuario, Contraseña_Usuario, Correo_Usuario, Cartera_Usuario, Tipo_Usuario, Estado_Usuario, FechaCreacion_Usuario, ID_PersonaFK)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1,user.getNombre_Usuario());
            pstmt.setString(2,user.getClave_Usuario());
            pstmt.setString(3,user.getCorreo_Usuario());
            pstmt.setDouble(4,user.getCartera_Usuario());
            pstmt.setString(5,user.getTipo_Usuario());
            pstmt.setInt(6,user.getEstado_Usuario());
            pstmt.setString(7,user.getFechaCreacion_Usuario());
            pstmt.setInt(8,user.getId_PersonaFK());
            pstmt.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"(*) Datos ya registrados");
        }catch (Exception e){
            Logger.getLogger(DAOUsuarioImpl.class.getName()).log(Level.SEVERE, "1", e);
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
