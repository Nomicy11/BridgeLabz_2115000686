package org.JSON;


import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;

public class CsvToJson {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String headerLine = br.readLine();
            String[] headers = headerLine.split(",");

            JSONArray jsonArray = new JSONArray();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject obj = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], values[i]);
                }
                jsonArray.put(obj);
            }

            System.out.println(jsonArray.toString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
