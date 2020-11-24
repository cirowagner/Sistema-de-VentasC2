package upeu.dao;

import upeu.interfaces.DAOPersona;
import upeu.pojo.Persona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonaImpl extends Conexion implements DAOPersona {
    @Override
    public void registrar(Persona p) {
        try {
            PreparedStatement pstmt = connect().prepareStatement("INSERT INTO persona(NAME) Values (?)");
            pstmt.setString(1,p.getName());
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    @Override
    public List<Persona> listar() {
        List<Persona>list = new ArrayList<>();;
        try {
            PreparedStatement pstmt = connect().prepareStatement("Select * from persona");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                list.add(p);
            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return list;
    }
}
