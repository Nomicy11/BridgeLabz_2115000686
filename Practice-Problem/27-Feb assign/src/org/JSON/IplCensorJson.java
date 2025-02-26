package org.JSON;


import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IplCensorJson {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("ipl.json")));
            JSONArray matches = new JSONArray(content);

            for (int i = 0; i < matches.length(); i++) {
                JSONObject match = matches.getJSONObject(i);
                match.put("team1", match.getString("team1").replaceAll(" ([A-Za-z]+)$", " ***"));
                match.put("team2", match.getString("team2").replaceAll(" ([A-Za-z]+)$", " ***"));
                match.put("player_of_match", "REDACTED");
            }

            System.out.println(matches.toString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
