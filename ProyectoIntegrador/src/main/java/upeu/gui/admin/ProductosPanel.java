package upeu.gui.admin;

import upeu.dao.DAOProductoImpl;
import upeu.interfaces.DAOProducto;
import upeu.pojo.Producto;

import javax.imageio.ImageIO;
import javax.swing.*;
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
        setLayout(null);
        setOpaque(false);
        initComponents();
    }

    public void initComponents(){
        listarProducto();
        modelo.mostrarTabla(tablaCrearProd);
        modificar();
    }

    JTable tablaCrearProd = new JTable();
    TablaAdmin modelo = new TablaAdmin();

    public void listarProducto(){
        ((DefaultTableCellRenderer) tablaCrearProd.getDefaultRenderer(Object.class)).setOpaque(false);
        tablaCrearProd.setForeground(Color.WHITE);
        tablaCrearProd.getTableHeader().setOpaque(true);
        tablaCrearProd.getTableHeader().setBackground(new Color(26, 0, 0));
        tablaCrearProd.getTableHeader().setForeground(Color.white);

        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{},
                new String[]{"ID", "Nombre", "Precio", "Estado", "Stock Inicial", "Stock Actual", "ID Categoria","x"});

        tablaCrearProd.setModel(modelo);
        tablaCrearProd.setBackground(new Color(0,0,0,150));
        JScrollPane scroll = new JScrollPane(tablaCrearProd);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBounds(5,54,670,400);
        this.add(scroll);
    }

    JButton btBuscarFile = new JButton("Archivo");
    JTextField tfRuta = new JTextField();
    JButton btAgregar = new JButton("Agregar");
    JButton btActualizar = new JButton("Actualizar");
    JButton btEliminar = new JButton("Eliminar");

    JLabel imagenProducto = new JLabel("",SwingConstants.CENTER);
    JLabel lbNombre = new JLabel("Nombre");
    JLabel lbPrecio = new JLabel("Precio");
    JLabel lbEstado = new JLabel("Estado");
    JLabel lbStockActual = new JLabel("Stock Acutal");
    JComboBox cbxCategoria = new JComboBox();

    JTextField tfNombre = new JTextField();
    JTextField tfPrecio = new JTextField();
    JTextField tfEstado = new JTextField();
    JTextField tfStockActual = new JTextField();

    Color fuentoColor = new Color(222,222,222);

    public void modificar (){
        imagenProducto.setBounds(720,15,210,120);
        imagenProducto.setOpaque(false);
       //imagenProducto.setBackground(Color.white);
        this.add(imagenProducto);

        btBuscarFile.setBounds(720,140,90,25);
        btBuscarFile.setBackground(new Color(0,0,0));
        btBuscarFile.addActionListener(this);
        this.add(btBuscarFile);

        tfRuta.setBounds(810,140,120,25);
        this.add(tfRuta);

        lbNombre.setBounds(720,180,100,25);
        lbNombre.setForeground(fuentoColor);
        this.add(lbNombre);

        tfNombre.setBounds(805,180,126,25);
        this.add(tfNombre);

        lbPrecio.setBounds(720,215,100,25);
        lbPrecio.setForeground(fuentoColor);
        this.add(lbPrecio);

        tfPrecio.setBounds(805,215,126,25);
        this.add(tfPrecio);

        lbEstado.setBounds(720,250,100,25);
        lbEstado.setForeground(fuentoColor);
        this.add(lbEstado);

        tfEstado.setBounds(805,250,126,25);
        this.add(tfEstado);

        lbStockActual.setBounds(720,285,100,25);
        lbStockActual.setForeground(fuentoColor);
        this.add(lbStockActual);

        tfStockActual.setBounds(805,285,126,25);
        this.add(tfStockActual);

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
        if(e.getSource() == btBuscarFile){
            JFileChooser archivo = new JFileChooser();
            archivo.setDialogTitle("Abrir imagen");
            File url = new File("imagenes\\login");
            archivo.setCurrentDirectory(url);
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
            archivo.setFileFilter(filtro);
            int seleccion = archivo.showOpenDialog(null);
            if(seleccion == JFileChooser.APPROVE_OPTION){
                String ruta = archivo.getSelectedFile().getAbsolutePath();
                tfRuta.setText(ruta);
                ImageIcon prueba = new ImageIcon(ruta);
                imagenProducto.setText("");
                imagenProducto.setIcon(prueba);
            }
        }

        if (e.getSource() == btAgregar){
            String ruta = tfRuta.getText();
            System.out.println("Ruta: "+ruta);
            try{
                byte[] imagen = new byte[(int) ruta.length()];
                //InputStream input = new FileInputStream(ruta);
                //input.read(imagen);
                prod.setImagen_Producto(imagen);
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null,"Enviar Imagen: "+ex.getMessage());
                prod.setImagen_Producto(null);
            }
            dao.registrar(prod);
            mostrarImgen();
        }

        if (e.getSource() == btActualizar){

        }

        if (e.getSource() == btEliminar){

        }
    }
}
