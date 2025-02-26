package org.JSON;


import org.json.JSONObject;
import org.json.XML;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToXml {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("data.json")));
            JSONObject jsonObject = new JSONObject(content);

            String xml = XML.toString(jsonObject);
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
