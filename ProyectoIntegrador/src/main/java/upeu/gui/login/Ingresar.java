package upeu.gui.login;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Map;

import diu.swe.habib.JPanelSlider.JPanelSlider; // Librería externa -> Controlador de Paneles deslizables

public class Ingresar extends JFrame implements MouseListener, ActionListener, MouseMotionListener, FocusListener, KeyListener{

    public Ingresar() {
        setUndecorated(true);
        setSize(1005, 570);
        initComponents();
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponents() {
        fondoR();
        panelIn();
        utils();
    }

    ImageIcon imagen = new ImageIcon("imagenes/login/GIF2.gif"); //Creamos un objeto que porte la imagen Fondo2.0.jpg
    JLabel lbFondo = new JLabel(imagen); // Creamos un objeto JLabel y le pasamos al constructor el objeto con la imagen
    JPanelSlider panelSl = new JPanelSlider();
    JPanel panelIngresar = new JPanel();
    RegistrarCliente panelCliente = new RegistrarCliente();
    RegistrarTrabajador panelTrbjador = new RegistrarTrabajador();
    public void fondoR() {

        panelSl.setBounds(0,0,1005,570);
        panelSl.addMouseMotionListener(this);
        panelSl.setBackground(Color.RED);
        panelSl.setLayout(null);
        panelSl.addMouseListener(this);

        lbFondo.setBounds(0,0,1005,570);
        lbFondo.setSize(lbFondo.getWidth(), lbFondo.getHeight()); //Recuperamos la el tamaño del JFrame para darselo a jlFondo
        panelIngresar.add(lbFondo);
        panelIngresar.setOpaque(false);
        panelIngresar.setBounds(0,0,1005,570);
        panelIngresar.setLayout(null);
        lbFondo.setLayout(null);

        panelTrbjador.btnRegresar.addActionListener(this);
        panelCliente.btnRegresar.addActionListener(this);
        panelSl.add(panelIngresar);
        panelSl.add(panelCliente);
        panelSl.add(panelTrbjador);
        add(panelSl);
    }

    JPanel pnlIngrs = new JPanel();

    JLabel lbUser = new JLabel("Usuario");
    JLabel lbClave = new JLabel("Contraseña");
    JTextField tfUser = new JTextField();
    JPasswordField tfClave = new JPasswordField();
    JButton btIngrs = new JButton("Ingresar");
    JSeparator spdr1 = new JSeparator();
    JSeparator spdr2 = new JSeparator();

    Font fuente = new Font("Sitka Banner", Font.BOLD, 20);
    Font fuenteTf = new Font("Carlito", Font.PLAIN, 15);
    Color fuenteColor = new Color(255, 255, 255);

    public void panelIn() {
        pnlIngrs.addFocusListener(this);
        pnlIngrs.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        pnlIngrs.setBounds(570, 65, 350, 440);
        pnlIngrs.setLayout(null);
        pnlIngrs.setBackground(new Color(11, 25, 39,200));
        lbFondo.add(pnlIngrs);

        ImageIcon imageUser = new ImageIcon("imagenes/login/UserWhite.png");
        JLabel iconUser = new JLabel(imageUser);
        iconUser.setBounds(130, 25, 100, 100);
        iconUser.setIcon(new ImageIcon(imageUser.getImage().getScaledInstance(iconUser.getWidth(), iconUser.getHeight(), Image.SCALE_SMOOTH)));
        pnlIngrs.add(iconUser);

        lbUser.setBounds(55, 155, 240, 24);
        lbUser.setFont(fuente);
        lbUser.setForeground(fuenteColor);
        pnlIngrs.add(lbUser);

        tfUser.setBounds(55, 180, 240, 24);
        tfUser.setOpaque(false);
        tfUser.setBorder(null);
        tfUser.setHorizontalAlignment(SwingConstants.CENTER);
        tfUser.setFont(fuenteTf);
        tfUser.setForeground(fuenteColor);
        pnlIngrs.add(tfUser);

        spdr1.setBounds(55, 204, 240, 2);
        spdr1.setBackground(Color.WHITE);
        pnlIngrs.add(spdr1);

        lbClave.setBounds(55, 236, 240, 24);
        lbClave.setFont(fuente);
        lbClave.setForeground(fuenteColor);
        pnlIngrs.add(lbClave);

        tfClave.setBounds(55, 261, 240, 24);
        pnlIngrs.add(tfClave);
        tfClave.setOpaque(false);
        tfClave.setBorder(null);
        tfClave.setHorizontalAlignment(SwingConstants.CENTER);
        tfClave.setLayout(new BorderLayout());
        verClave.setOpaque(false);
        tfClave.setEchoChar('o');
        verClave.addFocusListener(this);
        verClave.addMouseListener(this);
        verClave.addActionListener(this);
        tfClave.add(verClave, BorderLayout.EAST);
        tfClave.addFocusListener(this);
        tfClave.setFont(fuenteTf);
        tfClave.setForeground(fuenteColor);

        spdr2.setBounds(55, 285, 240, 2);
        pnlIngrs.add(spdr2);

        btIngrs.setBounds(112, 325, 135, 26);
        btIngrs.setOpaque(false);
        btIngrs.setForeground(fuenteColor);
        btIngrs.setContentAreaFilled(false);
        btIngrs.addActionListener(this);
        btIngrs.addKeyListener(this);
        btIngrs.setFocusable(true);
        pnlIngrs.add(btIngrs);
    }

    ImageIcon eye = new ImageIcon("imagenes/login/EyeChecked.png");
    ImageIcon Uneye = new ImageIcon("imagenes/login/EyeUnchecked.png");
    ImageIcon eye31 = new ImageIcon("imagenes/login/EyeChecked31.png");
    ImageIcon Uneye31 = new ImageIcon("imagenes/login/EyeUnchecked31.png");
    JCheckBox verClave = new JCheckBox(Uneye);

    ImageIcon icoSalir = new ImageIcon("imagenes/login/icoSalir.png");
    JButton btSalir = new JButton(icoSalir);
    JLabel recuperarClave = new JLabel("Olvidaste la contraseña?");
    //JLabel logoUPeU = new JLabel("");

    JLabel lbRegistrar = new JLabel("Registrarce");
    JLabel lbRgstrCliente = new JLabel("Cliente");
    JLabel lbRgstrEmpleado = new JLabel("Empleado");
    Font fuenteRs = new Font("Arial",Font.PLAIN,17);
    Color coloRs = new Color(255,255,255);

    public void utils(){
        recuperarClave.setBounds(157,290,155,20);
        recuperarClave.setFont(new Font("Arial",Font.PLAIN,12));
        recuperarClave.setForeground(new Color(190,190,190));
        recuperarClave.addMouseListener(this);
        pnlIngrs.add(recuperarClave);

        lbRegistrar.setBounds(140,370,135,25);
        lbRegistrar.setForeground(coloRs);
        lbRegistrar.setFont(fuenteRs);
        lbRegistrar.addMouseListener(this);
        pnlIngrs.add(lbRegistrar);

        lbRgstrCliente.setBounds(83,375,100,25);
        lbRgstrCliente.setVisible(false);
        lbRgstrCliente.setForeground(coloRs);
        lbRgstrCliente.setFont(fuenteRs);
        lbRgstrCliente.addMouseListener(this);
        pnlIngrs.add(lbRgstrCliente);

        lbRgstrEmpleado.setBounds(218,375,100,25);
        lbRgstrEmpleado.setVisible(false);
        lbRgstrEmpleado.setForeground(coloRs);
        lbRgstrEmpleado.setFont(fuenteRs);
        lbRgstrEmpleado.addMouseListener(this);
        pnlIngrs.add(lbRgstrEmpleado);

        btSalir.setBounds(10,510,45,50);
        btSalir.setIcon(new ImageIcon(icoSalir.getImage().getScaledInstance(btSalir.getWidth(), btSalir.getHeight(), Image.SCALE_SMOOTH)));
        btSalir.setOpaque(false);
        btSalir.setContentAreaFilled(false);
        btSalir.addActionListener(this);
        lbFondo.add(btSalir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panelTrbjador.btnRegresar){
            panelSl.nextPanel(5,panelIngresar,panelSl.right);
            lbRgstrEmpleado.setVisible(false);
            lbRgstrCliente.setVisible(false);
            lbRegistrar.setVisible(true);
        }
        if (e.getSource() == panelCliente.btnRegresar){
            panelSl.nextPanel(5,panelIngresar,panelSl.right);
            lbRgstrEmpleado.setVisible(false);
            lbRgstrCliente.setVisible(false);
            lbRegistrar.setVisible(true);
        }

        if (e.getSource() == verClave){
            if(verClave.isSelected()){
                tfClave.setEchoChar((char)0);
                verClave.setIcon(eye);
            }else {
                tfClave.setEchoChar('o');
                verClave.setIcon(Uneye);
            }
        }

        if(e.getSource() == btSalir){
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == lbRgstrCliente){
            panelSl.nextPanel(5,panelCliente,panelSl.left);
        }
        if(e.getSource() == lbRgstrEmpleado){
            panelSl.nextPanel(5,panelTrbjador,panelSl.left);
        }

        if(e.getSource() == lbRegistrar){
            lbRegistrar.setVisible(false);
            lbRgstrCliente.setVisible(true);
            lbRgstrEmpleado.setVisible(true);
        }

        if(e.getSource() == verClave){
            if (verClave.isSelected()){
                verClave.setIcon(eye31);
            }else{
                verClave.setIcon(Uneye31);
            }
        }
    }

    int xx,xy;
    @Override
    public void mouseDragged(MouseEvent e) {
        if(e.getSource() == panelSl){
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();
            this.setLocation(x - xx, y -xy);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == verClave){
            if (verClave.isSelected()){
                verClave.setIcon(eye);
            }else{
                verClave.setIcon(Uneye);
            }
        }

        if(e.getSource() == panelSl){
            xx = e.getX();
            xy = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    Font fontEntered = new Font("Arial",Font.BOLD,17);
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == lbRegistrar){
            lbRegistrar.setFont(fontEntered);
        }
        if(e.getSource() == lbRgstrCliente){
            lbRgstrCliente.setFont(fontEntered);
        }
        if(e.getSource() == lbRgstrEmpleado){
            lbRgstrEmpleado.setFont(fontEntered);
        }

        //nice :3
        if(e.getSource() == recuperarClave){
            recuperarClave.setFont(new Font("Arial",Font.PLAIN,13));
            Font font = recuperarClave.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            recuperarClave.setFont(font.deriveFont(attributes));
            recuperarClave.setForeground(coloRs);
        }

        if (e.getSource() == verClave){
            if (verClave.isSelected()){
                verClave.setIcon(eye31);
            }else{
                verClave.setIcon(Uneye31);
            }
        }
        verClave.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == recuperarClave){
            recuperarClave.setFont(new Font("Arial",Font.PLAIN,12));
            recuperarClave.setForeground(new Color(190,190,190));
        }

        if (e.getSource() == verClave){
            if (verClave.isSelected()){
                verClave.setIcon(eye);
            }else {
                verClave.setIcon(Uneye);
            }
        }
        verClave.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        if (e.getSource() == lbRegistrar){
            lbRegistrar.setFont(fuenteRs);
        }
        if(e.getSource() == lbRgstrCliente){
            lbRgstrCliente.setFont(fuenteRs);
        }
        if(e.getSource() == lbRgstrEmpleado){
            lbRgstrEmpleado.setFont(fuenteRs);
        }
    }

    @Override
    public void focusGained(FocusEvent f){
        if(f.getSource() == pnlIngrs){
            pnlIngrs.setBounds(565, 60, 360, 450);
            pnlIngrs.setBackground(new Color(11, 25, 39,215));
        }
    }

    @Override
    public void focusLost(FocusEvent f){

        if(f.getSource() == pnlIngrs){
            pnlIngrs.setBounds(570, 65, 350, 440);
            pnlIngrs.setBackground(new Color(11, 25, 39,200));
        }

        if (f.getSource() == verClave & f.getSource() == tfClave){
                verClave.setIcon(Uneye);
                tfClave.setEchoChar('o');
                verClave.setSelected(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource() == btIngrs){
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                JOptionPane.showMessageDialog(null,"EPPA¡¡¡¡");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
