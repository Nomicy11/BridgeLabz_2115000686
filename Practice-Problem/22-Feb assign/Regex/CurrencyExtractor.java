import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyExtractor {
    private static final String CURRENCY_PATTERN = "\\$?\\b\\d+\\.\\d{2}\\b";

    public static List<String> extractCurrencyValues(String text) {
        List<String> values = new ArrayList<>();
        Matcher matcher = Pattern.compile(CURRENCY_PATTERN).matcher(text);
        while (matcher.find()) {
            values.add(matcher.group());
        }
        return values;
    }
}