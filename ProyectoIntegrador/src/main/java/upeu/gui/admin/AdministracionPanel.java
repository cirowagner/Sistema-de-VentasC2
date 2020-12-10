package upeu.gui.admin;

import upeu.dao.DAOProductoImpl;
import upeu.gui.login.JPanelSlider;
import upeu.interfaces.DAOProducto;
import upeu.pojo.Producto;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.InputStream;

public class AdministracionPanel extends JPanel implements MouseListener, ActionListener {

    public AdministracionPanel(){
        setBounds(0,0,1005,570);
        setLayout(null);
        initComponents();
        modelo.mostrarTabla(tablaCrearProd);
        setVisible(false);
    }

    public void initComponents(){
        fondoRegstr();
        opciones();
        lista();
        modificar();
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
        btnSalir.setBackground(new Color(0,0,0,150));
        //btnSalir.setContentAreaFilled(false);
        btnSalir.addActionListener(this);
        opcionesPanel.add(btnSalir);

        lbFondoAdmin.add(opcionesPanel);
    }

    JPanelSlider gestionPanelSlider = new JPanelSlider();
    JPanel pnlCreaProducto = new JPanel();
    JTable tablaCrearProd = new JTable();
    TablaAdmin modelo = new TablaAdmin();

    public void lista() {
        gestionPanelSlider.setLayout(new BorderLayout());
        gestionPanelSlider.setBounds(10, 80, 985, 485);
        gestionPanelSlider.setOpaque(false);
        gestionPanelSlider.setBorder(new TitledBorder("Gestion"));
        lbFondoAdmin.add(gestionPanelSlider);

        pnlCreaProducto.setLayout(null);
        pnlCreaProducto.setOpaque(false);
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
        pnlCreaProducto.add(scroll);

        gestionPanelSlider.add(pnlCreaProducto);
    }

    JLabel imagenProducto = new JLabel("",SwingConstants.CENTER);
    JLabel lbNombre = new JLabel();
    JLabel lbPrecio = new JLabel();
    JLabel lbEstado = new JLabel();
    JLabel lbStockActual = new JLabel();
    JLabel lbCategoria = new JLabel();

    JButton btBuscarFile = new JButton("Archivo");
    JButton btEnviar = new JButton("Enviar");
    JTextField tfRuta = new JTextField();

    JFileChooser file = new JFileChooser();
    JTextField tfNombre = new JTextField();
    JTextField tfPrecio = new JTextField();
    JTextField tfEstado = new JTextField();
    JTextField tfStockActual = new JTextField();
    JTextField tfCategoria = new JTextField();

    public void modificar (){
        imagenProducto.setBounds(720,15,200,120);
        imagenProducto.setOpaque(true);
        imagenProducto.setBackground(Color.white);
        pnlCreaProducto.add(imagenProducto);

        btBuscarFile.setBounds(720,140,90,25);
        btBuscarFile.setBackground(new Color(0,0,0));
        btBuscarFile.addActionListener(this);
        pnlCreaProducto.add(btBuscarFile);

        tfRuta.setBounds(810,140,110,25);
        pnlCreaProducto.add(tfRuta);

        btEnviar.setBounds(720,170,80,25);
        btEnviar.setBackground(new Color(0,0,0));
        btEnviar.addActionListener(this);
        pnlCreaProducto.add(btEnviar);
    }

    public void mostrarImgen (){
        List<Producto>list = dao.listar();
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

    Producto prod = new Producto();
    DAOProducto dao = new DAOProductoImpl();
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btBuscarFile){
            JFileChooser archivo = new JFileChooser();
            archivo.setDialogTitle("Abrir imagen");
            archivo.setBackground(new Color(0,0,0));
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
        if (e.getSource() == btEnviar){
            String ruta = tfRuta.getText();
            System.out.println("Ruta: "+ruta);
            try{
                byte[] imagen = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(imagen);
                prod.setImagen_Producto(imagen);
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null,"Enviar Imagen: "+ex.getMessage());
                prod.setImagen_Producto(null);
            }
            dao.registrar(prod);
            mostrarImgen();
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