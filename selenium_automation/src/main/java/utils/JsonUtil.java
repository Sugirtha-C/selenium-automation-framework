package utils;

import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


/*
 * JsonUtil reads and processes test data from JSON files.
 * It allows fetching user data dynamically based on type,
 * enabling data-driven testing for different scenarios.
 */

public class JsonUtil {

    JSONObject data;

    public JsonUtil(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            JSONTokener tokener = new JSONTokener(reader);
            data = new JSONObject(tokener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject getUserByType(String type) {

        JSONArray users = data.getJSONArray("users");

        for (int i = 0; i < users.length(); i++) {

            JSONObject user = users.getJSONObject(i);

            if (user.getString("type").equalsIgnoreCase(type)) {
                return user;
            }
        }

        return null;
    }
}