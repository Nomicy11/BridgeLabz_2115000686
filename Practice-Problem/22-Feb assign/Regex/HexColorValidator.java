import java.util.regex.*;

public class HexColorValidator {
    private static final String HEX_COLOR_PATTERN = "^#([A-Fa-f0-9]{6})$";

    public static boolean isValidHexColor(String color) {
        return Pattern.matches(HEX_COLOR_PATTERN, color);
    }
}
