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

    public AdministracionPanel() {
        setBounds(0, 0, 1005, 570);
        setVisible(false);
        setLayout(new BorderLayout());
        initComponents();
    }

    public void initComponents() {
        fondoRegstr();
        opciones();
        adminGestion();
    }

    ImageIcon fondo = new ImageIcon("imagenes/Admin/FondoR.jpg");
    JLabel lbFondoAdmin = new JLabel(fondo);

    public void fondoRegstr() {
        lbFondoAdmin.setBounds(0, 0, 1005, 570);
        lbFondoAdmin.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lbFondoAdmin.getWidth(), lbFondoAdmin.getHeight(), Image.SCALE_SMOOTH)));
        add(lbFondoAdmin);
        lbFondoAdmin.setLayout(null);
    }

    JPanel opcionesPanel = new JPanel();
    JButton btUsuarios = new JButton("Usuarios");
    JButton btVentas = new JButton("Ventas");
    JButton btProductos = new JButton("Productos");
    public JButton btnSalir = new JButton("Salir");
    public void opciones(){
        opcionesPanel.setOpaque(false);
        opcionesPanel.setBounds(10,10,985,55);
        opcionesPanel.setLayout(new FlowLayout(FlowLayout.CENTER,2,0));
        opcionesPanel.setBorder(new TitledBorder("Opciones"));

        btUsuarios.setOpaque(true);
        btUsuarios.setBackground(new Color(0,0,0));
        btUsuarios.setEnabled(false);
        btUsuarios.setFocusable(false);
        btUsuarios.addActionListener(this);
        opcionesPanel.add(btUsuarios);

        btVentas.setOpaque(true);
        btVentas.setBackground(new Color(0,0,0));
        btVentas.setFocusable(false);
        btVentas.addActionListener(this);
        opcionesPanel.add(btVentas);


        btProductos.setOpaque(true);
        btProductos.setBackground(new Color(0,0,0));
        btProductos.setFocusable(false);
        btProductos.addActionListener(this);
        opcionesPanel.add(btProductos);

        btnSalir.setOpaque(true);
        btnSalir.setBackground(new Color(0,0,0));
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(this);
        opcionesPanel.add(btnSalir);

        lbFondoAdmin.add(opcionesPanel);
    }

    JPanelSlider gestionPanelSlider = new JPanelSlider();
    ProductosPanel pnlCrearProducto = new ProductosPanel();
    UsuariosPanel pnlUsuario = new UsuariosPanel();
    VentasPanel pnlVentas = new VentasPanel();
    public void adminGestion() {
        gestionPanelSlider.setBounds(10, 80, 985, 485);
        gestionPanelSlider.setOpaque(false);
        gestionPanelSlider.setBorder(new TitledBorder("Gestion"));
        lbFondoAdmin.add(gestionPanelSlider);

        gestionPanelSlider.add(pnlUsuario);
        gestionPanelSlider.add(pnlVentas);
        gestionPanelSlider.add(pnlCrearProducto);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btUsuarios){
            gestionPanelSlider.nextPanel(5,pnlUsuario,gestionPanelSlider.right);
            btProductos.setEnabled(true);
            btVentas.setEnabled(true);
            btUsuarios.setEnabled(false);
        }
        if (e.getSource() == btVentas){
            gestionPanelSlider.nextPanel(5,pnlVentas,gestionPanelSlider.left);
            btProductos.setEnabled(true);
            btUsuarios.setEnabled(true);
            btVentas.setEnabled(false);
        }
        if (e.getSource() == btProductos){
            gestionPanelSlider.nextPanel(5,pnlCrearProducto,gestionPanelSlider.left);
            btUsuarios.setEnabled(true);
            btVentas.setEnabled(true);
            btProductos.setEnabled(false);
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
}