package com.example.android.softkeyboard;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NYTimes {

    private final String API_KEY = "4ad554f8aa8c4626d8b260745f101857:10:70023015";

    public String getArticle(String query) {

        String base_url = "http://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=" + API_KEY + "&";
        String request_url = base_url + "q=" + query;

        ServiceHandler http = new ServiceHandler();
        ArrayList<JSONObject> result = new ArrayList<JSONObject>();
        String json_object;
        json_object = http.makeCall(request_url, ServiceHandler.GET);
        try {
            JSONObject jsonObj = new JSONObject(json_object);
            JSONArray data = jsonObj.getJSONObject("response").getJSONArray("docs");
            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);
                result.add(c);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String output_url;
        return "";
    }

}
