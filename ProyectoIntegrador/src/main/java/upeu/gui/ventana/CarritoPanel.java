package upeu.gui.ventana;

import upeu.dao.DAODetalleVImpl;
import upeu.gui.admin.RendererTeble;
import upeu.pojo.DetalleVenta;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CarritoPanel extends JPanel implements ActionListener, MouseListener {

    public  CarritoPanel (){
        setBounds(0,0,750,430);
        setVisible(false);
        setOpaque(false);
        setLayout(null);
        initComponents();
    }

    public void initComponents(){
        vistaTablaCarrito();
        mostrarTablaCar();
        utils();
    }

    JTable tablaCar = new JTable();
    public void vistaTablaCarrito(){
        ((DefaultTableCellRenderer) tablaCar.getDefaultRenderer(Object.class)).setOpaque(false);
        tablaCar.setForeground(Color.white);
        tablaCar.getTableHeader().setOpaque(true);
        tablaCar.getTableHeader().setBackground(new Color(26, 0, 0));
        tablaCar.getTableHeader().setForeground(Color.WHITE);
        tablaCar.setBackground(new Color(0,0,0,150));
        tablaCar.addMouseListener(this);

        JScrollPane scroll = new JScrollPane(tablaCar);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBounds(10,55,729,305);
        this.add(scroll);
    }

    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DAODetalleVImpl daoDatalle = new DAODetalleVImpl();
    JButton btEditar = new JButton(new ImageIcon("imagenes/Admin/edit.png"));
    public void mostrarTablaCar (){
        tablaCar.setDefaultRenderer(Object.class, new RendererTeble());
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.addColumn("ID");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Descuento/p");
        modelo.addColumn("Precio Total");
        modelo.addColumn("ID Producto");
        modelo.addColumn("ID Venta");
        modelo.addColumn("-");
        btEditar.setContentAreaFilled(false);

        daoDatalle = new DAODetalleVImpl();
        Object[] data = new Object[9];
        for (DetalleVenta dv : daoDatalle.listar()){
            data[0] = dv.getId_DetalleV();
            data[1] = dv.getCantidad_DetalleV();
            data[2] = dv.getPrecioUnitario_DetalleV();
            data[3] = dv.getDescuento_DetalleV();
            data[4] = dv.getPrecioTotal_DetalleV();
            data[5] = dv.getId_ProductoFK();
            data[6] = dv.getId_VentaFK();
            data[7] = btEditar;
            modelo.addRow(data);
        }
        tablaCar.setModel(modelo);
        tablaCar.getColumnModel().getColumn(0).setPreferredWidth(30);
        tablaCar.getColumnModel().getColumn(7).setPreferredWidth(25);
        tablaCar.setRowHeight(30);
    }

    JLabel lbTitle = new JLabel("Carrito",SwingConstants.CENTER);
    JLabel lbNumCompra = new JLabel();
    JLabel lbCantTotal = new JLabel("Cantidad Total:");
    JLabel lbDescTotal = new JLabel("Descuento Total:");
    JLabel lbSubTotal = new JLabel("Sub Total:");
    JLabel lbIGV = new JLabel("IGV-18%");
    JLabel lbTotalTotales = new JLabel("Precio Total:");

    JTextField tfCantTotal = new JTextField();
    JTextField tfDescTotal = new JTextField();
    JTextField tfSubTotal = new JTextField();
    JTextField tfTotalTotales = new JTextField();

    JButton btComprar = new JButton("Comprar");
    Font fuenteText = new Font("Arial",Font.BOLD,14);
    Color  fuenteColor = new Color(222,222,222);

    public void utils (){
        lbTitle.setBounds(300,10,150,30);
        lbTitle.setForeground(Color.white);
        lbTitle.setFont(new Font("Arial",Font.BOLD,20));
        this.add(lbTitle);
        JSeparator spd1 = new JSeparator();
        spd1.setBounds(270,40,210,2);
        this.add(spd1);

        lbNumCompra.setBounds(625,15,120,25);
        lbNumCompra.setText("Compra N°1");
        lbNumCompra.setForeground(fuenteColor);
        lbNumCompra.setFont(fuenteText);
        this.add(lbNumCompra);

        JPanel pnlRes = new JPanel(new FlowLayout(FlowLayout.CENTER,2,3));
        pnlRes.setBounds(11,370,727,36);
        pnlRes.setBorder(new LineBorder(Color.white,2,true));
        pnlRes.setOpaque(false);
        this.add(pnlRes);

        lbCantTotal.setFont(fuenteText);
        lbCantTotal.setForeground(fuenteColor);
        pnlRes.add(lbCantTotal);
        pnlRes.add(tfCantTotal);

        JLabel spd2 = new JLabel("   ");
        pnlRes.add(spd2);

        lbDescTotal.setFont(fuenteText);
        lbDescTotal.setForeground(fuenteColor);
        pnlRes.add(lbDescTotal);
        pnlRes.add(tfDescTotal);

        JLabel spd3 = new JLabel("   ");
        pnlRes.add(spd3);

        lbSubTotal.setFont(fuenteText);
        lbSubTotal.setForeground(fuenteColor);
        pnlRes.add(lbSubTotal);
        pnlRes.add(tfSubTotal);

        JLabel spd4 = new JLabel("   ");
        pnlRes.add(spd4);

        lbIGV.setFont(fuenteText);
        lbIGV.setForeground(Color.ORANGE);
        pnlRes.add(lbIGV);

        JLabel spd5 = new JLabel("   ");
        pnlRes.add(spd5);

        lbTotalTotales.setFont(fuenteText);
        lbTotalTotales.setForeground(fuenteColor);
        pnlRes.add(lbTotalTotales);
        pnlRes.add(tfTotalTotales);

        JLabel spd6 = new JLabel("   ");
        pnlRes.add(spd6);

        btComprar.setFont(fuenteText);
        pnlRes.add(btComprar);
    }

    public void editarCompra(){
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tablaCar){
            int column = tablaCar.getColumnModel().getColumnIndexAtX(e.getX());
            int row = e.getY()/tablaCar.getRowHeight();
            if (row < tablaCar.getRowCount() && row >= 0 && column < tablaCar.getColumnCount() && column >= 0) {
                Object valor = tablaCar.getValueAt(row, column);
                if (valor instanceof JButton) {
                    ((JButton) valor).doClick();
                    btEditar = (JButton) valor;
                    System.out.println(">>> Click");
                    //int select = tablaCar.rowAtPoint(e.getPoint());
                    tablaCar.clearSelection();
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
}
