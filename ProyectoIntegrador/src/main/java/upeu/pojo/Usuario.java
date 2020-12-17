package upeu.pojo;

public class Usuario extends Persona{

    private int id_Usuario;
    private String nombre_Usuario;
    private String clave_Usuario;
    private String correo_Usuario;
    private double cartera_Usuario;
    private String tipo_Usuario;
    private int estado_Usuario;
    private String fechaCreacion_Usuario;
    private int id_PersonaFK;

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public String getClave_Usuario() {
        return clave_Usuario;
    }

    public void setClave_Usuario(String clave_Usuario) {
        this.clave_Usuario = clave_Usuario;
    }

    public String getCorreo_Usuario() {
        return correo_Usuario;
    }

    public void setCorreo_Usuario(String correo_Usuario) {
        this.correo_Usuario = correo_Usuario;
    }

    public double getCartera_Usuario() {
        return cartera_Usuario;
    }

    public void setCartera_Usuario(double cartera_Usuario) {
        this.cartera_Usuario = cartera_Usuario;
    }

    public String getTipo_Usuario() {
        return tipo_Usuario;
    }

    public void setTipo_Usuario(String tipo_Usuario) {
        this.tipo_Usuario = tipo_Usuario;
    }

    public int getEstado_Usuario() {
        return estado_Usuario;
    }

    public void setEstado_Usuario(int estado_Usuario) {
        this.estado_Usuario = estado_Usuario;
    }

    public String getFechaCreacion_Usuario() {
        return fechaCreacion_Usuario;
    }

    public void setFechaCreacion_Usuario(String fechaCreacion_Usuario) {
        this.fechaCreacion_Usuario = fechaCreacion_Usuario;
    }

    public int getId_PersonaFK() {
        return id_PersonaFK;
    }

    public void setId_PersonaFK(int id_PersonaFK) {
        this.id_PersonaFK = id_PersonaFK;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_Usuario=" + id_Usuario +
                ", nombre_Usuario='" + nombre_Usuario + '\'' +
                ", clave_Usuario='" + clave_Usuario + '\'' +
                ", correo_Usuario='" + correo_Usuario + '\'' +
                ", cartera_Usuario=" + cartera_Usuario +
                ", tipo_Usuario='" + tipo_Usuario + '\'' +
                ", estado_Usuario=" + estado_Usuario +
                ", fechaCreacion_Usuario='" + fechaCreacion_Usuario + '\'' +
                ", id_PersonaFK=" + id_PersonaFK +
                '}';
    }
}
