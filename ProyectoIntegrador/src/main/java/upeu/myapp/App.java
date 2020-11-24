package upeu.myapp;

import upeu.dao.DAOPersonaImpl;
import upeu.interfaces.DAOPersona;
import upeu.pojo.Persona;

/**
 * @utores Ziro, Jhobany, Jheyson, Olger
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.print( "Hello World!" );
        System.out.println(" -> Proyecto creado correctamente");
        DAOPersona dao = new DAOPersonaImpl();
        for (Persona l : dao.listar()){
            System.out.printf("Uset: "+l.getName());
        }
    }
}
