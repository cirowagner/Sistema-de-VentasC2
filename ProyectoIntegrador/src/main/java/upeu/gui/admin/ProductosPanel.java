package upeu.gui.admin;

import upeu.dao.DAOCategoriaImpl;
import upeu.dao.DAOProductoImpl;
import upeu.interfaces.DAOCategoria;
import upeu.interfaces.DAOProducto;
import upeu.pojo.Categoria;
import upeu.pojo.Producto;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

public class ProductosPanel extends JPanel implements ActionListener, MouseListener, KeyListener {
    public ProductosPanel (){
        setVisible(true);
        setBounds(7,15,972, 465);
        setLayout(null);
        setOpaque(false);
        initComponents();
    }

    public void initComponents(){
        vistaTablaProd();
        mostrarProductos();
        buscarProducto();
        modificar();
        vaciarRegistro();
    }

    JTable tablaProductos = new JTable();
    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public void vistaTablaProd(){
        ((DefaultTableCellRenderer) tablaProductos.getDefaultRenderer(Object.class)).setOpaque(false);
        tablaProductos.setForeground(Color.WHITE);
        tablaProductos.getTableHeader().setOpaque(true);
        tablaProductos.getTableHeader().setBackground(new Color(26, 0, 0));
        tablaProductos.getTableHeader().setForeground(Color.white);
        tablaProductos.setBackground(new Color(0,0,0,150));
        tablaProductos.addMouseListener(this);

        JScrollPane scroll = new JScrollPane(tablaProductos);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBounds(5,54,670,400);
        this.add(scroll);
    }

    JButton btEditProd = new JButton();
    public void mostrarProductos() {
        tablaProductos.setDefaultRenderer(Object.class, new RendererTeble());
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Estado");
        modelo.addColumn("Stock Inicial");
        modelo.addColumn("Stock Actual");
        modelo.addColumn("Categoria");
        modelo.addColumn("-");
        btEditProd.setIcon(new ImageIcon("imagenes/Admin/edit.png"));
        btEditProd.setOpaque(false);
        btEditProd.setContentAreaFilled(false);

        daoProd = new DAOProductoImpl();
        List<Producto> lista = daoProd.listar();
        Object[]data =   new Object[8];
        for(int i = 0; i<lista.size(); i++) {
            data[0] = lista.get(i).getId_Producto();
            data[1] = lista.get(i).getNombre_Producto();
            data[2] = lista.get(i).getPrecio_Producto();
            data[3] = lista.get(i).getEstado_Producto();
            data[4] = lista.get(i).getStockInicial_Producto();
            data[5] = lista.get(i).getStockActual_Producto();
            data[6] = lista.get(i).getNombre_CategoriaFK();
            data[7] = btEditProd;
            modelo.addRow(data);

        }
        tablaProductos.setModel(modelo);
        tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(30);
        tablaProductos.getColumnModel().getColumn(7).setPreferredWidth(25);
        tablaProductos.setRowHeight(25);


        DAOCategoria daoC = new DAOCategoriaImpl();
        cbxCategoria.removeAllItems();
        for (Categoria c : daoC.listar()){
            cbxCategoria.addItem(c.getNombre_Categoria());
        }
    }

    JButton btBuscarFile = new JButton("Archivo");
    JTextField tfRutaImagen = new JTextField();
    JButton btAgregar = new JButton("Agregar");
    JButton btActualizar = new JButton("Actualizar");
    JButton btEliminar = new JButton("Eliminar");

    JLabel imagenProducto = new JLabel("",SwingConstants.CENTER);
    JLabel lbNombre = new JLabel("Nombre:");
    JLabel lbPrecio = new JLabel("Precio:");
    ButtonGroup btGrup = new ButtonGroup();
    JRadioButton rbActivo = new JRadioButton("Activo");
    JRadioButton rbInactivo = new JRadioButton("Inactivo");
    JLabel lbStockInicial = new JLabel("Stock Incial:");
    JComboBox cbxCategoria = new JComboBox();

    JTextField tfNombre = new JTextField();
    JTextField tfPrecio = new JTextField();
    JTextField tfStockInicial = new JTextField();
    Color fuentoColor = new Color(222,222,222);

