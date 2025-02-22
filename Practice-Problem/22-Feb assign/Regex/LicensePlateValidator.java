import java.util.regex.*;

public class LicensePlateValidator {
    private static final String LICENSE_PLATE_PATTERN = "^[A-Z]{2}\\d{4}$";

    public static boolean isValidLicensePlate(String plate) {
        return Pattern.matches(LICENSE_PLATE_PATTERN, plate);
    }
}
