package upeu.utils;

import java.util.Base64;
import java.security.MessageDigest;

public class CifrarClave {
    String base64;
    public String md5 (String clave){
        try {
            MessageDigest almacen = MessageDigest.getInstance("MD5");
            byte[] cifrado = almacen.digest(clave.getBytes());
            base64 = Base64.getEncoder().encodeToString(cifrado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return base64;
    }
}