    public void modificar (){
        imagenProducto.setBounds(720,15,210,120);
        imagenProducto.setBorder(new TitledBorder(""));
        this.add(imagenProducto);

        btBuscarFile.setBounds(720,140,90,25);
        btBuscarFile.setBackground(new Color(0,0,0));
        btBuscarFile.setFocusable(false);
        btBuscarFile.addActionListener(this);
        this.add(btBuscarFile);

        tfRutaImagen.setBounds(810,140,120,25);
        tfRutaImagen.setOpaque(false);
        tfRutaImagen.setForeground(fuentoColor);
        this.add(tfRutaImagen);

        lbNombre.setBounds(720,180,50,25);
        lbNombre.setForeground(fuentoColor);
        this.add(lbNombre);

        tfNombre.setBounds(780,180,131,25);
        tfNombre.setOpaque(false);
        tfNombre.setBorder(null);
        tfNombre.setForeground(fuentoColor);
        this.add(tfNombre);
        JSeparator spd1 = new JSeparator();
        spd1.setBounds(720,205,210,2);
        this.add(spd1);

        lbPrecio.setBounds(720,215,40,25);
        lbPrecio.setForeground(fuentoColor);
        this.add(lbPrecio);

        tfPrecio.setBounds(775,215,136,25);
        tfPrecio.setOpaque(false);
        tfPrecio.setBorder(null);
        tfPrecio.setForeground(fuentoColor);
        this.add(tfPrecio);
        JSeparator spd2 = new JSeparator();
        spd2.setBounds(720,240,210,2);
        this.add(spd2);

        rbActivo.setBounds(737,255,90,25);
        rbActivo.setForeground(fuentoColor);
        rbActivo.setOpaque(false);
        this.add(rbActivo);

        rbInactivo.setBounds(832,255,90,25);
        rbInactivo.setForeground(fuentoColor);
        rbInactivo.setOpaque(false);
        this.add(rbInactivo);

        btGrup.add(rbActivo);
        btGrup.add(rbInactivo);

        lbStockInicial.setBounds(720,285,80,25);
        lbStockInicial.setForeground(fuentoColor);
        this.add(lbStockInicial);

        tfStockInicial.setBounds(805,285,100,25);
        tfStockInicial.setOpaque(false);
        tfStockInicial.setBorder(null);
        tfStockInicial.setForeground(fuentoColor);
        this.add(tfStockInicial);
        JSeparator spd3 = new JSeparator();
        spd3.setBounds(720,310,210,2);
        this.add(spd3);

        cbxCategoria.setBounds(760,325,130,20);
        cbxCategoria.addItem("Categorias");
        this.add(cbxCategoria);

        btAgregar.setBounds(787,390,90,25);
        btAgregar.setBackground(new Color(0,0,0));
        btAgregar.addActionListener(this);
        this.add(btAgregar);

        btActualizar.setBounds(680,390,100,25);
        btActualizar.setBackground(new Color(0,0,0));
        btActualizar.addActionListener(this);
        this.add(btActualizar);

        btEliminar.setBounds(885,390,85,25);
        btEliminar.setBackground(new Color(0,0,0));
        btEliminar.addActionListener(this);
        this.add(btEliminar);
    }

    JTextField tfBuscarProd = new JTextField();
    JButton btBuscarProd = new JButton(new ImageIcon("imagenes/Admin/search.png"));
    public void buscarProducto (){
        tfBuscarProd.setBounds(270,10,100,25);
        tfBuscarProd.setForeground(fuentoColor);
        tfBuscarProd.setOpaque(false);
        tfBuscarProd.setBorder(null);
        tfBuscarProd.addKeyListener(this);
        JSeparator spdBuscar = new JSeparator();
        spdBuscar.setBounds(270,35,100,2);
        this.add(spdBuscar);
        this.add(tfBuscarProd);
        btBuscarProd.setBounds(370,9,35,29);
        btBuscarProd.setFocusable(false);
        btBuscarProd.setBackground(new Color(0,0,100));
        this.add(btBuscarProd);
    }

    Producto prod = new Producto();
    DAOProducto daoProd = new DAOProductoImpl();
    public void mostrarImgen (){
        daoProd = new DAOProductoImpl();
        List<Producto> list = daoProd.listar();
        for (int i = 0; i < list.size(); i++) {
            prod = list.get(i);
            try {
                byte[] bi = prod.getImagen_Producto();
                BufferedImage image;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                imagenProducto.setIcon(imgi);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al enviar Imagen: " + ex.getMessage());
                imagenProducto.setText("No hay imagen");
            }
        }
    }

