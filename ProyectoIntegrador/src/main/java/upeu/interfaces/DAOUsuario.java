package upeu.interfaces;

import upeu.pojo.Usuario;
import java.util.List;

public interface DAOUsuario {
     List<Usuario> listar(String filtro);
     Usuario buscarUsuario(int id);
     void registrar(Usuario user);
     void actualizar(Usuario user);
     void eliminar(Usuario user);
}
