import java.util.regex.*;

public class CreditCardValidator {
    private static final String VISA_PATTERN = "^4\\d{15}$";
    private static final String MASTERCARD_PATTERN = "^5\\d{15}$";

    public static boolean isValidVisa(String card) {
        return Pattern.matches(VISA_PATTERN, card);
    }

    public static boolean isValidMasterCard(String card) {
        return Pattern.matches(MASTERCARD_PATTERN, card);
    }
}
