package org.JSON;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class ValidateJsonEmail {
    public static void main(String[] args) {
        try {
            // Load JSON Schema
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode schemaNode = objectMapper.readTree(new File("email-schema.json"));
            JsonSchema schema = JsonSchemaFactory.getInstance().getSchema(schemaNode);

            // Load JSON Data
            JsonNode jsonData = objectMapper.readTree(new File("user.json"));

            // Validate JSON
            Set<ValidationMessage> errors = schema.validate(jsonData);
            if (errors.isEmpty()) {
                System.out.println(" JSON is valid!");
            } else {
                System.out.println("JSON Validation Errors:");
                for (ValidationMessage error : errors) {
                    System.out.println(error.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
