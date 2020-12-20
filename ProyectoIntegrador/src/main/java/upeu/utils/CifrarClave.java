package upeu.utils;

import java.util.Base64;
import java.security.MessageDigest;

public class CifrarClave {
    String base64;
    public String cifrado(String clave){
        try {
          /*MessageDigest almacen = MessageDigest.getInstance("MD5");
            byte[] cifradoByte = almacen.digest(clave.getBytes());*/
            base64 = Base64.getEncoder().encodeToString(clave.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return base64;
    }

    String decifrado;
    public String decifrar (String clave){
        try {
            byte[] decifradoByte = Base64.getDecoder().decode(clave);
            decifrado = new String(decifradoByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decifrado;
    }
}
