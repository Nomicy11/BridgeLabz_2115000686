import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class RepeatingWordExtractor {
    private static final String REPEATING_WORD_PATTERN = "\\b(\\w+)\\s+\\1\\b";

    public static List<String> extractRepeatingWords(String text) {
        List<String> words = new ArrayList<>();
        Matcher matcher = Pattern.compile(REPEATING_WORD_PATTERN, Pattern.CASE_INSENSITIVE).matcher(text);
        while (matcher.find()) {
            words.add(matcher.group(1));
        }
        return words;
    }
}
