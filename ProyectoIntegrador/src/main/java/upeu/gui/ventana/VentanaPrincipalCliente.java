package upeu.gui.ventana;

import upeu.gui.login.JPanelSlider;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class VentanaPrincipalCliente extends JFrame implements MouseMotionListener, MouseListener, ActionListener {

    public static void main(String []args){
        new VentanaPrincipalCliente();
    }

    public VentanaPrincipalCliente(){
        setSize(1050,600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        initComponents();
        try {
            this.setIconImage(ImageIO.read(new File("imagenes/logo4.png")));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        setTitle("Cool Bucket");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponents(){
        princPanel();
        opciones();
        configuracion();
        articulos();
        salir();
    }

    JPanel panelPricipal = new JPanel();
    public void princPanel (){
        panelPricipal.setBounds(0,0,1050,600);
        getContentPane().add(panelPricipal, BorderLayout.CENTER);
        panelPricipal.setLayout(null);
    }

    JPanel pnlOpciones = new JPanel(new FlowLayout());
    JButton bt2 = new JButton("2");
    public void opciones (){
        pnlOpciones.setLayout(null);
        pnlOpciones.setBounds(270,10,750,100);
        pnlOpciones.setBackground(new Color(0,0,0,200));
        pnlOpciones.add(bt2);
        panelPricipal.add(pnlOpciones);
    }

    JPanel pnlConfig = new JPanel();
    public void configuracion (){
        pnlConfig.setLayout(null);
        pnlConfig.setBounds(10,10,250,540);
        pnlConfig.setBackground(new Color(0,0,200,200));
        panelPricipal.add(pnlConfig);
    }

    JPanelSlider pnlSlArticulos = new JPanelSlider();
    JPanel pnlVista1 = new JPanel();
    JPanel pnlVista2 = new JPanel();
    JPanel pnlVista3 = new JPanel();
    JPanel pnlVista4 = new JPanel();
    JButton btVista1Left = new JButton();
    JButton btVista1Right = new JButton();
    JButton btVista2Left = new JButton();
    JButton btVista2Right = new JButton();
    JButton btVista3Left = new JButton();
    JButton btVista3Right = new JButton();
    JButton btVista4Left = new JButton();
    JButton btVista4Right = new JButton();

    ImageIcon imageLeft = new ImageIcon("imagenes/VentanaUsuario/Left.png");
    ImageIcon imageRight = new ImageIcon("imagenes/VentanaUsuario/Right.png");
    public void articulos(){
        pnlSlArticulos.setLayout(null);
        pnlSlArticulos.setBounds(270,120,750,430);
        panelPricipal.add(pnlSlArticulos);
        pnlSlArticulos.setVisible(true);

        //Panel Vista 1 con el boton left
        pnlVista1.setBounds(0,0,750,430);
        pnlVista1.setLayout(null);
        pnlVista1.setBackground(Color.black);
        pnlSlArticulos.add(pnlVista1);

        btVista1Left.setBounds(5,150,45,100);
        btVista1Left.setIcon(imageLeft);
        btVista1Left.setOpaque(false);
        btVista1Left.setContentAreaFilled(false);
        btVista1Left.setBorder(null);
        btVista1Left.addActionListener(this);
        pnlVista1.add(btVista1Left);

        btVista1Right.setBounds(700,150,45,100);
        btVista1Right.setIcon(imageRight);
        btVista1Right.setOpaque(false);
        btVista1Right.setContentAreaFilled(false);
        btVista1Right.setBorder(null);
        btVista1Right.addActionListener(this);
        pnlVista1.add(btVista1Right);

        //Panel Vista 2 con los botones rigth y left
        pnlVista2.setBounds(0,0,750,430);
        pnlVista2.setLayout(null);
        pnlVista2.setVisible(false);
        pnlVista2.setBackground(Color.YELLOW);
        pnlSlArticulos.add(pnlVista2);

        btVista2Left.setBounds(5,150,45,100);
        btVista2Left.setIcon(imageLeft);
        btVista2Left.setOpaque(false);
        btVista2Left.setContentAreaFilled(false);
        btVista2Left.setBorder(null);
        btVista2Left.addActionListener(this);
        pnlVista2.add(btVista2Left);

        btVista2Right.setBounds(700,150,45,100);
        btVista2Right.setIcon(imageRight);
        btVista2Right.setOpaque(false);
        btVista2Right.setContentAreaFilled(false);
        btVista2Right.setBorder(null);
        btVista2Right.addActionListener(this);
        pnlVista2.add(btVista2Right);

        //Panel Vista 3 con los botones rigth y left
        pnlVista3.setBounds(0,0,750,430);
        pnlVista3.setLayout(null);
        pnlVista3.setVisible(false);
        pnlVista3.setBackground(Color.CYAN);
        pnlSlArticulos.add(pnlVista3);

        btVista3Left.setBounds(5,150,45,100);
        btVista3Left.setIcon(imageLeft);
        btVista3Left.setOpaque(false);
        btVista3Left.setContentAreaFilled(false);
        btVista3Left.setBorder(null);
        btVista3Left.addActionListener(this);
        pnlVista3.add(btVista3Left);

        btVista3Right.setBounds(700,150,45,100);
        btVista3Right.setIcon(imageRight);
        btVista3Right.setOpaque(false);
        btVista3Right.setContentAreaFilled(false);
        btVista3Right.setBorder(null);
        btVista3Right.addActionListener(this);
        pnlVista3.add(btVista3Right);

        //Panel Vista 4 con el boton rigth
        pnlVista4.setBounds(0,0,750,430);
        pnlVista4.setLayout(null);
        pnlVista4.setBackground(Color.blue);
        pnlSlArticulos.add(pnlVista4);

        btVista4Left.setBounds(5,150,45,100);
        btVista4Left.setIcon(imageLeft);
        btVista4Left.setOpaque(false);
        btVista4Left.setContentAreaFilled(false);
        btVista4Left.setBorder(null);
        btVista4Left.addActionListener(this);
        pnlVista4.add(btVista4Left);

        btVista4Right.setBounds(700,150,45,100);
        btVista4Right.setIcon(imageRight);
        btVista4Right.setOpaque(false);
        btVista4Right.setContentAreaFilled(false);
        btVista4Right.setBorder(null);
        btVista4Right.addActionListener(this);
        pnlVista4.add(btVista4Right);
    }
    int opcion = 0;
    public void salir(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea cerrar el programa?", "Aviso",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                switch (opcion) {
                    case JOptionPane.YES_OPTION:
                        System.exit(0);
                        break;
                    case JOptionPane.NO_OPTION:
                        break;
                    case JOptionPane.CLOSED_OPTION:
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btVista1Left){
            pnlSlArticulos.nextPanel(5,pnlVista4,pnlSlArticulos.right);
        }
        if (e.getSource() == btVista1Right){
            pnlSlArticulos.nextPanel(5,pnlVista2,pnlSlArticulos.left);
        }

        if (e.getSource() == btVista2Left){
            pnlSlArticulos.nextPanel(5,pnlVista1,pnlSlArticulos.right);
        }
        if (e.getSource() == btVista2Right){
            pnlSlArticulos.nextPanel(5,pnlVista3,pnlSlArticulos.left);
        }

        if (e.getSource() == btVista3Left){
            pnlSlArticulos.nextPanel(5,pnlVista2,pnlSlArticulos.right);
        }
        if(e.getSource() == btVista3Right){
            pnlSlArticulos.nextPanel(5,pnlVista4,pnlSlArticulos.left);
        }

        if(e.getSource() == btVista4Left){
            pnlSlArticulos.nextPanel(5,pnlVista3,pnlSlArticulos.right);
        }

        if(e.getSource() == btVista4Right){
            pnlSlArticulos.nextPanel(5,pnlVista1,pnlSlArticulos.left);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}