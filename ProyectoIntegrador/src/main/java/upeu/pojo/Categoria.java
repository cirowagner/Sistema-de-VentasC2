package upeu.pojo;

public class Categoria {
    private int id_Categoria;
    private String nombre_Categoria;
    private String codigo_Categoria;

    public int getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

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

    @Override
    public String toString() {
        return "Categoria{" +
                "id_Categoria=" + id_Categoria +
                ", nombre_Categoria='" + nombre_Categoria + '\'' +
                ", codigo_Categoria='" + codigo_Categoria + '\'' +
                '}';
    }
}