    public void vaciarRegistro(){
        tfNombre.setText("");
        tfPrecio.setText("");
        btGrup.clearSelection();
        cbxCategoria.setSelectedItem("Categorias");
        tfStockInicial.setText("");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btBuscarFile) {
            JFileChooser archivo = new JFileChooser();
            archivo.setDialogTitle("Abrir imagen");
            File url = new File("imagenes\\Artefactos");
            archivo.setCurrentDirectory(url);
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
            archivo.setFileFilter(filtro);
            int seleccion = archivo.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                String ruta = archivo.getSelectedFile().getAbsolutePath();
                tfRutaImagen.setText(ruta);
                ImageIcon prueba = new ImageIcon(ruta);
                imagenProducto.setIcon(prueba);
            }

        }

        if (e.getSource() == btAgregar) {
            daoProd = new DAOProductoImpl();
            String ruta = tfRutaImagen.getText();
            System.out.println("Ruta: " + ruta);
            prod.setNombre_Producto(tfNombre.getText());
            prod.setPrecio_Producto(Double.parseDouble(tfPrecio.getText()));
            if (rbActivo.isSelected()){
                prod.setEstado_Producto(1);
            }else if (rbInactivo.isSelected()){
                prod.setEstado_Producto(0);
            }
            prod.setStockInicial_Producto(Integer.parseInt(tfStockInicial.getText()));
            prod.setStockActual_Producto(Integer.parseInt(tfStockInicial.getText()));
            prod.setNombre_CategoriaFK(cbxCategoria.getSelectedItem().toString());
            /*try {
                byte[] imagen = new byte[(int) ruta.length()];
                //InputStream input = new FileInputStream(ruta);
                //input.read(imagen);
                prod.setImagen_Producto(imagen);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Enviar Imagen: " + ex.getMessage());
                prod.setImagen_Producto(null);
            }*/
            daoProd.registrar(prod);
           // mostrarImgen();
            mostrarProductos();
        }
        if (e.getSource() == btActualizar){
            daoProd = new DAOProductoImpl();
            prod.setNombre_Producto(tfNombre.getText());
            prod.setPrecio_Producto(Double.parseDouble(tfPrecio.getText()));
            if (rbActivo.isSelected()){
                prod.setEstado_Producto(1);
            }else if (rbInactivo.isSelected()){
                prod.setEstado_Producto(0);
            }
            prod.setStockInicial_Producto(Integer.parseInt(tfStockInicial.getText()));
            prod.setStockActual_Producto(Integer.parseInt(tfStockInicial.getText()));
            prod.setNombre_CategoriaFK(cbxCategoria.getSelectedItem().toString());
            daoProd.actualizar(prod);
            mostrarProductos();
            vaciarRegistro();
        }
        if (e.getSource() == btEliminar){
            daoProd = new DAOProductoImpl();
            System.out.println("ID: "+prod.getId_Producto());
            daoProd.eliminar(prod);
            mostrarProductos();
            vaciarRegistro();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tablaProductos){
            int column = tablaProductos.getColumnModel().getColumnIndexAtX(e.getX());
            int row = e.getY()/tablaProductos.getRowHeight();
            if (row < tablaProductos.getRowCount() && row >= 0 && column < tablaProductos.getColumnCount() && column >= 0){
                Object valor = tablaProductos.getValueAt(row, column);
                if (valor instanceof JButton){
                    ((JButton)valor).doClick();
                    btEditProd = (JButton)valor;
                    int select = tablaProductos.rowAtPoint(e.getPoint());
                    prod.setId_Producto(Integer.parseInt(String.valueOf(tablaProductos.getValueAt(select,0))));
                    tfNombre.setText(String.valueOf(tablaProductos.getValueAt(select,1)));
                    tfPrecio.setText(String.valueOf(tablaProductos.getValueAt(select,2)));
                    if (String.valueOf(tablaProductos.getValueAt(select,3)).equals("1")){
                        rbActivo.setSelected(true);
                    }else if (String.valueOf(tablaProductos.getValueAt(select,3)).equals("0")){
                        rbInactivo.setSelected(true);
                    }
                    tfStockInicial.setText(String.valueOf(tablaProductos.getValueAt(select,4)));
                    cbxCategoria.setSelectedItem(String.valueOf(tablaProductos.getValueAt(select,6)));
                    tablaProductos.clearSelection();
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
        if (e.getSource() == tfBuscarProd){
            daoProd = new DAOProductoImpl();
            modelo.setRowCount(0);
            List<Producto> lista = daoProd.buscarProd2(tfBuscarProd.getText());
            Object[]data =   new Object[8];
            for(int i = 0; i<lista.size(); i++) {
                data[0] = lista.get(i).getId_Producto();
                data[1] = lista.get(i).getNombre_Producto();
                data[2] = lista.get(i).getPrecio_Producto();
                data[3] = lista.get(i).getEstado_Producto();
                data[4] = lista.get(i).getStockInicial_Producto();
                data[5] = lista.get(i).getStockActual_Producto();
                data[6] = lista.get(i).getNombre_CategoriaFK();
                data[7] = btEditProd;
                modelo.addRow(data);
            }
        }
    }
}
