public class UserRegistration {
    public static void registerUser(String username, String email, String password) {
        if (username.isEmpty() || !email.contains("@") || password.length() < 8) {
            throw new IllegalArgumentException("Invalid registration details");
        }
    }
}
