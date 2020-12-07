package upeu.pojo;

public class Cliente extends Persona{

    private int idc;
    private String codC;
    private String tipoC;
    private int estado_Cliente;
    private int idp_F;

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getCodC() {
        return codC;
    }

    public void setCodC(String codC) {
        this.codC = codC;
    }

    public String getTipoC() {
        return tipoC;
    }

    public void setTipoC(String tipoC) {
        this.tipoC = tipoC;
    }

    public int getEstado_Cliente() {
        return estado_Cliente;
    }

    public void setEstado_Cliente(int estado_Cliente) {
        this.estado_Cliente = estado_Cliente;
    }

    public int getIdp_F() {
        return idp_F;
    }

    public void setIdp_F(int idp_F) {
        this.idp_F = idp_F;
    }
}
