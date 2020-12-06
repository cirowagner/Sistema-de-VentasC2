package upeu.interfaces;

import upeu.pojo.Proveedor;
import java.util.List;

public interface DAOProveedor {
     List<Proveedor> listar();
     Proveedor buscarProv(int id);
     void registrar(Proveedor pvr);
     void actualizar(Proveedor pvr);
     void eliminar(Proveedor pvr);
}
