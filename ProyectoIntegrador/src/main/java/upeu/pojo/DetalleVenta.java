package upeu.pojo;

public class DetalleVenta {

    private int id_DetalleV;
    private int cantidad_DetalleV;
    private double precioUnitario_DetalleV;
    private int descuento_DetalleV;
    private double precioTotal_DetalleV;
    private int id_ProductoFK;
    private int id_VentaFK;

    public int getId_DetalleV() {
        return id_DetalleV;
    }

    public void setId_DetalleV(int id_DetalleV) {
        this.id_DetalleV = id_DetalleV;
    }

    public int getCantidad_DetalleV() {
        return cantidad_DetalleV;
    }

    public void setCantidad_DetalleV(int cantidad_DetalleV) {
        this.cantidad_DetalleV = cantidad_DetalleV;
    }

    public double getPrecioUnitario_DetalleV() {
        return precioUnitario_DetalleV;
    }

    public void setPrecioUnitario_DetalleV(double precioUnitario_DetalleV) {
        this.precioUnitario_DetalleV = precioUnitario_DetalleV;
    }

    public int getDescuento_DetalleV() {
        return descuento_DetalleV;
    }

    public void setDescuento_DetalleV(int descuento_DetalleV) {
        this.descuento_DetalleV = descuento_DetalleV;
    }

    public double getPrecioTotal_DetalleV() {
        return precioTotal_DetalleV;
    }

    public void setPrecioTotal_DetalleV(double precioTotal_DetalleV) {
        this.precioTotal_DetalleV = precioTotal_DetalleV;
    }

    public int getId_ProductoFK() {
        return id_ProductoFK;
    }

    public void setId_ProductoFK(int id_ProductoFK) {
        this.id_ProductoFK = id_ProductoFK;
    }

    public int getId_VentaFK() {
        return id_VentaFK;
    }

    public void setId_VentaFK(int id_VentaFK) {
        this.id_VentaFK = id_VentaFK;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "id_DetalleV=" + id_DetalleV +
                ", cantidad_DetalleV=" + cantidad_DetalleV +
                ", precioUnitario_DetalleV=" + precioUnitario_DetalleV +
                ", descuento_DetalleV=" + descuento_DetalleV +
                ", precioTotal_DetalleV=" + precioTotal_DetalleV +
                ", id_ProductoFK=" + id_ProductoFK +
                ", id_VentaFK=" + id_VentaFK +
                '}';
    }
}
