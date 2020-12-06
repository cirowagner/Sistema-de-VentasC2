package upeu.gui.login;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegistrarTrabajador extends JPanel implements MouseListener, ActionListener {

    public RegistrarTrabajador(){
        setBounds(0,0,1005,570);
        setBackground(Color.CYAN);
        setLayout(null);
        initComponents();
    }

    public void initComponents(){
        fondoRegstr();
        publicidad();
        registrarTrbjador();
    }

    ImageIcon fondo = new ImageIcon("imagenes/login/RegstrTrabajador/FondoR.jpg");
    JLabel lbFondoRTrbj = new JLabel(fondo);
    public void fondoRegstr (){
        lbFondoRTrbj.setBounds(0,0,1005,570);
        lbFondoRTrbj.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lbFondoRTrbj.getWidth(), lbFondoRTrbj.getHeight(), Image.SCALE_SMOOTH)));
        add(lbFondoRTrbj);
        lbFondoRTrbj.setLayout(new GridLayout(1,2,30,0));
    }

    JButton btnRegresar = new JButton("Regresar");
    JPanel pnlPublicid = new JPanel();
    public void publicidad (){
        pnlPublicid.setOpaque(false);
        pnlPublicid.setLayout(null);
        pnlPublicid.setBorder(new TitledBorder("Publicidaaaaaaaaad"));

        btnRegresar.setBounds(50,50,80,20);
        btnRegresar.setOpaque(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(this);
        pnlPublicid.add(btnRegresar);

        lbFondoRTrbj.add(pnlPublicid);
    }

    JPanel pnlRegstrT = new JPanel();
    public void registrarTrbjador (){
        pnlRegstrT.setOpaque(false);
        pnlRegstrT.setBorder(new TitledBorder("Registroooo"));
        lbFondoRTrbj.add(pnlRegstrT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
}
