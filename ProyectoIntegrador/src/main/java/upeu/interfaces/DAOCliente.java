package upeu.interfaces;

import upeu.pojo.Cliente;
import java.util.List;

public interface DAOCliente {
    public List<Cliente> listar();
    public Cliente buscarProv(int id);
    public void registrar(Cliente clt);
    public void actualizar(Cliente clt);
    public void eliminar(Cliente clt);
}
