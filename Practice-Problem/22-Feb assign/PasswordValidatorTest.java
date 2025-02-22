import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Strong1Password"));
    }

    @Test
    void testInvalidPasswordShort() {
        assertFalse(PasswordValidator.isValid("Short1"));
    }

    @Test
    void testInvalidPasswordNoUppercase() {
        assertFalse(PasswordValidator.isValid("weakpassword1"));
    }

    @Test
    void testInvalidPasswordNoDigit() {
        assertFalse(PasswordValidator.isValid("WeakPassword"));
    }
}
