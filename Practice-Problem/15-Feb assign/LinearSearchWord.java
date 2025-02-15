public class LinearSearchWord {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence; 
            }
        }
        return "Not Found"; 
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "A journey of a thousand miles begins with a single step.",
            "To be or not to be, that is the question.",
            "Success is not final, failure is not fatal.",
            "Keep pushing forward no matter what."
        };

        String wordToFind = "success"; // Word to search for
        String result = findSentenceWithWord(sentences, wordToFind);

        System.out.println("Result: " + result);
    }
}
