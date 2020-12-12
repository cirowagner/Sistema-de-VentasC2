package upeu.gui.login;

import upeu.gui.admin.AdministracionPanel;
import upeu.gui.cargas.CargarVentana;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Ingresar extends JFrame implements MouseListener, ActionListener, MouseMotionListener, FocusListener, KeyListener{

    public Ingresar() {
        setUndecorated(true);
        setSize(1005, 570);
        initComponents();
        getContentPane().setLayout(null);
        try {
            this.setIconImage(ImageIO.read(new File("imagenes/logo4.png")));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponents() {
        fondoR();
        panelIn();
        utils();
    }

    ImageIcon imagen = new ImageIcon("imagenes/login/GIF2.gif"); //Creamos un objeto que porte la imagen Fondo2.0.jpg
    JLabel lbFondo = new JLabel(imagen); // Creamos un objeto JLabel y le pasamos a su constructor, el objeto imagen
    JPanelSlider panelSl = new JPanelSlider();
    JPanel panelIngresar = new JPanel();
    RegistrarCliente panelCliente = new RegistrarCliente();
    AdministracionPanel panelTrbjador = new AdministracionPanel();
    public void fondoR() {

        panelSl.setBounds(0,0,1005,570);
        panelSl.addMouseMotionListener(this);
        panelSl.setBackground(Color.CYAN);
        panelSl.setLayout(null);
        panelSl.addMouseListener(this);

        lbFondo.setBounds(0,0,1005,570);
        lbFondo.setSize(lbFondo.getWidth(), lbFondo.getHeight()); //Recuperamos la el tamaño del JFrame para darselo a jlFondo
        panelIngresar.add(lbFondo);
        panelIngresar.setOpaque(false);
        panelIngresar.setBounds(0,0,1005,570);
        panelIngresar.setLayout(null);
        lbFondo.setLayout(null);

        panelTrbjador.btnSalir.addActionListener(this);
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

    //JLabel logoUPeU = new JLabel(new ImageIcon("imagenes/logo.gif"));

    JLabel lbRegistrarCliente = new JLabel("Registrarce");
    JLabel lbAdmin = new JLabel("ADM");
    Font fuenteRs = new Font("Arial",Font.PLAIN,17);
    Color coloRs = new Color(255,255,255);

    public void utils(){
        lbRegistrarCliente.setBounds(140,370,135,25);
        lbRegistrarCliente.setForeground(coloRs);
        lbRegistrarCliente.setFont(fuenteRs);
        lbRegistrarCliente.addMouseListener(this);
        pnlIngrs.add(lbRegistrarCliente);

        lbAdmin.setBounds(305,5,40,25);
        lbAdmin.setForeground(coloRs);
        lbAdmin.setFont(fuenteRs);
        lbAdmin.addMouseListener(this);
        pnlIngrs.add(lbAdmin);

        btSalir.setBounds(10,510,45,50);
        btSalir.setIcon(new ImageIcon(icoSalir.getImage().getScaledInstance(btSalir.getWidth(), btSalir.getHeight(), Image.SCALE_SMOOTH)));
        btSalir.setOpaque(false);
        btSalir.setContentAreaFilled(false);
        btSalir.addActionListener(this);
        lbFondo.add(btSalir);

        lbRecuperarClave.setBounds(157,290,155,20);
        lbRecuperarClave.setFont(new Font("Arial",Font.PLAIN,12));
        lbRecuperarClave.setForeground(new Color(190,190,190));
        lbRecuperarClave.addMouseListener(this);
        pnlIngrs.add(lbRecuperarClave);
    }

    JLabel lbRecuperarClave = new JLabel("Olvidaste tu contraseña?");
    JFrame frameRClave = new JFrame();
    JPanel pnlRClave = new JPanel();
    JLabel lbLogoRC = new JLabel("logo");
    JLabel lbNombreRC = new JLabel("Usuario",SwingConstants.CENTER);
    JTextField tfNombreRC = new JTextField();
    JLabel lbCorreoRC = new JLabel("Correo",SwingConstants.CENTER);
    JTextField tfCoreoRC = new JTextField();
    JButton btEnviarRC = new JButton("Enviar");
    JTextField tfClaveRC = new JTextField();
    JButton btSalirRC = new JButton("Cancelar");
    JSeparator spdrRC1 = new JSeparator();
    JSeparator spdrRC2 = new JSeparator();
    public void recuperarClave(){
        frameRClave.setUndecorated(true);
        frameRClave.setSize(400,500);
        frameRClave.setVisible(true);
        frameRClave.setBackground(new Color(0,0,10,231));
        frameRClave.addMouseMotionListener(this);
        frameRClave.setLocationRelativeTo(null);
        frameRClave.setLayout(new BorderLayout());

        pnlRClave.setOpaque(false);
        pnlRClave.setLayout(null);
        frameRClave.add(pnlRClave,BorderLayout.CENTER);

        lbLogoRC.setBounds(150,20,100,100);
        lbLogoRC.setOpaque(true);
        pnlRClave.add(lbLogoRC);

        lbNombreRC.setBounds(100,150,200,30);
        lbNombreRC.setFont(fuente);
        lbNombreRC.setForeground(fuenteColor);
        pnlRClave.add(lbNombreRC);

        tfNombreRC.setBounds(100,178,200,25);
        tfNombreRC.setFont(fuenteTf);
        tfNombreRC.setForeground(fuenteColor);
        tfNombreRC.setBorder(null);
        tfNombreRC.setOpaque(false);
        tfNombreRC.setHorizontalAlignment(SwingConstants.CENTER);
        spdrRC1.setBounds(100,203,200,2);
        pnlRClave.add(spdrRC1);
        pnlRClave.add(tfNombreRC);

        lbCorreoRC.setBounds(100,225,200,30);
        lbCorreoRC.setFont(fuente);
        lbCorreoRC.setForeground(fuenteColor);
        pnlRClave.add(lbCorreoRC);

        tfCoreoRC.setBounds(100,253,200,25);
        tfCoreoRC.setFont(fuenteTf);
        tfCoreoRC.setForeground(fuenteColor);
        tfCoreoRC.setBorder(null);
        tfCoreoRC.setOpaque(false);
        tfCoreoRC.setHorizontalAlignment(SwingConstants.CENTER);
        spdrRC2.setBounds(100,278,200,2);
        pnlRClave.add(spdrRC2);
        pnlRClave.add(tfCoreoRC);

        btEnviarRC.setBounds(100,305,200,30);
        btEnviarRC.setBackground(new Color(0,0,0,190));
        btEnviarRC.addActionListener(this);
        pnlRClave.add(btEnviarRC);

        tfClaveRC.setBounds(100,350,200,60);
        tfClaveRC.setHorizontalAlignment(SwingConstants.CENTER);
        tfClaveRC.setFont(new Font("Sitka Banner",Font.BOLD,30));
        tfClaveRC.setBorder(new TitledBorder(""));
        tfClaveRC.setBackground(new Color(25, 10, 72,190));
        pnlRClave.add(tfClaveRC);

        btSalirRC.setBounds(150,445,100,25);
        btSalirRC.setBackground(new Color(0,0,0,190));
        btSalirRC.addActionListener(this);
        pnlRClave.add(btSalirRC);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btIngrs){
            new CargarVentana();
            this.setVisible(false);
        }

        if(e.getSource() == panelTrbjador.btnSalir){
            panelSl.nextPanel(5,panelIngresar,panelSl.right);
            lbRegistrarCliente.setVisible(true);
        }
        if (e.getSource() == panelCliente.btnRegresar){
            panelSl.nextPanel(5,panelIngresar,panelSl.right);
            lbRegistrarCliente.setVisible(true);
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

        if(e.getSource() == btSalirRC){
            frameRClave.dispose();
            this.setEnabled(true);
        }

        if(e.getSource() == btSalir){
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == lbRegistrarCliente){
            panelSl.nextPanel(5,panelCliente,panelSl.left);
            panelCliente.setVisible(true);
        }

        if(e.getSource() == lbAdmin){
            panelSl.nextPanel(5,panelTrbjador,panelSl.left);
            panelTrbjador.setVisible(true);
        }

        if(e.getSource() == verClave){
            if (verClave.isSelected()){
                verClave.setIcon(eye31);
            }else{
                verClave.setIcon(Uneye31);
            }
        }

        if(e.getSource() == lbRecuperarClave){
            recuperarClave();
            this.setEnabled(false);
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
        if (e.getSource() == lbRegistrarCliente){
            lbRegistrarCliente.setFont(fontEntered);
        }

        if(e.getSource() == lbAdmin){
            lbAdmin.setFont(fontEntered);
        }

        //nice :3
        if(e.getSource() == lbRecuperarClave){
            lbRecuperarClave.setFont(new Font("Arial",Font.PLAIN,13));
            Font font = lbRecuperarClave.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lbRecuperarClave.setFont(font.deriveFont(attributes));
            lbRecuperarClave.setForeground(coloRs);
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
        if(e.getSource() == lbRecuperarClave){
            lbRecuperarClave.setFont(new Font("Arial",Font.PLAIN,12));
            lbRecuperarClave.setForeground(new Color(190,190,190));
        }

        if (e.getSource() == verClave){
            if (verClave.isSelected()){
                verClave.setIcon(eye);
            }else {
                verClave.setIcon(Uneye);
            }
        }
        verClave.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        if (e.getSource() == lbRegistrarCliente){
            lbRegistrarCliente.setFont(fuenteRs);
        }
        if(e.getSource() == lbAdmin){
            lbAdmin.setFont(fuenteRs);
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
