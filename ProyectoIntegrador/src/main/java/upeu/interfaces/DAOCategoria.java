package upeu.interfaces;

import upeu.pojo.Categoria;

import java.util.List;

public interface DAOCategoria {
     List<Categoria> listar();
     Categoria buscarCategoria(int id);
     void registrar(Categoria cat);
     void actualizar(Categoria cat);
     void eliminar(Categoria cat);
}
