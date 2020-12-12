package upeu.interfaces;

import upeu.pojo.Persona;
import java.util.List;

public interface DAOPersona{
     List<Persona> listar();
     void registrar(Persona p);
     void actualizar(Persona p);
}