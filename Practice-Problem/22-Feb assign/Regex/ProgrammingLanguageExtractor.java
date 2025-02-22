import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class ProgrammingLanguageExtractor {
    private static final String LANGUAGE_PATTERN = "\\b(Java|Python|JavaScript|Go)\\b";

    public static List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        Matcher matcher = Pattern.compile(LANGUAGE_PATTERN).matcher(text);
        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }
}
