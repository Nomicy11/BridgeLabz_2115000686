package Annotation;

class LegacyAPI {
    @Deprecated(since = "1.8", forRemoval = true)
    void oldFeature() {
        System.out.println("This is an old feature.");
    }

    void newFeature() {
        System.out.println("This is the new feature.");
    }
}

public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // Compiler warning
        api.newFeature();
    }
}

