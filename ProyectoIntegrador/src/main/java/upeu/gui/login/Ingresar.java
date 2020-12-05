package upeu.gui.login;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Ingresar extends JFrame implements MouseListener, ActionListener, MouseMotionListener, FocusListener{


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ingresar runI = new Ingresar();
                    runI.setVisible(true);
                    runI.setLocationRelativeTo(null);
                    runI.setResizable(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
                }
            }
        });
    }

    public Ingresar() {
        setUndecorated(true);
        setSize(1005, 570);
        initComponents();
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponents() {
        fondoR();
        panelR();
        utils();
    }

    ImageIcon imagen = new ImageIcon("imagenes/login/Fondo2.0.jpg");
    JLabel fondo = new JLabel(imagen);

    public void fondoR() {
        fondo.setSize(this.getWidth(), this.getHeight());
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
        add(fondo, BorderLayout.CENTER);
        fondo.setLayout(null);
        fondo.addMouseMotionListener(this);
        fondo.addMouseListener(this);
    }

    JPanel pnlRegstr = new JPanel();
    JLabel lbUser = new JLabel("Usuario");
    JLabel lbClave = new JLabel("Contraseña");
    JTextField tfUser = new JTextField();
    JPasswordField tfClave = new JPasswordField();
    JButton btIngrs = new JButton("Ingresar");
    JLabel btRegstr = new JLabel("Ingresar");
    JSeparator spdr1 = new JSeparator();
    JSeparator spdr2 = new JSeparator();

    Font fuente = new Font("Sitka Banner", Font.BOLD, 20);
    Font fuenteTf = new Font("Carlito", Font.PLAIN, 15);
    Color fuenteColor = new Color(255, 255, 255);

    public void panelR() {
        pnlRegstr.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        pnlRegstr.setBounds(570, 65, 350, 440);
        pnlRegstr.setLayout(null);
        pnlRegstr.setOpaque(false);
        fondo.add(pnlRegstr);

        ImageIcon imageUser = new ImageIcon("imagenes/login/UserWhite.png");
        JLabel iconUser = new JLabel(imageUser);
        iconUser.setBounds(130, 25, 100, 100);

        iconUser.setIcon(new ImageIcon(imageUser.getImage().getScaledInstance(iconUser.getWidth(), iconUser.getHeight(), Image.SCALE_SMOOTH)));
        pnlRegstr.add(iconUser);

        lbUser.setBounds(70, 155, 190, 24);
        lbUser.setFont(fuente);
        lbUser.setForeground(fuenteColor);
        pnlRegstr.add(lbUser);

        tfUser.setBounds(70, 180, 220, 24);
        tfUser.setOpaque(false);
        tfUser.setBorder(null);
        tfUser.setHorizontalAlignment(SwingConstants.CENTER);
        tfUser.setFont(fuenteTf);
        tfUser.setForeground(fuenteColor);
        pnlRegstr.add(tfUser);
        spdr1.setBounds(70, 204, 220, 2);
        spdr1.setBackground(Color.WHITE);
        pnlRegstr.add(spdr1);

        lbClave.setBounds(70, 236, 190, 24);
        lbClave.setFont(fuente);
        lbClave.setForeground(fuenteColor);
        pnlRegstr.add(lbClave);

        tfClave.setBounds(70, 261, 220, 24);
        pnlRegstr.add(tfClave);
        tfClave.setOpaque(false);
        tfClave.setBorder(null);
        tfClave.setHorizontalAlignment(SwingConstants.CENTER);
        tfClave.setLayout(new BorderLayout());
        box.setOpaque(false);
        box.addFocusListener(this);
        box.addMouseListener(this);
        box.addActionListener(this);
        tfClave.add(box, BorderLayout.EAST);
        tfClave.addFocusListener(this);
        tfClave.setFont(fuenteTf);
        tfClave.setForeground(fuenteColor);

        spdr2.setBounds(70, 285, 220, 2);
        pnlRegstr.add(spdr2);

        btIngrs.setBounds(112, 310, 135, 26);
        btIngrs.setOpaque(false);
        btIngrs.setForeground(fuenteColor);
        btIngrs.setContentAreaFilled(false);
        btIngrs.addActionListener(this);
        btIngrs.setMnemonic('w'); // <--- Alt + w
        pnlRegstr.add(btIngrs);
    }

    ImageIcon eye = new ImageIcon("imagenes/login/EyeChecked.png");
    ImageIcon Uneye = new ImageIcon("imagenes/login/EyeUnchecked.png");
    ImageIcon eye31 = new ImageIcon("imagenes/login/EyeChecked31.png");
    ImageIcon Uneye31 = new ImageIcon("imagenes/login/EyeUnchecked31.png");
    JCheckBox box = new JCheckBox(Uneye);

    ImageIcon icoSalir = new ImageIcon("imagenes/login/icoSalir.png");
    JButton btSalir = new JButton(icoSalir);
    JLabel mensage = new JLabel("");
    JLabel logoUPeU = new JLabel("");

    public void utils(){
        btSalir.setBounds(10,510,45,50);
        btSalir.setIcon(new ImageIcon(icoSalir.getImage().getScaledInstance(btSalir.getWidth(), btSalir.getHeight(), Image.SCALE_SMOOTH)));
        btSalir.setOpaque(false);
        btSalir.setContentAreaFilled(false);
        btSalir.addActionListener(this);
        fondo.add(btSalir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btIngrs){
            JOptionPane.showMessageDialog(null,"EPAAAA¡¡¡¡¡¡¡");
        }
        if (e.getSource() == box){
            if(box.isSelected()){
                tfClave.setEchoChar((char)0);
                box.setIcon(eye);
            }else {
                tfClave.setEchoChar('*');
                box.setIcon(Uneye);
            }
        }
        if(e.getSource() == btSalir){
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    int xx,xy;
    @Override
    public void mouseDragged(MouseEvent e) {
        if(e.getSource() == fondo){
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
        if(e.getSource() == fondo){
            xx = e.getX();
            xy = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == box){
            if (box.isSelected()){
                box.setIcon(eye31);
            }else {
                box.setIcon(Uneye31);
            }
        }
        box.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == box){
            if (box.isSelected()){
                box.setIcon(eye);
            }else {
                box.setIcon(Uneye);
            }
        }
        box.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void focusGained(FocusEvent f){
    }

    @Override
    public void focusLost(FocusEvent f){
        if (f.getSource() == tfClave){
            tfClave.setEchoChar('*');
            box.setIcon(Uneye);
        }
    }

}
