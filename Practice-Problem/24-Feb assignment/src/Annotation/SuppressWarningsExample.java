package Annotation;

import java.util.ArrayList;
import java.util.List;

public class SuppressWarningsExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List myList = new ArrayList(); // No generics
        myList.add("Hello");
        myList.add(100);
        System.out.println(myList);
    }
}

