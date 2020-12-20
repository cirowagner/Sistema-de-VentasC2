package upeu.interfaces;

import upeu.pojo.Usuario;
import java.util.List;

public interface DAOUsuario {
     List<Usuario> listar(String filtro);
     Usuario validarUsuario(String name, String clave);
     Usuario recuperarClave(String name, String correo);
     Usuario validarRegistro(String name, String correo, String doc);
     void registrar(Usuario user);
     void actualizar(Usuario user);
     void eliminar(Usuario user);
}
