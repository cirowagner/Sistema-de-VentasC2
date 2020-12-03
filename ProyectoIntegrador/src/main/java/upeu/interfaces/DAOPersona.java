package upeu.interfaces;

import upeu.pojo.Persona;
import java.util.List;

public interface DAOPersona{
    public List<Persona> listar();
    public void registrar(Persona p);
    public void actualizar(Persona p);
    public void eliminar(Persona p);
}