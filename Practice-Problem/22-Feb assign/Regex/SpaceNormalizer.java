public class SpaceNormalizer {
    public static String normalizeSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }
}
