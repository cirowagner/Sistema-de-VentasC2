package upeu.interfaces;

import upeu.pojo.Cliente;
import java.util.List;

public interface DAOCliente {
     List<Cliente> listar();
     Cliente buscarCliente(int id);
     void registrar(Cliente clt);
     void actualizar(Cliente clt);
     void eliminar(Cliente clt);
}
