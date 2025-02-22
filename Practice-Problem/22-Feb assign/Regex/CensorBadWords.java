import java.util.regex.*;

public class CensorBadWords {
    private static final String[] BAD_WORDS = {"damn", "stupid"};
    
    public static String censor(String text) {
        for (String word : BAD_WORDS) {
            text = text.replaceAll("(?i)" + word, "****");
        }
        return text;
    }
}
