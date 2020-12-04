package upeu.myapp;

import upeu.dao.DAOCategoriaImpl;
import upeu.dao.DAOPersonaImpl;
import upeu.interfaces.DAOCategoria;
import upeu.interfaces.DAOCliente;
import upeu.interfaces.DAOPersona;
import upeu.interfaces.DAOVenta;
import upeu.pojo.Categoria;

import java.util.List;

/**
 * @autores Ziro, Jhobany, Jheyson y Olger
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.print( "Hello World!" );
        System.out.println(" -> Proyecto creado correctamente");
        System.out.println("Reporte Jheyson");
        System.out.println("Reporte Jhobany");
        System.out.println("Reporte Ciro");

        Categoria cat = new Categoria();
        DAOCategoria dao = new DAOCategoriaImpl();
        List<Categoria>list = dao.listar();
        for(Categoria l : list){
            System.out.println("Name Cod: "+l.getCodC());
        }
    }
}
