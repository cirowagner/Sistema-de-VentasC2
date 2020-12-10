package upeu.pojo;

public class Persona {
    private int id_Persona;
    private String nombres;
    private String ap_Paterno;
    private String ap_Materno;
    private String fechaNacimiento;
    private String sexo;
    private String documento;
    private String direccion;
    private int celular;

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getAp_Paterno() {
        return ap_Paterno;
    }

    public void setAp_Paterno(String ap_Paterno) {
        this.ap_Paterno = ap_Paterno;
    }

    public String getAp_Materno() {
        return ap_Materno;
    }

    public void setAp_Materno(String ap_Materno) {
        this.ap_Materno = ap_Materno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id_Persona=" + id_Persona +
                ", nombres='" + nombres + '\'' +
                ", ap_Paterno='" + ap_Paterno + '\'' +
                ", ap_Materno='" + ap_Materno + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", sexo='" + sexo + '\'' +
                ", documento='" + documento + '\'' +
                ", direccion='" + direccion + '\'' +
                ", celular=" + celular +
                '}';
    }
}
