package upeu.gui.login;

import upeu.dao.DAOPersonaImpl;
import upeu.dao.DAOUsuarioImpl;
import upeu.interfaces.DAOPersona;
import upeu.interfaces.DAOUsuario;
import upeu.pojo.Persona;
import upeu.pojo.Usuario;
import upeu.utils.CifrarClave;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrarUsuario extends JPanel implements MouseListener, ActionListener, KeyListener {

    public RegistrarUsuario(){
        setBounds(0,0,1005,570);
        setVisible(false);
        setLayout(null);
        initComponents();
    }

    public void initComponents(){
        fondoRegstr();
        registrarUsuario();
        datosPersonales();
        datosUsuario();
    }

    ImageIcon fondo = new ImageIcon("imagenes/login/RegstrClient/Fondo2.0.jpg");
    JLabel lbFondoRClnt = new JLabel(fondo);
    public void fondoRegstr (){
        lbFondoRClnt.setBounds(0,0,1005,570);
        lbFondoRClnt.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lbFondoRClnt.getWidth(), lbFondoRClnt.getHeight(), Image.SCALE_SMOOTH)));
        add(lbFondoRClnt);
        lbFondoRClnt.setLayout(null);
    }

    JPanelSlider pnlSlRegst = new JPanelSlider();
    JPanel pnlDatosPersonales = new JPanel();
    JPanel pnlDatosUsuario = new JPanel();
    JButton btnSalir = new JButton("Salir");

    public void registrarUsuario(){
        pnlSlRegst.setOpaque(false);
        pnlSlRegst.setBorder(new TitledBorder(""));
        pnlSlRegst.setBounds(550,15,425,540);

        btnSalir.setBounds(10,540,80,20);
        btnSalir.setBackground(new Color(0,0,0));
        btnSalir.addActionListener(this);
        lbFondoRClnt.add(btnSalir);

        pnlDatosPersonales.setBackground(new Color(10,0,0));
        pnlDatosPersonales.setLayout(null);
        pnlDatosUsuario.setBackground(new Color(10,0,0));
        pnlDatosUsuario.setLayout(null);

        pnlSlRegst.add(pnlDatosPersonales);
        pnlSlRegst.add(pnlDatosUsuario);
        lbFondoRClnt.add(pnlSlRegst);
    }

    Font fuente = new Font("Arial",Font.BOLD,15);
    Color fuenteColor = new Color(211,211,211);

    JLabel lbNombres = new JLabel("Nombres:");
    JLabel lbApPaterno = new JLabel("Apellido Paterno:");
    JLabel lbApMaterno = new JLabel("Apellido Materno:");
    JLabel lbFechaNaci = new JLabel("Fecha de Nacimiento:");
    ButtonGroup btGrup = new ButtonGroup();
    JRadioButton rbF = new JRadioButton("Femenino");
    JRadioButton rbM = new JRadioButton("Masculino");
    JLabel lbDocumento = new JLabel("Documento:");
    JLabel lbDireccion = new JLabel("Dirección:");
    JLabel lbCelular = new JLabel("Celular:");

    JTextField tfNombres = new JTextField("Ziro Wagner");
    JTextField tfApPaterno = new JTextField("Mamani");
    JTextField tfApMaterno = new JTextField("Mamani");
    JTextField tfFechaNaci = new JTextField("12-12-2020");
    JTextField tfDocumento = new JTextField();
    JTextField tfDireccion = new JTextField("Jr.Bazadre");
    JTextField tfCelular = new JTextField("9831312");

    JButton btSiguiente = new JButton("Siguiente");
    public void datosPersonales () {
        lbNombres.setBounds(70, 90, 75, 25);
        lbNombres.setForeground(fuenteColor);
        lbNombres.setFont(fuente);
        pnlDatosPersonales.add(lbNombres);

        tfNombres.setBounds(145, 90, 210, 25);
        tfNombres.setOpaque(false);
        tfNombres.setBorder(null);
        tfNombres.setForeground(fuenteColor);
        tfNombres.addKeyListener(this);
        pnlDatosPersonales.add(tfNombres);
        JSeparator spd1 = new JSeparator();
        spd1.setBounds(70,115,280,1);
        pnlDatosPersonales.add(spd1);

        lbApPaterno.setBounds(70, 135, 130, 25);
        lbApPaterno.setForeground(fuenteColor);
        lbApPaterno.setFont(fuente);
        pnlDatosPersonales.add(lbApPaterno);

        tfApPaterno.setBounds(200, 135, 155, 25);
        tfApPaterno.setForeground(fuenteColor);
        tfApPaterno.setOpaque(false);
        tfApPaterno.setBorder(null);
        tfApPaterno.addKeyListener(this);
        pnlDatosPersonales.add(tfApPaterno);
        JSeparator spd2 = new JSeparator();
        spd2.setBounds(70,160,280,1);
        pnlDatosPersonales.add(spd2);

        lbApMaterno.setBounds(70, 180, 130, 25);
        lbApMaterno.setForeground(fuenteColor);
        lbApMaterno.setFont(fuente);
        pnlDatosPersonales.add(lbApMaterno);

        tfApMaterno.setBounds(200, 180, 155, 25);
        tfApMaterno.setForeground(fuenteColor);
        tfApMaterno.setOpaque(false);
        tfApMaterno.setBorder(null);
        tfApMaterno.addKeyListener(this);
        pnlDatosPersonales.add(tfApMaterno);
        JSeparator spd3 = new JSeparator();
        spd3.setBounds(70,205,280,1);
        pnlDatosPersonales.add(spd3);

        lbFechaNaci.setBounds(70, 225, 158, 25);
        lbFechaNaci.setForeground(fuenteColor);
        lbFechaNaci.setFont(fuente);
        pnlDatosPersonales.add(lbFechaNaci);

        tfFechaNaci.setBounds(228, 225, 127, 25);
        tfFechaNaci.setForeground(fuenteColor);
        tfFechaNaci.setOpaque(false);
        tfFechaNaci.setBorder(null);
        tfFechaNaci.addKeyListener(this);
        pnlDatosPersonales.add(tfFechaNaci);
        JSeparator spd4 = new JSeparator();
        spd4.setBounds(70,250,280,1);
        pnlDatosPersonales.add(spd4);

        rbF.setBounds(110,270,80,25);
        rbF.setForeground(fuenteColor);
        rbF.setOpaque(false);
        rbF.setFocusable(false);
        pnlDatosPersonales.add(rbF);
        rbM.setBounds(240,270,85,25);
        rbM.setForeground(fuenteColor);
        rbM.setOpaque(false);
        rbM.setFocusable(false);
        pnlDatosPersonales.add(rbM);
        btGrup.add(rbF);
        btGrup.add(rbM);

        lbDocumento.setBounds(70,310,90,25);
        lbDocumento.setForeground(fuenteColor);
        lbDocumento.setFont(fuente);
        pnlDatosPersonales.add(lbDocumento);

        tfDocumento.setBounds(160,310,195,25);
        tfDocumento.setForeground(fuenteColor);
        tfDocumento.setOpaque(false);
        tfDocumento.setBorder(null);
        tfDocumento.addKeyListener(this);
        pnlDatosPersonales.add(tfDocumento);
        JSeparator spd5 = new JSeparator();
        spd5.setBounds(70,335,280,1);
        pnlDatosPersonales.add(spd5);

        lbDireccion.setBounds(70,355,78,25);
        lbDireccion.setForeground(fuenteColor);
        lbDireccion.setFont(fuente);
        pnlDatosPersonales.add(lbDireccion);

        tfDireccion.setBounds(148,355,207,25);
        tfDireccion.setForeground(fuenteColor);
        tfDireccion.setOpaque(false);
        tfDireccion.setBorder(null);
        tfDireccion.addKeyListener(this);
        pnlDatosPersonales.add(tfDireccion);
        JSeparator spd6 = new JSeparator();
        spd6.setBounds(70,380,280,1);
        pnlDatosPersonales.add(spd6);

        lbCelular.setBounds(70,400,75,25);
        lbCelular.setForeground(fuenteColor);
        lbCelular.setFont(fuente);
        pnlDatosPersonales.add(lbCelular);

        tfCelular.setBounds(145,400,210,25);
        tfCelular.setForeground(fuenteColor);
        tfCelular.setOpaque(false);
        tfCelular.setBorder(null);
        tfCelular.addKeyListener(this);
        pnlDatosPersonales.add(tfCelular);
        JSeparator spd7 = new JSeparator();
        spd7.setBounds(70,425,280,1);
        pnlDatosPersonales.add(spd7);

        btSiguiente.setBounds(153,465,120,25);
        btSiguiente.setBackground(new Color(0,0,0));
        btSiguiente.addActionListener(this);
        pnlDatosPersonales.add(btSiguiente);
    }

    JLabel lbCorreo = new JLabel("Correo");
    JLabel lbNomUser = new JLabel("Nombre de usuario");
    JLabel lbClave = new JLabel("Contraseña");
    JLabel lbVerifClave = new JLabel("Confirmar contraseña");

    JTextField tfCorreo = new JTextField("@gmail.com");
    JTextField tfNomUser = new JTextField("WagnerSub");
    JPasswordField tfClave = new JPasswordField("123");
    JPasswordField tfConfirmClave = new JPasswordField("123");

    JButton btVolver = new JButton("Volver");
    JButton btCrearCuenta = new JButton("Crear");
    public void datosUsuario (){
        lbCorreo.setBounds(100,95,60,25);
        lbCorreo.setFont(fuente);
        lbCorreo.setForeground(fuenteColor);
        pnlDatosUsuario.add(lbCorreo);

        tfCorreo.setBounds(100,120,220,25);
        tfCorreo.setOpaque(false);
        tfCorreo.setBorder(null);
        tfCorreo.setForeground(fuenteColor);
        pnlDatosUsuario.add(tfCorreo);
        JSeparator spdU1 = new JSeparator();
        spdU1.setBounds(100,145,220,1);
        pnlDatosUsuario.add(spdU1);

        lbNomUser.setBounds(100,165,150,25);
        lbNomUser.setFont(fuente);
        lbNomUser.setForeground(fuenteColor);
        pnlDatosUsuario.add(lbNomUser);

        tfNomUser.setBounds(100,190,220,25);
        tfNomUser.setOpaque(false);
        tfNomUser.setBorder(null);
        tfNomUser.setForeground(fuenteColor);
        pnlDatosUsuario.add(tfNomUser);
        JSeparator spdU2 = new JSeparator();
        spdU2.setBounds(100,215,220,1);
        pnlDatosUsuario.add(spdU2);

        lbClave.setBounds(100,235,100,25);
        lbClave.setFont(fuente);
        lbClave.setForeground(fuenteColor);
        pnlDatosUsuario.add(lbClave);

        tfClave.setBounds(100,260,220,25);
        tfClave.setOpaque(false);
        tfClave.setBorder(null);
        tfClave.setLayout(new BorderLayout());
        tfClave.addKeyListener(this);
        tfClave.setForeground(fuenteColor);
        pnlDatosUsuario.add(tfClave);
        JSeparator spdU3 = new JSeparator();
        spdU3.setBounds(100,285,220,1);
        pnlDatosUsuario.add(spdU3);

        lbVerifClave.setBounds(100,305,180,25);
        lbVerifClave.setFont(fuente);
        lbVerifClave.setForeground(fuenteColor);
        pnlDatosUsuario.add(lbVerifClave);

        tfConfirmClave.setBounds(100,330,220,25);
        tfConfirmClave.setOpaque(false);
        tfConfirmClave.setBorder(null);
        tfConfirmClave.setLayout(new BorderLayout());
        tfConfirmClave.add(check, BorderLayout.EAST);
        tfConfirmClave.addKeyListener(this);
        tfConfirmClave.setForeground(fuenteColor);
        pnlDatosUsuario.add(tfConfirmClave);
        JSeparator spdU4 = new JSeparator();
        spdU4.setBounds(100,355,220,1);
        pnlDatosUsuario.add(spdU4);

        btVolver.setBounds(115,445,85,25);
        btVolver.setBackground(new Color(0,0,0));
        btVolver.addActionListener(this);
        pnlDatosUsuario.add(btVolver);

        btCrearCuenta.setBounds(220,445,85,25);
        btCrearCuenta.setBackground(new Color(0,0,0));
        btCrearCuenta.setEnabled(false);
        btCrearCuenta.addActionListener(this);
        pnlDatosUsuario.add(btCrearCuenta);
    }

    Usuario user = new Usuario();
    Persona person = new Persona();
    DAOUsuario daoU = new DAOUsuarioImpl();
    DAOPersona daoP = new DAOPersonaImpl();
    CifrarClave cifrado = new CifrarClave();
    SimpleDateFormat fechaActual = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date dateFecha = new Date();
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btSiguiente){
            pnlSlRegst.nextPanel(5,pnlDatosUsuario,pnlSlRegst.left);
        }

        if (e.getSource() == btVolver){
            pnlSlRegst.nextPanel(5,pnlDatosPersonales,pnlSlRegst.right);
        }

        if (e.getSource() == btCrearCuenta){
            person.setNombres(tfNombres.getText());
            person.setAp_Paterno(tfApPaterno.getText());
            person.setAp_Materno(tfApMaterno.getText());
            person.setFechaNacimiento(tfFechaNaci.getText());
            if (rbF.isSelected()){
                person.setSexo("F");
            }else if (rbM.isSelected()){
                person.setSexo("M");
            }
            person.setDocumento(tfDocumento.getText());
            person.setDireccion(tfDireccion.getText());
            person.setCelular(Integer.parseInt(tfCelular.getText()));
            daoP.registrar(person);
            daoP = new DAOPersonaImpl();
            user.setCorreo_Usuario(tfCorreo.getText());
            user.setNombre_Usuario(tfNomUser.getText());
            user.setClave_Usuario(cifrado.md5(String.valueOf(tfConfirmClave.getPassword())));
            user.setTipo_Usuario("C");
            user.setEstado_Usuario(1);
            user.setFechaCreacion_Usuario(""+fechaActual.format(dateFecha));
            user.setId_PersonaFK(daoP.ultimaIdPersona().getId_Persona());
            System.out.println("ID: "+daoP.ultimaIdPersona().getId_Persona());
            daoU.registrar(user);
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

    @Override
    public void keyTyped(KeyEvent e) {
        char validar = e.getKeyChar();
        if (e.getSource() == tfNombres){
            if (Character.isDigit(validar)){
                getToolkit().beep();
                e.consume();
            }
        }
        if (e.getSource() == tfApPaterno){
            if (Character.isDigit(validar)){
                getToolkit().beep();
                e.consume();
            }
        }
        if (e.getSource() == tfApMaterno){
            if (Character.isDigit(validar)){
                getToolkit().beep();
                e.consume();
            }
        }
        if (e.getSource() == tfDireccion){
            if (Character.isDigit(validar)){
                getToolkit().beep();
                e.consume();
            }
        }
        if (e.getSource() == tfFechaNaci){
            if (Character.isLetter(validar)){
                getToolkit().beep();
                e.consume();
            }
        }
        if (e.getSource() == tfDocumento){
            if (Character.isLetter(validar)){
                getToolkit().beep();
                e.consume();
            }
        }
        if (e.getSource() == tfCelular){
            if (Character.isLetter(validar)){
                getToolkit().beep();
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
    }
    ImageIcon icoBien = new ImageIcon("imagenes/Admin/Check.png");
    ImageIcon icoMal = new ImageIcon("imagenes/Admin/DisCheck.png");
    JLabel check = new JLabel("", SwingConstants.CENTER);
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == tfConfirmClave){
            if (String.valueOf(tfClave.getPassword()).equals(String.valueOf(tfConfirmClave.getPassword()))){
                check.setIcon(icoBien);
                btCrearCuenta.setEnabled(true);
            }else {
                check.setIcon(icoMal);
                btCrearCuenta.setEnabled(false);
            }
        }
        if (e.getSource() == tfClave){
            if (String.valueOf(tfClave.getPassword()).equals(String.valueOf(tfConfirmClave.getPassword()))){
                check.setIcon(icoBien);
                btCrearCuenta.setEnabled(true);
            }else {
                check.setIcon(icoMal);
                btCrearCuenta.setEnabled(false);
            }
        }
    }
}