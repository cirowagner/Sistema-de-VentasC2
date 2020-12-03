package upeu.interfaces;

import java.util.List;
import upeu.pojo.Trabajador;

public interface DAOTrabajador {
    public List<Trabajador> listar();
    public Trabajador buscarProv(int id);
    public void registrar(Trabajador t);
    public void actualizar(Trabajador t);
    public void eliminar(Trabajador t);
}
