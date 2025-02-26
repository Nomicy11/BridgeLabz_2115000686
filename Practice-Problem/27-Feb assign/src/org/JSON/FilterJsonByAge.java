package org.JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;

public class FilterJsonByAge {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(new File("users.json"));

            for (JsonNode user : root) {
                if (user.get("age").asInt() > 25) {
                    System.out.println(user.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
