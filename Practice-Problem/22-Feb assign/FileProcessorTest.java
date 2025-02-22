import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {
    @Test
    void testFileOperations() throws IOException {
        String filename = "test.txt";
        String content = "Hello, World!";
        
        FileProcessor.writeToFile(filename, content);
        assertEquals(content, FileProcessor.readFromFile(filename));
    }
}
