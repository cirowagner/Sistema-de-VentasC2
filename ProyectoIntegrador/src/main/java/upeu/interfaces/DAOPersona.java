package upeu.interfaces;

import upeu.pojo.Persona;

import java.util.List;

public interface DAOPersona{
    public void registrar (Persona p);
    public List<Persona> listar();
}