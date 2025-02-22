import java.util.regex.*;

public class SSNValidator {
    private static final String SSN_PATTERN = "^\\d{3}-\\d{2}-\\d{4}$";

    public static boolean isValidSSN(String ssn) {
        return Pattern.matches(SSN_PATTERN, ssn);
    }
}
