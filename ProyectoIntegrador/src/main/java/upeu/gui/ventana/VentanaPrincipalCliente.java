package upeu.gui.ventana;

import upeu.dao.DAOUsuarioImpl;
import upeu.gui.login.Ingresar;
import upeu.gui.login.JPanelSlider;
import upeu.interfaces.DAOUsuario;
import upeu.pojo.Usuario;

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
        setUndecorated(true);
        setSize(1030,560);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
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
        mostrarUsuario();
        opciones();
        configuracion();
        articulos();
    }

    JPanel panelPricipal = new JPanel();
    public void princPanel (){
        panelPricipal.setBounds(0,0,1050,600);
        getContentPane().add(panelPricipal, BorderLayout.CENTER);
        panelPricipal.setLayout(null);
    }

    Ingresar ingr = new Ingresar();
    public void mostrarUsuario (){
        System.out.println("Name: "+ingr.tfUser.getText());
        lbNameUser.setText(ingr.tfUser.getText());
    }

    JPanel pnlOpciones = new JPanel(new FlowLayout());
    JButton btCarrito = new JButton();
    JButton btAyuda = new JButton();
    public void opciones (){
        pnlOpciones.setBounds(270,10,750,100);
        pnlOpciones.setBackground(new Color(0,0,0,200));
        pnlOpciones.setLayout(null);
        panelPricipal.add(pnlOpciones);

        btCarrito.setBounds(15,10,125,80);
        pnlOpciones.add(btCarrito);

        btAyuda.setBounds(0,0,0,0);
        pnlOpciones.add(btAyuda);
    }


    JPanel pnlConfig = new JPanel();
    JLabel logoApp = new JLabel(new ImageIcon(""));
    JLabel lbImageUser = new JLabel(new ImageIcon(""));
    JLabel lbNameUser = new JLabel();
    JButton btCompras = new JButton();
    JButton btCartera = new JButton();
    JButton btConfigUser = new JButton();
    JButton btSalir = new JButton();
    public void configuracion (){
        pnlConfig.setLayout(null);
        pnlConfig.setBounds(10,10,250,540);
        pnlConfig.setBackground(new Color(0,0,200,200));
        panelPricipal.add(pnlConfig);

        logoApp.setBounds(8,8,120,40);
        logoApp.setOpaque(true);
        pnlConfig.add(logoApp);

        lbImageUser.setBounds(60,63,125,125);
        lbImageUser.setOpaque(true);
        pnlConfig.add(lbImageUser);

        lbNameUser.setBounds(10,200,100,25);
        lbNameUser.setOpaque(true);
        pnlConfig.add(lbNameUser);

        btCompras.setBounds(5,250,240,50);
        pnlConfig.add(btCompras);

        btCartera.setBounds(5,315,240,50);
        pnlConfig.add(btCartera);

        btConfigUser.setBounds(5,380,240,50);
        pnlConfig.add(btConfigUser);

        btSalir.setBounds(50,470,150,50);
        pnlConfig.add(btSalir);
    }

    JPanelSlider pnlSlArticulos = new JPanelSlider();
    JPanel pnlVista1 = new JPanel();
    JPanel pnlVista2 = new JPanel();
    JPanel pnlVista3 = new JPanel();
    JPanel pnlVista4 = new JPanel();
    ImageIcon imageLeft = new ImageIcon("imagenes/VentanaUsuario/Left.png");
    ImageIcon imageRight = new ImageIcon("imagenes/VentanaUsuario/Right.png");
    JButton btVista1Left = new JButton();
    JButton btVista1Right = new JButton();
    JButton btVista2Left = new JButton();
    JButton btVista2Right = new JButton();
    JButton btVista3Left = new JButton();
    JButton btVista3Right = new JButton();
    JButton btVista4Left = new JButton();
    JButton btVista4Right = new JButton();

    JButton btProd1 = new JButton();
    JButton btProd2 = new JButton();
    JButton btProd3 = new JButton();
    JButton btProd4 = new JButton();
    JButton btProd5 = new JButton();
    JButton btProd6 = new JButton();
    JButton btProd7 = new JButton();
    JButton btProd8 = new JButton();

    JButton btProd9 = new JButton();
    JButton btProd10 = new JButton();
    JButton btProd11 = new JButton();
    JButton btProd12 = new JButton();
    JButton btProd13 = new JButton();
    JButton btProd14 = new JButton();
    JButton btProd15 = new JButton();
    JButton btProd16 = new JButton();

    JButton btProd17 = new JButton();
    JButton btProd18 = new JButton();
    JButton btProd19 = new JButton();
    JButton btProd20 = new JButton();
    JButton btProd21 = new JButton();
    JButton btProd22 = new JButton();
    JButton btProd23 = new JButton();
    JButton btProd24 = new JButton();

    JButton btProd25 = new JButton();
    JButton btProd26 = new JButton();
    JButton btProd27 = new JButton();
    JButton btProd28 = new JButton();
    JButton btProd29 = new JButton();
    JButton btProd30 = new JButton();
    JButton btProd31 = new JButton();
    JButton btProd32 = new JButton();
    public void articulos(){
        pnlSlArticulos.setBounds(270,120,750,430);
        pnlSlArticulos.setBackground(new Color(30,0,0));
        panelPricipal.add(pnlSlArticulos);
        pnlSlArticulos.setVisible(true);

        //Panel Vista 1 con el boton left
        pnlVista1.setLayout(null);
        pnlVista1.setOpaque(false);
        pnlSlArticulos.add(pnlVista1);

        btProd1.setBounds(70,20,140,170);
        pnlVista1.add(btProd1);

        btProd2.setBounds(225,20,140,170);
        pnlVista1.add(btProd2);

        btProd3.setBounds(380,20,140,170);
        pnlVista1.add(btProd3);

        btProd4.setBounds(535,20,140,170);
        pnlVista1.add(btProd4);

        btProd5.setBounds(70,230,140,170);
        pnlVista1.add(btProd5);

        btProd6.setBounds(225,230,140,170);
        pnlVista1.add(btProd6);

        btProd7.setBounds(380,230,140,170);
        pnlVista1.add(btProd7);

        btProd8.setBounds(535,230,140,170);
        pnlVista1.add(btProd8);

        btVista1Left.setBounds(5,160,45,100);
        btVista1Left.setIcon(imageLeft);
        btVista1Left.setOpaque(false);
        btVista1Left.setContentAreaFilled(false);
        btVista1Left.setBorder(null);
        btVista1Left.addActionListener(this);
        pnlVista1.add(btVista1Left);

        btVista1Right.setBounds(700,160,45,100);
        btVista1Right.setIcon(imageRight);
        btVista1Right.setOpaque(false);
        btVista1Right.setContentAreaFilled(false);
        btVista1Right.setBorder(null);
        btVista1Right.addActionListener(this);
        pnlVista1.add(btVista1Right);

        //Panel Vista 2 con los botones rigth y left
        pnlVista2.setLayout(null);
        pnlVista2.setBackground(new Color(0,0,0,200));
        pnlSlArticulos.add(pnlVista2);

        btProd9.setBounds(70,20,140,170);
        pnlVista2.add(btProd9);

        btProd10.setBounds(225,20,140,170);
        pnlVista2.add(btProd10);

        btProd11.setBounds(380,20,140,170);
        pnlVista2.add(btProd11);

        btProd12.setBounds(535,20,140,170);
        pnlVista2.add(btProd12);

        btProd13.setBounds(70,230,140,170);
        pnlVista2.add(btProd13);

        btProd14.setBounds(225,230,140,170);
        pnlVista2.add(btProd14);

        btProd15.setBounds(380,230,140,170);
        pnlVista2.add(btProd15);

        btProd16.setBounds(535,230,140,170);
        pnlVista2.add(btProd16);

        btVista2Left.setBounds(5,160,45,100);
        btVista2Left.setIcon(imageLeft);
        btVista2Left.setOpaque(false);
        btVista2Left.setContentAreaFilled(false);
        btVista2Left.setBorder(null);
        btVista2Left.addActionListener(this);
        pnlVista2.add(btVista2Left);

        btVista2Right.setBounds(700,160,45,100);
        btVista2Right.setIcon(imageRight);
        btVista2Right.setOpaque(false);
        btVista2Right.setContentAreaFilled(false);
        btVista2Right.setBorder(null);
        btVista2Right.addActionListener(this);
        pnlVista2.add(btVista2Right);

        //Panel Vista 3 con los botones rigth y left
        pnlVista3.setLayout(null);
        pnlVista3.setBackground(new Color(0,0,0,200));
        pnlSlArticulos.add(pnlVista3);

        btProd17.setBounds(70,20,140,170);
        pnlVista3.add(btProd17);

        btProd18.setBounds(225,20,140,170);
        pnlVista3.add(btProd18);

        btProd19.setBounds(380,20,140,170);
        pnlVista3.add(btProd19);

        btProd20.setBounds(535,20,140,170);
        pnlVista3.add(btProd20);

        btProd21.setBounds(70,230,140,170);
        pnlVista3.add(btProd21);

        btProd22.setBounds(225,230,140,170);
        pnlVista3.add(btProd22);

        btProd23.setBounds(380,230,140,170);
        pnlVista3.add(btProd23);

        btProd24.setBounds(535,230,140,170);
        pnlVista3.add(btProd24);

        btVista3Left.setBounds(5,160,45,100);
        btVista3Left.setIcon(imageLeft);
        btVista3Left.setOpaque(false);
        btVista3Left.setContentAreaFilled(false);
        btVista3Left.setBorder(null);
        btVista3Left.addActionListener(this);
        pnlVista3.add(btVista3Left);

        btVista3Right.setBounds(700,160,45,100);
        btVista3Right.setIcon(imageRight);
        btVista3Right.setOpaque(false);
        btVista3Right.setContentAreaFilled(false);
        btVista3Right.setBorder(null);
        btVista3Right.addActionListener(this);
        pnlVista3.add(btVista3Right);

        //Panel Vista 4 con el boton rigth
        pnlVista4.setLayout(null);
        pnlVista4.setBackground(new Color(0,0,0,0));
        pnlSlArticulos.add(pnlVista4);

        btProd25.setBounds(70,20,140,170);
        pnlVista4.add(btProd25);

        btProd26.setBounds(225,20,140,170);
        pnlVista4.add(btProd26);

        btProd27.setBounds(380,20,140,170);
        pnlVista4.add(btProd27);

        btProd28.setBounds(535,20,140,170);
        pnlVista4.add(btProd28);

        btProd29.setBounds(70,230,140,170);
        pnlVista4.add(btProd29);

        btProd30.setBounds(225,230,140,170);
        pnlVista4.add(btProd30);

        btProd31.setBounds(380,230,140,170);
        pnlVista4.add(btProd31);

        btProd32.setBounds(535,230,140,170);
        pnlVista4.add(btProd32);

        btVista4Left.setBounds(5,160,45,100);
        btVista4Left.setIcon(imageLeft);
        btVista4Left.setOpaque(false);
        btVista4Left.setContentAreaFilled(false);
        btVista4Left.setBorder(null);
        btVista4Left.addActionListener(this);
        pnlVista4.add(btVista4Left);

        btVista4Right.setBounds(700,160,45,100);
        btVista4Right.setIcon(imageRight);
        btVista4Right.setOpaque(false);
        btVista4Right.setContentAreaFilled(false);
        btVista4Right.setBorder(null);
        btVista4Right.addActionListener(this);
        pnlVista4.add(btVista4Right);
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

    int xx,xy;
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this){
            xx = e.getX();
            xy = e.getY();
        }
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
        if (e.getSource() == this){
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();
            this.setLocation(x - xx, y -xy);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}