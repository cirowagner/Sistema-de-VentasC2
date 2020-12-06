package upeu.gui.login;

import upeu.gui.ventana.VentanaPrincipalCliente;

import javax.swing.*;

public class CargarVentana extends JFrame implements Runnable{
    public CargarVentana (){
        setUndecorated(true);
        setSize(800,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel fondo = new JLabel(new ImageIcon("imagenes/logo.gif"));
        fondo.setBounds(0,0,800,600);
        add(fondo);

        //JLabel barra = new JLabel(new ImageIcon(""));

        carga = new Thread(this);
        carga.start();
    }

    private Thread carga;
    @Override
    public void run()    {
        try {
            while (carga != null) {
                Thread.sleep(2500);
                this.dispose();
                new VentanaPrincipalCliente().repaint();
                break;
            }
        }catch (InterruptedException r){
            JOptionPane.showMessageDialog(null,"Error al cargar>> "+r.getMessage());
        }
    }
}
