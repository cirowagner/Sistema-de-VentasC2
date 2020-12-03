package upeu.interfaces;

import upeu.pojo.Venta;
import java.util.List;

public interface DAOVenta {
    public List<Venta> listar();
    public Venta buscarProv(int id);
    public void registrar(Venta vnt);
    public void actualizar(Venta vnt);
    public void eliminar(Venta vnt);
}
