package upeu.pojo;

public class Categoria {

    private String nombre_Categoria;
    private String codigo_Categoria;
    private int estado_Categoria;

    public String getNombre_Categoria() {
        return nombre_Categoria;
    }

    public void setNombre_Categoria(String nombre_Categoria) {
        this.nombre_Categoria = nombre_Categoria;
    }

    public String getCodigo_Categoria() {
        return codigo_Categoria;
    }

    public void setCodigo_Categoria(String codigo_Categoria) {
        this.codigo_Categoria = codigo_Categoria;
    }

    public int getEstado_Categoria() {
        return estado_Categoria;
    }

    public void setEstado_Categoria(int estado_Categoria) {
        this.estado_Categoria = estado_Categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nombre_Categoria='" + nombre_Categoria + '\'' +
                ", codigo_Categoria='" + codigo_Categoria + '\'' +
                ", estado_Categoria=" + estado_Categoria +
                '}';
    }
}
