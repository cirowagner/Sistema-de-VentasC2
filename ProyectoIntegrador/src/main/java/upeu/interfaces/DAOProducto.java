package upeu.interfaces;

import upeu.pojo.Producto;
import java.util.List;

public interface DAOProducto {
    public List<Producto> listar();
    public Producto buscarProv(int id);
    public void registrar(Producto prod);
    public void actualizar(Producto prod);
    public void eliminar(Producto prod);
}
