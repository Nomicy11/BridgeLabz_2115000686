import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class DateExtractor {
    private static final String DATE_PATTERN = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Matcher matcher = Pattern.compile(DATE_PATTERN).matcher(text);
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }
}
