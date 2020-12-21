package upeu.gui.ventana;

import upeu.dao.DAODetalleVImpl;
import upeu.dao.DAOProductoImpl;
import upeu.dao.DAOUsuarioImpl;
import upeu.gui.login.JPanelSlider;
import upeu.interfaces.DAODetalleVenta;
import upeu.interfaces.DAOProducto;
import upeu.interfaces.DAOUsuario;
import upeu.pojo.DetalleVenta;
import upeu.pojo.Producto;
import upeu.pojo.Usuario;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class VentanaPrincipalCliente extends JFrame implements MouseMotionListener, MouseListener, ActionListener {
    String nameUser;
    public VentanaPrincipalCliente(String nameUser){
        this.nameUser = nameUser;
        setUndecorated(true);
        setSize(1030,560);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
        initComponents();
        try {
            this.setIconImage(ImageIO.read(new File("imagenes/logo4.png")));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        setTitle("Cool Bucket");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponents(){
        princPanel();
        lbNameUser.setText(nameUser);
        opciones();
        configuracion();
        articulos();
        colocarProd();
    }

    JPanel panelPricipal = new JPanel();
    public void princPanel (){
        panelPricipal.setBounds(0,0,1050,600);
        getContentPane().add(panelPricipal, BorderLayout.CENTER);
        panelPricipal.setLayout(null);
    }

    JPanel pnlOpciones = new JPanel(new FlowLayout());
    JButton btTienda = new JButton(new ImageIcon("imagenes/VentanaUsuario/tienda.png"));
    JButton btCarrito = new JButton(new ImageIcon("imagenes/VentanaUsuario/carrito.png"));
    JButton btAyuda = new JButton(new ImageIcon("imagenes/VentanaUsuario/ayuda.png"));

    CarritoPanel pnlCarrito = new CarritoPanel();

    Color colorBtn = new Color(0,0,0);
    Color colorText = new Color(222,222,222);
    Font fuenteText = new Font("Arial",1,15);
    public void opciones (){
        pnlOpciones.setBounds(270,10,750,100);
        pnlOpciones.setBackground(new Color(0,0,0,200));
        pnlOpciones.setLayout(null);
        panelPricipal.add(pnlOpciones);

        btTienda.setBounds(15,10,125,80);
        btTienda.setBackground(colorBtn);
        btTienda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlSlArticulos.setVisible(true);
                pnlCarrito.setVisible(false);
            }
        });
        pnlOpciones.add(btTienda);

        btCarrito.setBounds(155,10,125,80);
        btCarrito.setBackground(colorBtn);
        btCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbFondoArticulos.add(pnlCarrito);
                pnlCarrito.setVisible(true);
                pnlCarrito.mostrarTablaCar();
                pnlSlArticulos.setVisible(false);
            }
        });
        pnlOpciones.add(btCarrito);

        btAyuda.setBounds(295,10,125,80);
        btAyuda.setBackground(colorBtn);
        pnlOpciones.add(btAyuda);
    }


    JPanel pnlConfig = new JPanel();
    JLabel logoApp = new JLabel(new ImageIcon(""));
    JLabel lbImageUser = new JLabel(new ImageIcon("imagenes/VentanaUsuario/user3.png"));
    JLabel lbNameUser = new JLabel();
    JButton btCompras = new JButton("Tus Compras");
    JButton btCartera = new JButton("Cartera");
    JButton btConfigUser = new JButton("Configuración");
    JButton btSalir = new JButton("Salir");
    public void configuracion (){
        pnlConfig.setLayout(null);
        pnlConfig.setBounds(10,10,250,540);
        pnlConfig.setBackground(new Color(0,0,0,200));
        panelPricipal.add(pnlConfig);

        logoApp.setBounds(8,8,120,40);
        logoApp.setOpaque(true);
        pnlConfig.add(logoApp);

        lbImageUser.setBounds(60,63,125,125);
        pnlConfig.add(lbImageUser);

        lbNameUser.setBounds(10,200,100,25);
        lbNameUser.setForeground(Color.white);
        lbNameUser.setFont(new Font("Arial",Font.ITALIC,15));
        pnlConfig.add(lbNameUser);

        btCompras.setBounds(5,250,240,50);
        btCompras.setBackground(colorBtn);
        btCompras.setForeground(colorText);
        btCompras.setFont(fuenteText);
        pnlConfig.add(btCompras);

        btCartera.setBounds(5,315,240,50);
        btCartera.setBackground(colorBtn);
        btCartera.setForeground(colorText);
        btCartera.setFont(fuenteText);
        pnlConfig.add(btCartera);

        btConfigUser.setBounds(5,380,240,50);
        btConfigUser.setBackground(colorBtn);
        btConfigUser.setForeground(colorText);
        btConfigUser.setFont(fuenteText);
        pnlConfig.add(btConfigUser);

        btSalir.setBounds(50,470,150,50);
        btSalir.addActionListener(this);
        pnlConfig.add(btSalir);
    }

    JLabel lbFondoArticulos = new JLabel(new ImageIcon("imagenes/Admin/adminFon2.gif"));
    JPanelSlider pnlSlArticulos = new JPanelSlider();
    JPanel pnlVista1 = new JPanel();
    JPanel pnlVista2 = new JPanel();
    JPanel pnlVista3 = new JPanel();
    JPanel pnlVista4 = new JPanel();
    ImageIcon imageLeft = new ImageIcon("imagenes/VentanaUsuario/Left.png");
    ImageIcon imageRight = new ImageIcon("imagenes/VentanaUsuario/Right.png");
    JButton btVista1Left = new JButton();
    JButton btVista1Right = new JButton();
    JButton btVista2Left = new JButton();
    JButton btVista2Right = new JButton();
    JButton btVista3Left = new JButton();
    JButton btVista3Right = new JButton();
    JButton btVista4Left = new JButton();
    JButton btVista4Right = new JButton();

    JPanel plantilla1Prod = new JPanel(new GridLayout(2,4,10,15));
    JPanel plantilla2Prod = new JPanel(new GridLayout(2,4,10,15));
    JPanel plantilla3Prod = new JPanel(new GridLayout(2,4,10,15));
    JPanel plantilla4Prod = new JPanel(new GridLayout(2,4,10,15));

    public void articulos(){
        lbFondoArticulos.setBounds(270,120,750,430);
        panelPricipal.add(lbFondoArticulos);

        pnlSlArticulos.setBounds(0,0,750,430);
        pnlSlArticulos.setOpaque(false);
        lbFondoArticulos.add(pnlSlArticulos);
        pnlSlArticulos.setVisible(true);

        //Panel Vista 1 con el boton left
        pnlVista1.setLayout(null);
        pnlVista1.setOpaque(false);
        pnlSlArticulos.add(pnlVista1);

        plantilla1Prod.setBounds(70,20,610,385);
        plantilla1Prod.setOpaque(false);
        pnlVista1.add(plantilla1Prod);

        btVista1Left.setBounds(5,160,45,100);
        btVista1Left.setIcon(imageLeft);
        btVista1Left.setOpaque(false);
        btVista1Left.setContentAreaFilled(false);
        btVista1Left.setBorder(null);
        btVista1Left.addActionListener(this);
        pnlVista1.add(btVista1Left);

        btVista1Right.setBounds(700,160,45,100);
        btVista1Right.setIcon(imageRight);
        btVista1Right.setOpaque(false);
        btVista1Right.setContentAreaFilled(false);
        btVista1Right.setBorder(null);
        btVista1Right.addActionListener(this);
        pnlVista1.add(btVista1Right);

        //Panel Vista 2 con los botones rigth y left
        pnlVista2.setLayout(null);
        pnlVista2.setOpaque(false);
        pnlSlArticulos.add(pnlVista2);

        plantilla2Prod.setBounds(70,20,610,385);
        plantilla2Prod.setOpaque(false);
        pnlVista2.add(plantilla2Prod);

        btVista2Left.setBounds(5,160,45,100);
        btVista2Left.setIcon(imageLeft);
        btVista2Left.setOpaque(false);
        btVista2Left.setContentAreaFilled(false);
        btVista2Left.setBorder(null);
        btVista2Left.addActionListener(this);
        pnlVista2.add(btVista2Left);

        btVista2Right.setBounds(700,160,45,100);
        btVista2Right.setIcon(imageRight);
        btVista2Right.setOpaque(false);
        btVista2Right.setContentAreaFilled(false);
        btVista2Right.setBorder(null);
        btVista2Right.addActionListener(this);
        pnlVista2.add(btVista2Right);

        //Panel Vista 3 con los botones rigth y left
        pnlVista3.setLayout(null);
        pnlVista3.setOpaque(false);
        pnlSlArticulos.add(pnlVista3);

        plantilla3Prod.setBounds(70,20,610,385);
        plantilla3Prod.setOpaque(false);
        pnlVista3.add(plantilla3Prod);

        btVista3Left.setBounds(5,160,45,100);
        btVista3Left.setIcon(imageLeft);
        btVista3Left.setOpaque(false);
        btVista3Left.setContentAreaFilled(false);
        btVista3Left.setBorder(null);
        btVista3Left.addActionListener(this);
        pnlVista3.add(btVista3Left);

        btVista3Right.setBounds(700,160,45,100);
        btVista3Right.setIcon(imageRight);
        btVista3Right.setOpaque(false);
        btVista3Right.setContentAreaFilled(false);
        btVista3Right.setBorder(null);
        btVista3Right.addActionListener(this);
        pnlVista3.add(btVista3Right);

        //Panel Vista 4 con el boton rigth
        pnlVista4.setLayout(null);
        pnlVista4.setOpaque(false);
        pnlSlArticulos.add(pnlVista4);

        plantilla4Prod.setBounds(70,20,610,385);
        plantilla4Prod.setOpaque(false);
        pnlVista4.add(plantilla4Prod);

        btVista4Left.setBounds(5,160,45,100);
        btVista4Left.setIcon(imageLeft);
        btVista4Left.setOpaque(false);
        btVista4Left.setContentAreaFilled(false);
        btVista4Left.setBorder(null);
        btVista4Left.addActionListener(this);
        pnlVista4.add(btVista4Left);

        btVista4Right.setBounds(700,160,45,100);
        btVista4Right.setIcon(imageRight);
        btVista4Right.setOpaque(false);
        btVista4Right.setContentAreaFilled(false);
        btVista4Right.setBorder(null);
        btVista4Right.addActionListener(this);
        pnlVista4.add(btVista4Right);
    }

    DAOProducto daoProd = new DAOProductoImpl();
    public void colocarProd(){
        plantilla1Prod.removeAll();
        daoProd = new DAOProductoImpl();
        List<Producto> lista = daoProd.listar();
        for (int i = 0; i<8; i++){
            JButton btnProd = new JButton(lista.get(i).getNombre_Producto());
            btnProd.setBackground(new Color(34,0,0));
            btnProd.setLayout(new BorderLayout());
            JLabel lbPrecio = new JLabel("S/."+lista.get(i).getPrecio_Producto(),SwingConstants.CENTER);
            lbPrecio.setForeground(Color.GREEN);
            btnProd.add(lbPrecio,BorderLayout.SOUTH);
            btnProd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Name Prod: "+btnProd.getText());
                    selectProd(btnProd.getText(),lbPrecio.getText());
                }
            });
            plantilla1Prod.add(btnProd);
        }
    }

    JFrame jfSelectProd = new JFrame();
    JPanel pnlSelectProd = new JPanel();
    JPanel pnlDatopProd = new JPanel();
    JLabel lbCarritoIco = new JLabel(new ImageIcon("imagenes/VentanaUsuario/carrito.png"));
    JLabel lbNameProd = new JLabel();
    JLabel lbPrecioUnit = new JLabel();
    JLabel lbDescuentoProd = new JLabel();
    JLabel lbCanidadP = new JLabel("Cantidad:");
    SpinnerModel spModel =  new SpinnerNumberModel(1,1,3,1);
    JSpinner spCantidadP = new JSpinner(spModel);
    JButton btEnviar = new JButton("Añadir al carrito");
    JButton btCancelar = new JButton("Salir");

    Font fuenteSelectProd = new Font("Arial",Font.BOLD,18);
    public void selectProd(String nameProd, String precioProd) {
        jfSelectProd.setUndecorated(true);
        jfSelectProd.setSize(490, 270);
        jfSelectProd.setVisible(true);
        jfSelectProd.setBackground(new Color(0,0,0,20));
        jfSelectProd.setLocationRelativeTo(null);
        jfSelectProd.setLayout(new BorderLayout());

        pnlSelectProd.setBackground(new Color(0, 0, 0));
        pnlSelectProd.setBackground(new Color(0,0,0,200));
        pnlSelectProd.setLayout(null);
        jfSelectProd.add(pnlSelectProd);

        lbCarritoIco.setBounds(200, 5, 100, 100);
        pnlSelectProd.add(lbCarritoIco);

        pnlDatopProd.setBounds(20, 115, 450, 30);
        pnlDatopProd.setLayout(new FlowLayout(FlowLayout.CENTER,25,3));
        pnlDatopProd.setBackground(new Color(0,0,0,200));
        pnlDatopProd.setBorder(new TitledBorder(""));
        lbNameProd.setFont(fuenteSelectProd);
        lbNameProd.setText(nameProd);
        lbNameProd.setForeground(Color.white);
        pnlDatopProd.add(lbNameProd);
        lbPrecioUnit.setFont(fuenteSelectProd);
        lbPrecioUnit.setText(precioProd);
        lbPrecioUnit.setForeground(Color.white);
        pnlDatopProd.add(lbPrecioUnit);

        lbDescuentoProd.setFont(fuenteSelectProd);
        lbDescuentoProd.setForeground(Color.GREEN);
        lbDescuentoProd.setText(validarDescuento(lbNameUser.getText())+"% OFF");
        pnlDatopProd.add(lbDescuentoProd);
        pnlSelectProd.add(pnlDatopProd);

        lbCanidadP.setBounds(150,175,80,25);
        lbCanidadP.setForeground(Color.white);
        pnlSelectProd.add(lbCanidadP);
        JSeparator spd1 = new JSeparator();
        spd1.setBounds(150,200,180,2);
        pnlSelectProd.add(spd1);

        spCantidadP.setEditor(new JSpinner.DefaultEditor(spCantidadP));
        spCantidadP.setBounds(230,175,100,25);
        pnlSelectProd.add(spCantidadP);

        btEnviar.setBounds(155,235,170,25);
        btEnviar.setBackground(new Color(32,0,0));
        btEnviar.addActionListener(this);
        pnlSelectProd.add(btEnviar);

        btCancelar.setBounds(15,235,75,25);
        btCancelar.setBackground(new Color(32,0,0));
        btCancelar.addActionListener(this);
        pnlSelectProd.add(btCancelar);
    }

    DAOUsuario daoU = new DAOUsuarioImpl();
    String desc;
    public String validarDescuento (String user){
        daoU = new DAOUsuarioImpl();
        for (Usuario u : daoU.listar(user)){
            if (u.getTipo_Usuario().equals("C")){
                desc = "1";
            }else if (u.getTipo_Usuario().equals("B")){
                desc = "3";
            }else if (u.getTipo_Usuario().equals("A")){
                desc = "6";
            }
        }
        return desc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btVista1Left){
            pnlSlArticulos.nextPanel(5,pnlVista4,pnlSlArticulos.right);
            plantilla4Prod.removeAll();
            daoProd = new DAOProductoImpl();
            List<Producto> lista = daoProd.listar();
            for (int i = 24; i<30; i++){
                JButton btnProd = new JButton(lista.get(i).getNombre_Producto());
                btnProd.setBackground(new Color(34,0,0));
                btnProd.setLayout(new BorderLayout());
                JLabel lbPrecio = new JLabel("S/."+lista.get(i).getPrecio_Producto(),SwingConstants.CENTER);
                lbPrecio.setForeground(Color.GREEN);
                btnProd.add(lbPrecio,BorderLayout.SOUTH);
                btnProd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectProd(btnProd.getText(),lbPrecio.getText());
                    }
                });
                plantilla4Prod.add(btnProd);
            }
        }
        if (e.getSource() == btVista1Right){
            pnlSlArticulos.nextPanel(5,pnlVista2,pnlSlArticulos.left);
            plantilla2Prod.removeAll();
            daoProd = new DAOProductoImpl();
            List<Producto> lista = daoProd.listar();
            for (int i = 8; i<16; i++){
                JButton btnProd = new JButton(lista.get(i).getNombre_Producto());
                btnProd.setBackground(new Color(34,0,0));
                btnProd.setLayout(new BorderLayout());
                JLabel lbPrecio = new JLabel("S/."+lista.get(i).getPrecio_Producto(),SwingConstants.CENTER);
                lbPrecio.setForeground(Color.GREEN);
                btnProd.add(lbPrecio,BorderLayout.SOUTH);
                btnProd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Name Prod: "+btnProd.getText());
                        selectProd(btnProd.getText(),lbPrecio.getText());
                    }
                });
                plantilla2Prod.add(btnProd);
            }
        }

        if (e.getSource() == btVista2Left){
            pnlSlArticulos.nextPanel(5,pnlVista1,pnlSlArticulos.right);
            plantilla1Prod.removeAll();
            daoProd = new DAOProductoImpl();
            List<Producto> lista = daoProd.listar();
            for (int i = 0; i<8; i++){
                JButton btnProd = new JButton(lista.get(i).getNombre_Producto());
                btnProd.setBackground(new Color(34,0,0));
                btnProd.setLayout(new BorderLayout());
                JLabel lbPrecio = new JLabel("S/."+lista.get(i).getPrecio_Producto(),SwingConstants.CENTER);
                lbPrecio.setForeground(Color.GREEN);
                btnProd.add(lbPrecio,BorderLayout.SOUTH);
                btnProd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Name Prod: "+btnProd.getText());
                        selectProd(btnProd.getText(),lbPrecio.getText());
                    }
                });
                plantilla1Prod.add(btnProd);
            }
        }
        if (e.getSource() == btVista2Right){
            pnlSlArticulos.nextPanel(5,pnlVista3,pnlSlArticulos.left);
            plantilla3Prod.removeAll();
            daoProd = new DAOProductoImpl();
            List<Producto> lista = daoProd.listar();
            for (int i = 16; i<24; i++){
                JButton btnProd = new JButton(lista.get(i).getNombre_Producto());
                btnProd.setBackground(new Color(34,0,0));
                btnProd.setLayout(new BorderLayout());
                JLabel lbPrecio = new JLabel("S/."+lista.get(i).getPrecio_Producto(),SwingConstants.CENTER);
                lbPrecio.setForeground(Color.GREEN);
                btnProd.add(lbPrecio,BorderLayout.SOUTH);
                btnProd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Name Prod: "+btnProd.getText());
                        selectProd(btnProd.getText(),lbPrecio.getText());
                    }
                });
                plantilla3Prod.add(btnProd);
            }
        }

        if (e.getSource() == btVista3Left){
            pnlSlArticulos.nextPanel(5,pnlVista2,pnlSlArticulos.right);
            plantilla2Prod.removeAll();
            daoProd = new DAOProductoImpl();
            List<Producto> lista = daoProd.listar();
            for (int i = 8; i<16; i++){
                JButton btnProd = new JButton(lista.get(i).getNombre_Producto());
                btnProd.setBackground(new Color(34,0,0));
                btnProd.setLayout(new BorderLayout());
                JLabel lbPrecio = new JLabel("S/."+lista.get(i).getPrecio_Producto(),SwingConstants.CENTER);
                lbPrecio.setForeground(Color.GREEN);
                btnProd.add(lbPrecio,BorderLayout.SOUTH);
                btnProd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Name Prod: "+btnProd.getText());
                        selectProd(btnProd.getText(),lbPrecio.getText());
                    }
                });
                plantilla2Prod.add(btnProd);
            }
        }
        if(e.getSource() == btVista3Right){
            pnlSlArticulos.nextPanel(5,pnlVista4,pnlSlArticulos.left);
            plantilla4Prod.removeAll();
            daoProd = new DAOProductoImpl();
            List<Producto> lista = daoProd.listar();
            for (int i = 24; i<30; i++){
                JButton btnProd = new JButton(lista.get(i).getNombre_Producto());
                btnProd.setBackground(new Color(34,0,0));
                btnProd.setLayout(new BorderLayout());
                JLabel lbPrecio = new JLabel("S/."+lista.get(i).getPrecio_Producto(),SwingConstants.CENTER);
                lbPrecio.setForeground(Color.GREEN);
                btnProd.add(lbPrecio,BorderLayout.SOUTH);
                btnProd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Name Prod: "+btnProd.getText());
                        selectProd(btnProd.getText(),lbPrecio.getText());
                    }
                });
                plantilla4Prod.add(btnProd);
            }
        }

        if(e.getSource() == btVista4Left){
            pnlSlArticulos.nextPanel(5,pnlVista3,pnlSlArticulos.right);
            plantilla3Prod.removeAll();
            daoProd = new DAOProductoImpl();
            List<Producto> lista = daoProd.listar();
            for (int i = 16; i<24; i++){
                JButton btnProd = new JButton(lista.get(i).getNombre_Producto());
                btnProd.setBackground(new Color(34,0,0));
                btnProd.setLayout(new BorderLayout());
                JLabel lbPrecio = new JLabel("S/."+lista.get(i).getPrecio_Producto(),SwingConstants.CENTER);
                lbPrecio.setForeground(Color.GREEN);
                btnProd.add(lbPrecio,BorderLayout.SOUTH);
                btnProd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Name Prod: "+btnProd.getText());
                        selectProd(btnProd.getText(),lbPrecio.getText());
                    }
                });
                plantilla3Prod.add(btnProd);
            }
        }

        if(e.getSource() == btVista4Right){
            pnlSlArticulos.nextPanel(5,pnlVista1,pnlSlArticulos.left);
            plantilla1Prod.removeAll();
            daoProd = new DAOProductoImpl();
            List<Producto> lista = daoProd.listar();
            for (int i = 0; i<8; i++){
                JButton btnProd = new JButton(lista.get(i).getNombre_Producto());
                btnProd.setBackground(new Color(34,0,0));
                btnProd.setLayout(new BorderLayout());
                JLabel lbPrecio = new JLabel("S/."+lista.get(i).getPrecio_Producto(),SwingConstants.CENTER);
                lbPrecio.setForeground(Color.GREEN);
                btnProd.add(lbPrecio,BorderLayout.SOUTH);
                btnProd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Name Prod: "+btnProd.getText());
                        selectProd(btnProd.getText(),lbPrecio.getText());
                    }
                });
                plantilla1Prod.add(btnProd);
            }
        }

        if (e.getSource() == btEnviar){
            dtll = new DAODetalleVImpl();
            dtv.setNombre_Producto(lbNameProd.getText());
            dtv.setCantidad_DetalleV((Integer)spCantidadP.getValue());
            dtv.setPrecioUnitario_DetalleV(Integer.parseInt(lbPrecioUnit.getText().substring(3)));
            dtv.setPrecioUnitario_DetalleV(Double.parseDouble(lbPrecioUnit.getText()));
            dtv.setDescuento_DetalleV(Integer.parseInt(validarDescuento(lbNameUser.getText())));
            jfSelectProd.dispose();
        }

        if (e.getSource() == btCancelar){
            jfSelectProd.dispose();
        }

        if (e.getSource() == btSalir){
            System.exit(0);
        }
    }
    DetalleVenta dtv = new DetalleVenta();
    DAODetalleVenta dtll = new DAODetalleVImpl();

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    int xx,xy;
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this){
            xx = e.getX();
            xy = e.getY();
        }
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
        if (e.getSource() == this){
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();
            this.setLocation(x - xx, y -xy);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}