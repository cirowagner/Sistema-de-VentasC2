package upeu.pojo;

public class Producto extends Categoria{

    private int ID_Prod ;
    private String NOMBRE_Prod ;
    private String TIPO_Prod ;
    private double PRECIO_Prod ;
    private String STOCK_Prod ;
    private String CONTROL_Stock ;
    private int IDC_F ;

    public int getID_Prod() {
        return ID_Prod;
    }

    public void setID_Prod(int ID_Prod) {
        this.ID_Prod = ID_Prod;
    }

    public String getNOMBRE_Prod() {
        return NOMBRE_Prod;
    }

    public void setNOMBRE_Prod(String NOMBRE_Prod) {
        this.NOMBRE_Prod = NOMBRE_Prod;
    }

    public String getTIPO_Prod() {
        return TIPO_Prod;
    }

    public void setTIPO_Prod(String TIPO_Prod) {
        this.TIPO_Prod = TIPO_Prod;
    }

    public Double getPRECIO_Prod() {
        return PRECIO_Prod;
    }

    public void setPRECIO_Prod(Double PRECIO_Prod) {
        this.PRECIO_Prod = PRECIO_Prod;
    }

    public String getSTOCK_Prod() {
        return STOCK_Prod;
    }

    public void setSTOCK_Prod(String STOCK_Prod) {
        this.STOCK_Prod = STOCK_Prod;
    }

    public String getCONTROL_Stock() {
        return CONTROL_Stock;
    }

    public void setCONTROL_Stock(String CONTROL_Stock) {
        this.CONTROL_Stock = CONTROL_Stock;
    }

    public int getIDC_F() {
        return IDC_F;
    }

    public void setIDC_F(int IDC_F) {
        this.IDC_F = IDC_F;
    }
}
