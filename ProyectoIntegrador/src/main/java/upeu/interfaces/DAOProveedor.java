package upeu.interfaces;

import upeu.pojo.Proveedor;
import java.util.List;

public interface DAOProveedor {
    public List<Proveedor> listar();
    public Proveedor buscarProv(int id);
    public void registrar(Proveedor pvr);
    public void actualizar(Proveedor pvr);
    public void eliminar(Proveedor pvr);
}
