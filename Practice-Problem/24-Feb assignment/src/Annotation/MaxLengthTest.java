package Annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        if (username.length() > 10) {
            throw new IllegalArgumentException("Username exceeds max length!");
        }
        this.username = username;
    }
}

public class MaxLengthTest {
    public static void main(String[] args) {
        try {
            User user = new User("VeryLongUsername"); // This should throw an exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

