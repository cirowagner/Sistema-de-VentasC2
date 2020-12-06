package upeu.interfaces;

import upeu.pojo.Producto;
import java.util.List;

public interface DAOProducto {
     List<Producto> listar();
     Producto buscarProducto(int id);
     void registrar(Producto prod);
     void actualizar(Producto prod);
     void eliminar(Producto prod);
}
