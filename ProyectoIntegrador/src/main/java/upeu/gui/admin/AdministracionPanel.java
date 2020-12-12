package upeu.gui.admin;

import upeu.gui.login.JPanelSlider;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdministracionPanel extends JPanel implements MouseListener, ActionListener {

    public AdministracionPanel(){
        setBounds(0,0,1005,570);
        setLayout(null);
        initComponents();
        setVisible(false);
    }

    public void initComponents(){
        fondoRegstr();
        opciones();
        lista();
    }

    ImageIcon fondo = new ImageIcon("imagenes/login/RegstrTrabajador/FondoR.jpg");
    JLabel lbFondoAdmin = new JLabel(fondo);
    public void fondoRegstr (){
        lbFondoAdmin.setBounds(0,0,1005,570);
        lbFondoAdmin.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lbFondoAdmin.getWidth(), lbFondoAdmin.getHeight(), Image.SCALE_SMOOTH)));
        add(lbFondoAdmin);
        lbFondoAdmin.setLayout(null);
    }

    public JButton btnSalir = new JButton("Salir");
    JPanel opcionesPanel = new JPanel();
    public void opciones(){
        opcionesPanel.setOpaque(false);
        opcionesPanel.setBounds(10,10,985,55);
        opcionesPanel.setLayout(new FlowLayout(FlowLayout.CENTER,2,0));
        opcionesPanel.setBorder(new TitledBorder("Opciones"));

        btnSalir.setOpaque(true);
        btnSalir.setBackground(new Color(0,0,0));
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(this);
        opcionesPanel.add(btnSalir);

        lbFondoAdmin.add(opcionesPanel);
    }

    JPanelSlider gestionPanelSlider = new JPanelSlider();
    ProductosPanel pnlCrearProducto = new ProductosPanel();
    public void lista() {
        gestionPanelSlider.setLayout(new BorderLayout());
        gestionPanelSlider.setBounds(10, 80, 985, 485);
        gestionPanelSlider.setOpaque(false);
        gestionPanelSlider.setBorder(new TitledBorder("Gestion"));
        lbFondoAdmin.add(gestionPanelSlider);

        gestionPanelSlider.add(pnlCrearProducto);
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