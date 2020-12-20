package upeu.gui.admin;

import upeu.dao.DAOUsuarioImpl;
import upeu.interfaces.DAOUsuario;
import upeu.pojo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class UsuariosPanel extends JPanel implements ActionListener, KeyListener {

    public UsuariosPanel(){
        setVisible(true);
        setBounds(7,15,972, 465);
        setOpaque(false);
        setLayout(null);
        initComponents();
    }

    public void initComponents(){
        vistaTablaDatosPerson();
        mostrarDataPerson();
        utils();
    }

    JTable tablaUsuario = new JTable();
    DefaultTableModel modelo = new DefaultTableModel(new Object[][]{},new String[]{});
    public void vistaTablaDatosPerson(){
        ((DefaultTableCellRenderer) tablaUsuario.getDefaultRenderer(Object.class)).setOpaque(false);
        tablaUsuario.setForeground(Color.WHITE);
        tablaUsuario.getTableHeader().setOpaque(true);
        tablaUsuario.getTableHeader().setBackground(new Color(26, 0, 0));
        tablaUsuario.getTableHeader().setForeground(Color.white);
        tablaUsuario.setModel(modelo);
        tablaUsuario.setBackground(new Color(0,0,0,150));

        JScrollPane scroll = new JScrollPane(tablaUsuario);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBounds(4,45,967,415);
        this.add(scroll);
    }

    DAOUsuario daoUser = new DAOUsuarioImpl();
    public void mostrarDataPerson(){
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Ap. Paterno");
        modelo.addColumn("Ap. Materno");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Sexo");
        modelo.addColumn("Documento");
        modelo.addColumn("Direccion");
        modelo.addColumn("Celular");

        daoUser = new DAOUsuarioImpl();
        List<Usuario> lista = daoUser.listar(tfBuscarUser.getText());
        Object[]data =   new Object[9];
        for(int i = 0; i<lista.size(); i++) {
            data[0] = lista.get(i).getId_Persona();
            data[1] = lista.get(i).getNombres();
            data[2] = lista.get(i).getAp_Paterno();
            data[3] = lista.get(i).getAp_Materno();
            data[4] = lista.get(i).getFechaNacimiento();
            data[5] = lista.get(i).getSexo();
            data[6] = lista.get(i).getDocumento();
            data[7] = lista.get(i).getDireccion();
            data[8] = lista.get(i).getCelular();
            modelo.addRow(data);
        }
        tablaUsuario.setModel(modelo);
        tablaUsuario.getColumnModel().getColumn(0).setPreferredWidth(1);
        tablaUsuario.getColumnModel().getColumn(5).setPreferredWidth(15);
    }

    public void mostrarDataUser(){
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        modelo.addColumn("ID");
        modelo.addColumn("Usuario");
        modelo.addColumn("Clave");
        modelo.addColumn("Correo");
        modelo.addColumn("Cartera");
        modelo.addColumn("Tipo");
        modelo.addColumn("Estado");
        modelo.addColumn("Fecha Creacion");
        modelo.addColumn("ID Persona");

        daoUser = new DAOUsuarioImpl();
        List<Usuario> lista = daoUser.listar(tfBuscarUser.getText());
        Object[]data =   new Object[9];
        for(int i = 0; i<lista.size(); i++) {
            data[0] = lista.get(i).getId_Usuario();
            data[1] = lista.get(i).getNombre_Usuario();
            data[2] = lista.get(i).getClave_Usuario();
            data[3] = lista.get(i).getCorreo_Usuario();
            data[4] = lista.get(i).getCartera_Usuario();
            data[5] = lista.get(i).getTipo_Usuario();
            data[6] = lista.get(i).getEstado_Usuario();
            data[7] = lista.get(i).getFechaCreacion_Usuario();
            data[8] = lista.get(i).getId_PersonaFK();
            modelo.addRow(data);

        }
        tablaUsuario.setModel(modelo);
        tablaUsuario.getColumnModel().getColumn(0).setPreferredWidth(1);
        tablaUsuario.getColumnModel().getColumn(2).setPreferredWidth(150);
        tablaUsuario.getColumnModel().getColumn(4).setPreferredWidth(15);
        tablaUsuario.getColumnModel().getColumn(5).setPreferredWidth(15);
        tablaUsuario.getColumnModel().getColumn(6).setPreferredWidth(15);
        tablaUsuario.getColumnModel().getColumn(8).setPreferredWidth(30);

    }

    JButton btDataPerson = new JButton("Datos Personales");
    JButton btDataUser = new JButton("Datos de Usuario");
    JTextField tfBuscarUser = new JTextField();
    JLabel lbBusacarIco = new JLabel(new ImageIcon("imagenes/Admin/search.png"));
    public void utils (){
        btDataPerson.setBounds(15,7,135,25);
        btDataPerson.setBackground(new Color(20,0,0));
        //btDataPerson.setFocusable(false);
        btDataPerson.setEnabled(false);
        btDataPerson.addActionListener(this);
        this.add(btDataPerson);

        btDataUser.setBounds(160,7,135,25);
        btDataUser.setBackground(new Color(20,0,0));
        //btDataUser.setFocusable(false);
        btDataUser.addActionListener(this);
        this.add(btDataUser);

        tfBuscarUser.setBounds(400,7,160,25);
        tfBuscarUser.setOpaque(false);
        tfBuscarUser.setBorder(null);
        tfBuscarUser.setForeground(new Color(222,222,222));
        tfBuscarUser.setLayout(new BorderLayout());
        tfBuscarUser.add(lbBusacarIco, BorderLayout.EAST);
        tfBuscarUser.addKeyListener(this);
        this.add(tfBuscarUser);
        JSeparator spd1 = new JSeparator();
        spd1.setBounds(400,31,160,2);
        this.add(spd1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btDataPerson){
            mostrarDataPerson();
            btDataPerson.setEnabled(false);
            btDataUser.setEnabled(true);
        }

        if (e.getSource() == btDataUser){
            mostrarDataUser();
            btDataUser.setEnabled(false);
            btDataPerson.setEnabled(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == tfBuscarUser){
            daoUser = new DAOUsuarioImpl();
            List<Usuario> lista = daoUser.listar(tfBuscarUser.getText());
            Object[]data =   new Object[9];
            modelo.setRowCount(0);
            for(int i = 0; i<lista.size(); i++) {
                data[0] = lista.get(i).getId_Usuario();
                data[1] = lista.get(i).getNombre_Usuario();
                data[2] = lista.get(i).getClave_Usuario();
                data[3] = lista.get(i).getCorreo_Usuario();
                data[4] = lista.get(i).getCartera_Usuario();
                data[5] = lista.get(i).getTipo_Usuario();
                data[6] = lista.get(i).getEstado_Usuario();
                data[7] = lista.get(i).getFechaCreacion_Usuario();
                data[8] = lista.get(i).getId_PersonaFK();
                modelo.addRow(data);
            }

        }
    }
}
