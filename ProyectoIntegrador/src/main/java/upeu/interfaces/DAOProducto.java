package upeu.interfaces;

import upeu.pojo.Producto;
import java.util.List;

public interface DAOProducto {
     List<Producto> listar();
     List<Producto> buscarProd2 (String filtro);
     byte[] leerArchivo(String file);
     void registrar(Producto prod);
     void actualizar(Producto prod);
     void eliminar(Producto prod);
}
