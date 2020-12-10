package upeu.pojo;

import java.util.Arrays;

public class Producto extends Categoria{

    private int id_Producto;
    private String nombre_Producto;
    private byte[] imagen_Producto;
    private double precio_Producto;
    private int estado_Producto;
    private int StockInicial_Producto;
    private int StockActual_Producto;
    private int ID_CategoriaFK;

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getNombre_Producto() {
        return nombre_Producto;
    }

    public void setNombre_Producto(String nombre_Producto) {
        this.nombre_Producto = nombre_Producto;
    }

    public byte[] getImagen_Producto() {
        return imagen_Producto;
    }

    public void setImagen_Producto(byte[] imagen_Producto) {
        this.imagen_Producto = imagen_Producto;
    }

    public double getPrecio_Producto() {
        return precio_Producto;
    }

    public void setPrecio_Producto(double precio_Producto) {
        this.precio_Producto = precio_Producto;
    }

    public int getEstado_Producto() {
        return estado_Producto;
    }

    public void setEstado_Producto(int estado_Producto) {
        this.estado_Producto = estado_Producto;
    }

    public int getStockInicial_Producto() {
        return StockInicial_Producto;
    }

    public void setStockInicial_Producto(int stockInicial_Producto) {
        StockInicial_Producto = stockInicial_Producto;
    }

    public int getStockActual_Producto() {
        return StockActual_Producto;
    }

    public void setStockActual_Producto(int stockActual_Producto) {
        StockActual_Producto = stockActual_Producto;
    }

    public int getID_CategoriaFK() {
        return ID_CategoriaFK;
    }

    public void setID_CategoriaFK(int ID_CategoriaFK) {
        this.ID_CategoriaFK = ID_CategoriaFK;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id_Producto=" + id_Producto +
                ", nombre_Producto='" + nombre_Producto + '\'' +
                ", imagen_Producto=" + Arrays.toString(imagen_Producto) +
                ", precio_Producto=" + precio_Producto +
                ", estado_Producto=" + estado_Producto +
                ", StockInicial_Producto=" + StockInicial_Producto +
                ", StockActual_Producto=" + StockActual_Producto +
                ", ID_CategoriaFK=" + ID_CategoriaFK +
                '}';
    }
}
