package upeu.interfaces;

import upeu.pojo.Categoria;

import java.util.List;

public interface DAOCategoria {
     List<Categoria> listar();
     void registrar(Categoria cat);
     void actualizar(Categoria cat);
}
