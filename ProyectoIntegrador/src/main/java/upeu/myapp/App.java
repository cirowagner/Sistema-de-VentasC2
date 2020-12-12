package upeu.myapp;

import upeu.gui.cargas.CargarInicio;
import upeu.gui.login.Ingresar;

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

                    new CargarInicio();
                    /*Ingresar runI = new Ingresar();
                    runI.setVisible(true);
                    runI.setLocationRelativeTo(null);*/

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
                }
            }
        });
    }
}
