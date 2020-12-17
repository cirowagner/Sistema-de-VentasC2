package upeu.gui.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuariosPanel extends JPanel implements ActionListener {

    public UsuariosPanel(){
        setVisible(true);
        setBounds(7,15,972, 465);
        setOpaque(false);
        setLayout(null);
        initComponents();
    }

    public void initComponents(){
        vistaTablaDatosPerson();
    }

    JTable tablausuario = new JTable();
    DefaultTableModel modelo = new DefaultTableModel(new Object[][]{{}},new String[]{"Nombres", "Ap. Paterno", "Ap. Materno", "Fecha Nacimiento", "Sexo", "Documento", "Dirección", "Celular"});
    public void vistaTablaDatosPerson(){
        ((DefaultTableCellRenderer) tablausuario.getDefaultRenderer(Object.class)).setOpaque(false);
        tablausuario.setForeground(Color.WHITE);
        tablausuario.getTableHeader().setOpaque(true);
        tablausuario.getTableHeader().setBackground(new Color(26, 0, 0));
        tablausuario.getTableHeader().setForeground(Color.white);
        tablausuario.setModel(modelo);
        tablausuario.setBackground(new Color(0,0,0,150));

        JScrollPane scroll = new JScrollPane(tablausuario);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBounds(4,45,967,415);
        this.add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
