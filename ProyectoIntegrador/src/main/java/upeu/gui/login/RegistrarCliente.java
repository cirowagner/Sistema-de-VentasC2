package upeu.gui.login;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegistrarCliente extends JPanel implements MouseListener, ActionListener {

    public RegistrarCliente(){
        setBounds(0,0,1005,570);
        setLayout(null);
        initComponents();
        setVisible(false);
    }

    public void initComponents(){
        fondoRegstr();
        publicidad();
        registrarClnt();
    }

    ImageIcon fondo = new ImageIcon("imagenes/login/RegstrClient/Fondo2.0.jpg");
    JLabel lbFondoRClnt = new JLabel(fondo);
    public void fondoRegstr (){
        lbFondoRClnt.setBounds(0,0,1005,570);
        lbFondoRClnt.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lbFondoRClnt.getWidth(), lbFondoRClnt.getHeight(), Image.SCALE_SMOOTH)));
        add(lbFondoRClnt);
        lbFondoRClnt.setLayout(new GridLayout(1,2,30,0));
    }

    JButton btnRegresar = new JButton("Regresar");
    JPanel pnlPublicdid = new JPanel();
    public void publicidad (){
        pnlPublicdid.setOpaque(false);
        pnlPublicdid.setLayout(null);
        pnlPublicdid.setBorder(new TitledBorder("Publicidad"));

        btnRegresar.setBounds(50,50,80,20);
        btnRegresar.setOpaque(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(this);
        pnlPublicdid.add(btnRegresar);

        lbFondoRClnt.add(pnlPublicdid);
    }

    JPanel pnlRegstrC = new JPanel();
    public void registrarClnt (){
        pnlRegstrC.setOpaque(false);
        pnlRegstrC.setBorder(new TitledBorder("Registroooo"));
        lbFondoRClnt.add(pnlRegstrC);
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
