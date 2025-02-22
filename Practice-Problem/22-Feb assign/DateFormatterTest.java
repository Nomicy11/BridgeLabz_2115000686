import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {
    @Test
    void testValidDate() {
        assertEquals("25-12-2023", DateFormatter.formatDate("2023-12-25"));
    }

    @Test
    void testInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("2023/12/25"));
    }
}
