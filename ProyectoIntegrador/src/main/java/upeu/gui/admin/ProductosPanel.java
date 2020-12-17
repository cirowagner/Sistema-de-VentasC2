package upeu.gui.admin;

import upeu.dao.DAOProductoImpl;
import upeu.interfaces.DAOProducto;
import upeu.pojo.Producto;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

public class ProductosPanel extends JPanel implements ActionListener {
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
    }

    JTable tablaProductos = new JTable();
    DefaultTableModel modelo = new DefaultTableModel(new Object[][]{},new String[]{});
    public void vistaTablaProd(){
        ((DefaultTableCellRenderer) tablaProductos.getDefaultRenderer(Object.class)).setOpaque(false);
        tablaProductos.setForeground(Color.WHITE);
        tablaProductos.getTableHeader().setOpaque(true);
        tablaProductos.getTableHeader().setBackground(new Color(26, 0, 0));
        tablaProductos.getTableHeader().setForeground(Color.white);
        tablaProductos.setModel(modelo);
        tablaProductos.setBackground(new Color(0,0,0,150));

        JScrollPane scroll = new JScrollPane(tablaProductos);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBounds(5,54,670,400);
        this.add(scroll);
    }

    public void mostrarProductos(){
        List<Producto> lista = dao.listar();
        Object[][]data =   new Object[lista.size()][7];
        for(int i = 0; i<lista.size(); i++) {
            data[i][0] = lista.get(i).getId_Producto();
            data[i][1] = lista.get(i).getNombre_Producto();
            data[i][2] = lista.get(i).getPrecio_Producto();
            data[i][3] = lista.get(i).getEstado_Producto();
            data[i][4] = lista.get(i).getStockInicial_Producto();
            data[i][5] = lista.get(i).getStockActual_Producto();
            data[i][6] = lista.get(i).getID_CategoriaFK();
            System.out.println("Datos: "+data[i][1]);
        }
        tablaProductos.setModel(new DefaultTableModel(data,new String[]{"ID", "Nombre", "Precio", "Estado", "Stock Inicial", "Stock Actual", "ID Categoria","x"}));
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
    JLabel lbStockActual = new JLabel("Stock Incial:");
    JComboBox cbxCategoria = new JComboBox();

    JTextField tfNombre = new JTextField();
    JTextField tfPrecio = new JTextField();
    JTextField tfStockActual = new JTextField();
    Color fuentoColor = new Color(222,222,222);

    public void modificar (){
        imagenProducto.setBounds(720,15,210,120);
        imagenProducto.setOpaque(false);
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

        lbStockActual.setBounds(720,285,80,25);
        lbStockActual.setForeground(fuentoColor);
        this.add(lbStockActual);

        tfStockActual.setBounds(805,285,100,25);
        tfStockActual.setOpaque(false);
        tfStockActual.setBorder(null);
        tfStockActual.setForeground(fuentoColor);
        this.add(tfStockActual);
        JSeparator spd3 = new JSeparator();
        spd3.setBounds(720,310,210,2);
        this.add(spd3);

        cbxCategoria.setBounds(760,325,120,20);
        cbxCategoria.addItem("Categoria");
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
    DAOProducto dao = new DAOProductoImpl();
    public void mostrarImgen (){
        List<Producto> list = dao.listar();
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


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btBuscarFile) {
            JFileChooser archivo = new JFileChooser();
            archivo.setDialogTitle("Abrir imagen");
            File url = new File("imagenes\\login");
            archivo.setCurrentDirectory(url);
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
            archivo.setFileFilter(filtro);
            int seleccion = archivo.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                String ruta = archivo.getSelectedFile().getAbsolutePath();
                tfRutaImagen.setText(ruta);
                ImageIcon prueba = new ImageIcon(ruta);
                imagenProducto.setText("");
                imagenProducto.setIcon(prueba);
            }
        }

        if (e.getSource() == btAgregar) {
            String ruta = tfRutaImagen.getText();
            System.out.println("Ruta: " + ruta);
            try {
                byte[] imagen = new byte[(int) ruta.length()];
                //InputStream input = new FileInputStream(ruta);
                //input.read(imagen);
                prod.setImagen_Producto(imagen);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Enviar Imagen: " + ex.getMessage());
                prod.setImagen_Producto(null);
            }
            dao.registrar(prod);
            mostrarImgen();
        }
    }
}
