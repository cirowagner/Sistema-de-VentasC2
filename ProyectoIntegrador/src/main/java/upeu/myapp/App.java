package upeu.myapp;

import upeu.dao.DAOCategoriaImpl;
import upeu.gui.login.Ingresar;
import upeu.interfaces.DAOCategoria;
import upeu.pojo.Categoria;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ziro, Jhobany, Jheyson y Olger
 *
 */
public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    System.out.print( "Hello World!" );
                    System.out.println(" -> Proyecto creado correctamente");
                    System.out.println("Reporte Jheyson");
                    System.out.println("Reporte Jhobany");
                    System.out.println("Reporte Ciro");

                    Ingresar runI = new Ingresar();
                    runI.setVisible(true);
                    runI.setLocationRelativeTo(null);
                    runI.setResizable(true);

                    /*DAOCategoria dao = new DAOCategoriaImpl();
                    for(Categoria l : dao.listar()){
                        System.out.println("Nombre C: "+l.getNombreC());
                    }*/
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
                }
            }
        });
    }
}
