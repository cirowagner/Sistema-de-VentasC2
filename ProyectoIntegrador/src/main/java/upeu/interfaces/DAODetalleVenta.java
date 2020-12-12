package upeu.interfaces;

import upeu.pojo.DetalleVenta;
import java.util.List;

public interface DAODetalleVenta {
    List<DetalleVenta> listar();
    DetalleVenta buscarDetalleV(int id);
    void registrar(DetalleVenta dtll);
    void actualizar(DetalleVenta dtll);
    void eliminar(DetalleVenta dtll);
}
