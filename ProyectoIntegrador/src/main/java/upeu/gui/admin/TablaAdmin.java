package upeu.gui.admin;

import upeu.dao.DAOProductoImpl;
import upeu.interfaces.DAOProducto;
import upeu.pojo.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TablaAdmin {
    DAOProducto dao = new DAOProductoImpl();
    DefaultTableModel modelo = new DefaultTableModel();

    public void mostrarTabla (JTable tabla){

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Estado");
        modelo.addColumn("Stock Inicial");
        modelo.addColumn("Stock Actual");
        modelo.addColumn("ID Categoria");

        JButton bt1 = new JButton("1");

        modelo  = (DefaultTableModel) tabla.getModel();
        List<Producto> lista = dao.listar();
        for(int i = 0; i<lista.size(); i++) {
            Object data[]= new Object[8];
            data[0] = lista.get(i).getId_Producto();
            data[1] = lista.get(i).getNombre_Producto();
            data[2] = lista.get(i).getPrecio_Producto();
            data[3] = lista.get(i).getEstado_Producto();
            data[4] = lista.get(i).getStockInicial_Producto();
            data[5] = lista.get(i).getStockActual_Producto();
            data[6] = lista.get(i).getID_CategoriaFK();
            data[7] = bt1;
            modelo.addRow(data);
            System.out.println("Datos: "+data[i]);
        }
        tabla.setModel(modelo);
    }
}
