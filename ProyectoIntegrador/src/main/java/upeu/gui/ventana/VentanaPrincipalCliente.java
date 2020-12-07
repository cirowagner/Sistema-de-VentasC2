package upeu.gui.ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponents(){
        princPanel();
        articulos();
        opciones();
        configuracion();
    }

    JPanel panelPricipal = new JPanel();
    public void princPanel (){
        panelPricipal.setBounds(0,0,1050,600);
        panelPricipal.setBackground(new Color(0,0,0,200));
        getContentPane().add(panelPricipal, BorderLayout.CENTER);
        panelPricipal.setLayout(null);
    }

    JPanel pnl1 = new JPanel();
    JButton bt1 = new JButton("1");
    public void articulos(){
        pnl1.setLayout(null);
        pnl1.setBounds(270,120,750,500);
        pnl1.setBackground(new Color(144,0,0,200));
        pnl1.add(bt1);
        panelPricipal.add(pnl1);
    }

    //JSeparator separator = new JSeparator();
    JPanel pnl2 = new JPanel(new FlowLayout());
    JButton bt2 = new JButton("2");
    public void opciones (){
        pnl2.setLayout(null);
        pnl2.setBounds(270,10,750,100);
        pnl2.setBackground(new Color(0,0,0,200));
        pnl2.add(bt2);
        panelPricipal.add(pnl2);
    }

    JPanel pnl3 = new JPanel();
    JButton bt3 = new JButton("3");
    JButton bt4 = new JButton("3.1");
    public void configuracion (){
        pnl3.setLayout(null);
        pnl3.setBounds(10,10,250,540);
        pnl3.setBackground(new Color(0,0,200,200));
        //pnl3.add(bt3);
        //pnl3.add(bt4);
        panelPricipal.add(pnl3);
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