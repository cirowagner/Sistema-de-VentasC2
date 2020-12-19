package upeu.interfaces;

import upeu.pojo.Producto;
import java.util.List;

public interface DAOProducto {
     List<Producto> listar();
     List<Producto> buscarProd2 (String filtro);
     void registrar(Producto prod);
     void actualizar(Producto prod);
     void eliminar(Producto prod);
}
