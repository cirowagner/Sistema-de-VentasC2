package upeu.pojo;

public class Venta {

    private int id_Venta;
    private int numeroComprobante_Venta;
    private String fechaHora_Venta;
    private int estado_Venta;
    private double impuesto_Venta;
    private double totalTotales_Venta;
    private int id_UsuarioFK;
    private int id_DetalleVentaFK;

    public int getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(int id_Venta) {
        this.id_Venta = id_Venta;
    }

    public int getNumeroComprobante_Venta() {
        return numeroComprobante_Venta;
    }

    public void setNumeroComprobante_Venta(int numeroComprobante_Venta) {
        this.numeroComprobante_Venta = numeroComprobante_Venta;
    }

    public String getFechaHora_Venta() {
        return fechaHora_Venta;
    }

    public void setFechaHora_Venta(String fechaHora_Venta) {
        this.fechaHora_Venta = fechaHora_Venta;
    }

    public int getEstado_Venta() {
        return estado_Venta;
    }

    public void setEstado_Venta(int estado_Venta) {
        this.estado_Venta = estado_Venta;
    }

    public double getImpuesto_Venta() {
        return impuesto_Venta;
    }

    public void setImpuesto_Venta(double impuesto_Venta) {
        this.impuesto_Venta = impuesto_Venta;
    }

    public double getTotalTotales_Venta() {
        return totalTotales_Venta;
    }

    public void setTotalTotales_Venta(double totalTotales_Venta) {
        this.totalTotales_Venta = totalTotales_Venta;
    }

    public int getId_UsuarioFK() {
        return id_UsuarioFK;
    }

    public void setId_UsuarioFK(int id_UsuarioFK) {
        this.id_UsuarioFK = id_UsuarioFK;
    }

    public int getId_DetalleVentaFK() {
        return id_DetalleVentaFK;
    }

    public void setId_DetalleVentaFK(int id_DetalleVentaFK) {
        this.id_DetalleVentaFK = id_DetalleVentaFK;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id_Venta=" + id_Venta +
                ", numeroComprovante_Venta=" + numeroComprobante_Venta +
                ", fechaHora_Venta='" + fechaHora_Venta + '\'' +
                ", estado_Venta=" + estado_Venta +
                ", impuesto_Venta=" + impuesto_Venta +
                ", totalTotales_Venta=" + totalTotales_Venta +
                ", id_UsuarioFK=" + id_UsuarioFK +
                ", id_DetalleVentaFK=" + id_DetalleVentaFK +
                '}';
    }
}
