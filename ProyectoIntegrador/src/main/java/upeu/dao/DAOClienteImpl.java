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
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM cliente c, persona p WHERE c.IDP_F = p.IDP");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Cliente clt = new Cliente();
                clt.setIdc(rs.getInt(1));
                clt.setIdp(rs.getInt(5));
                lista.add(clt);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
        return lista;
    }

    @Override
    public Cliente buscarProv(int id) {
        Cliente clt = new Cliente();
        try {
            PreparedStatement pstmt = conectar().prepareStatement("SELECT * FROM cliente c, persona p WHERE c.IDP_F = p.IDP and  IDC = "+id+"");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                clt.setIdc(rs.getInt(1));
                clt.setIdp(rs.getInt(5));
            }else {

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
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void actualizar(Cliente clt) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("");
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }

    @Override
    public void eliminar(Cliente clt) {
        try {
            PreparedStatement pstmt = conectar().prepareStatement("DELETE FROM cliente WHERE IDC = ?");
            pstmt.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        cerrarConexion(conectar());
    }
}
