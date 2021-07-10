package Classes;
import com.mysql.cj.protocol.Message;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Properties;

public class encryption {

    public String encryptPass(String pass){
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(pass.getBytes());
            byte[] byteArray=messageDigest.digest();
            StringBuilder sb =new StringBuilder();
            for(byte b: byteArray){
                sb.append(String.format("%02x",b));

            }
            return sb.toString();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "";

    }


}
