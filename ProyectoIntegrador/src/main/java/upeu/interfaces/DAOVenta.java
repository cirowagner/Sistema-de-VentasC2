package upeu.interfaces;

import upeu.pojo.Venta;
import java.util.List;

public interface DAOVenta {
     List<Venta> listar();
     Venta buscarVenta(int id);
     void registrar(Venta vnt);
     void actualizar(Venta vnt);
     void eliminar(Venta vnt);
}
