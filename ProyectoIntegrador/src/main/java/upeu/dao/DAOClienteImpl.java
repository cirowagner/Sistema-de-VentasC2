package upeu.dao;

import upeu.conexion.Conexion;
import upeu.interfaces.DAOCliente;
import upeu.pojo.Cliente;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOClienteImpl extends Conexion implements DAOCliente {
    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM cliente c, persona p WHERE c.IDP_F = p.IDP and c.ESTADO_Cliente = 1");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Cliente clt = new Cliente();
                clt.setIdc(rs.getInt(1));
                clt.setCodC(rs.getString(2));
                clt.setTipoC(rs.getString(3));
                clt.setIdp_F(rs.getInt(4));
                clt.setIdp(rs.getInt(5));
                clt.setNombre(rs.getString(6));
                clt.setAp_Paterno(rs.getString(7));
                clt.setAp_Materno(rs.getString(8));
                clt.setF_Nacimiento(rs.getString(9));
                clt.setSexo(rs.getString(10));
                clt.setDirection(rs.getString(11));
                clt.setTelefono(rs.getInt(12));
                clt.setCorreo(rs.getString(13));
                clt.setDni(rs.getString(14));
                lista.add(clt);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
        return lista;
    }

    @Override
    public Cliente buscarCliente(int id) {
        Cliente clt = new Cliente();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM cliente c, persona p WHERE c.IDP_F = p.IDP and  IDC = "+id+"");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                clt.setIdc(rs.getInt(1));
                clt.setCodC(rs.getString(2));
                clt.setTipoC(rs.getString(3));
                clt.setIdp_F(rs.getInt(4));
                clt.setIdp(rs.getInt(5));
                clt.setNombre(rs.getString(6));
                clt.setAp_Paterno(rs.getString(7));
                clt.setAp_Materno(rs.getString(8));
                clt.setF_Nacimiento(rs.getString(9));
                clt.setSexo(rs.getString(10));
                clt.setDirection(rs.getString(11));
                clt.setTelefono(rs.getInt(12));
                clt.setCorreo(rs.getString(13));
                clt.setDni(rs.getString(14));
            }else {
                clt.setIdc(0);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
        return clt;
    }

    @Override
    public void registrar(Cliente clt) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("INSERT INTO cliente(COD, TIPO, IDP_F) VALUES (?,?,?)");
            pstmt.setString(1,clt.getCodC());
            pstmt.setString(2,clt.getTipoC());
            pstmt.setInt(3,clt.getIdp_F());
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void actualizar(Cliente clt) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("UPDATE cliente SET"+
                   " COD = ?, " +
                   " TIPO = ?, " +
                   " IDP_F = ? " +
                   " WHERE IDC = ?");
            pstmt.setString(1, clt.getCodC());
            pstmt.setString(2, clt.getTipoC());
            pstmt.setInt(3, clt.getIdp_F());
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void eliminar(Cliente clt) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("UPDATE cliente SET ESTADO_Cliente = 0 WHERE IDC = ?");
            pstmt.setInt(1, clt.getIdc());
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }
}
