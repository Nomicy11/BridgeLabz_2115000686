import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsernameValidatorTest {
    @Test
    void testValidUsernames() {
        assertTrue(UsernameValidator.isValidUsername("user_123"));
        assertTrue(UsernameValidator.isValidUsername("JohnDoe99"));
    }

    @Test
    void testInvalidUsernames() {
        assertFalse(UsernameValidator.isValidUsername("123user")); // Starts with number
        assertFalse(UsernameValidator.isValidUsername("us"));      // Too short
    }
}
