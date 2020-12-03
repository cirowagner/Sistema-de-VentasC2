package upeu.interfaces;

import upeu.pojo.Categoria;

import java.util.List;

public interface DAOCategoria {
    public List<Categoria> listar();
    public Categoria buscarProv(int id);
    public void registrar(Categoria cat);
    public void actualizar(Categoria cat);
    public void eliminar(Categoria cat);
}
