package upeu.pojo;

public class Trabajador extends Persona{

    private int idt;
    private int pin;
    private String rol;
    private String user;
    private String password;
    private int idp_f;

    public int getIdt() {
        return idt;
    }

    public void setIdt(int idt) {
        this.idt = idt;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdp_f() {
        return idp_f+1;
    }

    public void setIdp_f(int idp_f) {
        this.idp_f = idp_f;
    }
}
