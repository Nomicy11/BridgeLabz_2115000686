package org.JSON;


import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ReadJsonKeysValues {
    public static void main(String[] args) {
        try {
            // Read JSON file
            String content = new String(Files.readAllBytes(Paths.get("data.json")));
            JSONObject jsonObject = new JSONObject(content);

            // Print all keys and values
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                System.out.println(key + " : " + jsonObject.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
