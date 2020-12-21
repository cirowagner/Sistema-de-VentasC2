package upeu.gui.cargas;

import upeu.gui.login.Ingresar;

import javax.swing.*;
import java.awt.*;

public class CargarInicio extends JFrame implements Runnable {
    public CargarInicio (){
        setUndecorated(true);
        setSize(800,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(new Color(255,255,255,1));
        getContentPane().setLayout(null);

        JLabel fondo = new JLabel(new ImageIcon("imagenes/gif logos/3.gif"));
        fondo.setBounds(0,0,800,600);
        fondo.setLayout(null);
        add(fondo);

       /* JLabel titulo = new JLabel("",new ImageIcon("imagenes/login/Cargas/gifBar1.gif"),SwingConstants.CENTER);
        titulo.setBounds(120,440,550,150);
        titulo.setFont(new Font("Impact",Font.ITALIC,40));
        titulo.setForeground(Color.WHITE);
        fondo.add(titulo);*/

        carga = new Thread(this);
        carga.start();
    }

    private Thread carga;
    @Override
    public void run()    {
        try {
            while (carga != null) {
                Thread.sleep(8500);
                Ingresar runI = new Ingresar();
                runI.setVisible(true);
                runI.setLocationRelativeTo(null);
                break;
            }
            this.dispose();
        }catch (InterruptedException r){
            JOptionPane.showMessageDialog(null,"Error al cargar>> "+r.getMessage());
        }
    }
}
