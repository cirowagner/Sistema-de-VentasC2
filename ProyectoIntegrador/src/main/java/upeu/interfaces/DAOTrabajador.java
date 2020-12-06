package upeu.interfaces;

import java.util.List;
import upeu.pojo.Trabajador;

public interface DAOTrabajador {
     List<Trabajador> listar();
     Trabajador buscarTrabajador(int id);
     void registrar(Trabajador t);
     void actualizar(Trabajador t);
     void eliminar(Trabajador t);
}
