package com.example.android.softkeyboard;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NYTimes {

    private static final String API_KEY = "4ad554f8aa8c4626d8b260745f101857:10:70023015";

    public static String getArticle(String query) {
        String base_url = "http://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=" + API_KEY + "&";
        String request_url = base_url + "q=" + query;

        ServiceHandler http = new ServiceHandler();
        String json_object;
        json_object = http.makeCall(request_url, ServiceHandler.GET);
        String output_url = "";
        try {
            JSONObject jsonObj = new JSONObject(json_object);
            JSONArray data = jsonObj.getJSONObject("response").getJSONArray("docs");
//            int random = Bot.fishPlayRandom(0, 5);
            JSONObject page = (JSONObject) data.get(0);
            output_url = page.getString("web_url");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return output_url;
    }

}
