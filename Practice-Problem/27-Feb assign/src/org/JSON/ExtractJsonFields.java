package org.JSON;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ExtractJsonFields {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("student.json"));
            System.out.println("Name: " + jsonNode.get("name").asText());
            System.out.println("Email: " + jsonNode.get("email").asText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
