import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class LinkExtractor {
    private static final String URL_PATTERN = "https?://[^\s]+";

    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        Matcher matcher = Pattern.compile(URL_PATTERN).matcher(text);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
}
