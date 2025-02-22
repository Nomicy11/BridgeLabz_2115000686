import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class CapitalizedWordExtractor {
    private static final String CAPITALIZED_WORD_PATTERN = "\\b[A-Z][a-z]+\\b";

    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        Matcher matcher = Pattern.compile(CAPITALIZED_WORD_PATTERN).matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }
}
