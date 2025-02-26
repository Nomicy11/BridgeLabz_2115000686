package org.JSON;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJson {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "Nomicy Gupta");
        student.put("age", 22);

        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Science");
        subjects.put("English");

        student.put("subjects", subjects);

        System.out.println(student.toString(4));
    }
}
