import java.util.Base64;

public class EncryptDecryptUtil {
    public static String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static String decrypt(String encryptedData) {
        return new String(Base64.getDecoder().decode(encryptedData));
    }
}
