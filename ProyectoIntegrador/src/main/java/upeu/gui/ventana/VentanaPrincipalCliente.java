package upeu.gui.ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipalCliente extends JFrame implements MouseMotionListener, MouseListener, ActionListener {

    public VentanaPrincipalCliente(){
        setSize(1050,600);
        setVisible(true);
        setResizable(true);
        setBackground(Color.CYAN);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponents(){
        princPanel();
    }

    public void princPanel (){
        JPanel panelPricipal = new JPanel();
       // panelPricipal.setBounds(0,0,1050,600);
        panelPricipal.setBackground(new Color(0,0,0,200));
        getContentPane().add(panelPricipal, BorderLayout.CENTER);
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}