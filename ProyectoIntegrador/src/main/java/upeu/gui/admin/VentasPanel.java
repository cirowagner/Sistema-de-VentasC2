package upeu.gui.admin;

import upeu.dao.DAODetalleVImpl;
import upeu.dao.DAOVentaImpl;
import upeu.interfaces.DAODetalleVenta;
import upeu.interfaces.DAOVenta;
import upeu.pojo.DetalleVenta;
import upeu.pojo.Venta;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class VentasPanel extends JPanel implements ActionListener, MouseListener, KeyListener {

    public VentasPanel(){
        setVisible(true);
        setBounds(7,15,972, 465);
        setBorder(new TitledBorder(""));
        setLayout(null);
        setOpaque(false);
        initComponents();
    }

    public void initComponents(){
        vistaTablaVentas();
        mostarVentas();
        utils();
    }

    JTable tablaVenta = new JTable();
    public void vistaTablaVentas(){
        ((DefaultTableCellRenderer) tablaVenta.getDefaultRenderer(Object.class)).setOpaque(false);
        tablaVenta.setForeground(Color.WHITE);
        tablaVenta.getTableHeader().setOpaque(true);
        tablaVenta.getTableHeader().setBackground(new Color(26, 0, 0));
        tablaVenta.getTableHeader().setForeground(Color.white);
        tablaVenta.setModel(modelo);
        tablaVenta.setBackground(new Color(0,0,0,150));
        tablaVenta.addMouseListener(this);

        JScrollPane scroll = new JScrollPane(tablaVenta);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBounds(4,45,967,415);
        this.add(scroll);
    }

    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DAOVenta daoV = new DAOVentaImpl();
    JButton btVer = new JButton(new ImageIcon("imagenes/Admin/eye.png"));
    public void mostarVentas(){
        tablaVenta.setDefaultRenderer(Object.class, new RendererTeble());
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        modelo.addColumn("ID");
        modelo.addColumn("Serie");
        modelo.addColumn("Fecha Venta");
        modelo.addColumn("Estado");
        modelo.addColumn("IVG");
        modelo.addColumn("Total");
        modelo.addColumn("ID Usuario");
        modelo.addColumn("ID DetalleVenta");
        modelo.addColumn("-");
        btVer.setContentAreaFilled(false);

        daoV = new DAOVentaImpl();
        Object [] data = new Object[9];
        for (Venta v : daoV.listar()){
            data [0] = v.getId_Venta();
            data [1] = v.getNumeroComprobante_Venta();
            data [2] = v.getFechaHora_Venta();
            data [3] = v.getEstado_Venta();
            data [4] = v.getIgv_Venta();
            data [5] = v.getTotalTotales_Venta();
            data [6] = v.getId_UsuarioFK();
            data [7] = v.getId_DetalleVentaFK();
            data [8] = btVer;
            modelo.addRow(data);
        }
        tablaVenta.setModel(modelo);
        tablaVenta.getColumnModel().getColumn(0).setPreferredWidth(1);
        tablaVenta.getColumnModel().getColumn(1).setPreferredWidth(15);
        tablaVenta.getColumnModel().getColumn(2).setPreferredWidth(90);
        tablaVenta.getColumnModel().getColumn(3).setPreferredWidth(15);
        tablaVenta.getColumnModel().getColumn(4).setPreferredWidth(15);
        tablaVenta.getColumnModel().getColumn(5).setPreferredWidth(15);
        tablaVenta.getColumnModel().getColumn(8).setPreferredWidth(25);
        tablaVenta.setRowHeight(25);
    }

    DAODetalleVenta daoDetalleV = new DAODetalleVImpl();
    public void mostrarDetalleVenta (){
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        modelo.addColumn("ID");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Descuento");
        modelo.addColumn("Precio Total");
        modelo.addColumn("ID Producto");
        modelo.addColumn("ID Venta");

        daoDetalleV = new DAODetalleVImpl();
        Object [] data = new Object[7];
        for (DetalleVenta dtll : daoDetalleV.listar()){
            data [0] = dtll.getId_DetalleV();
            data [1] = dtll.getCantidad_DetalleV();
            data [2] = dtll.getPrecioUnitario_DetalleV();
            data [3] = dtll.getDescuento_DetalleV();
            data [4] = dtll.getPrecioTotal_DetalleV();
            data [5] = dtll.getId_ProductoFK();
            data [6] = dtll.getId_VentaFK();
            modelo.addRow(data);
        }
        tablaVenta.setModel(modelo);
    }

    JLabel lbBuscarIco = new JLabel(new ImageIcon("imagenes/Admin/search.png"));
    JTextField tfBuscarVenta = new JTextField();
    public void utils(){
        tfBuscarVenta.setBounds(400,7,160,25);
        tfBuscarVenta.setOpaque(false);
        tfBuscarVenta.setBorder(null);
        tfBuscarVenta.setForeground(new Color(222,222,222));
        tfBuscarVenta.setLayout(new BorderLayout());
        tfBuscarVenta.add(lbBuscarIco, BorderLayout.EAST);
        tfBuscarVenta.addKeyListener(this);
        this.add(tfBuscarVenta);
        JSeparator spd1 = new JSeparator();
        spd1.setBounds(400,31,160,2);
        this.add(spd1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tablaVenta){
            int column = tablaVenta.getColumnModel().getColumnIndexAtX(e.getX());
            int row = e.getY()/tablaVenta.getRowHeight();
            if (row < tablaVenta.getRowCount() && row >= 0 && column < tablaVenta.getColumnCount() && column >= 0) {
                Object valor = tablaVenta.getValueAt(row, column);
                if (valor instanceof JButton) {
                    ((JButton) valor).doClick();
                    btVer = (JButton) valor;
                    mostrarDetalleVenta();
                }
            }
        }
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
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == tfBuscarVenta){
            daoV = new DAOVentaImpl();
            Object[]data =   new Object[9];
            modelo.setRowCount(0);
            for(Venta v : daoV.listar()) {
                modelo.addRow(data);
            }
        }
    }
}

