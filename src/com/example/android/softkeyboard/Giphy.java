package com.example.android.softkeyboard;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;

public class Giphy {

	
    public static String getGif(String query) {
        String base_url = "http://api.giphy.com/v1/gifs/search?api_key=dc6zaTOxFJmzC&q=";
        try {
			query = URLEncoder.encode(query, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
        String request_url = base_url  + query;

        ServiceHandler http = new ServiceHandler();
        String json_object;
        json_object = http.makeCall(request_url, ServiceHandler.GET);
        String output_url = "No gifs found";
        try {
            JSONObject jsonObj = new JSONObject(json_object);
            JSONArray data = jsonObj.getJSONArray("data");
           int random = Bot.fishPlayRandom(0, data.length());
            JSONObject image = (JSONObject) data.get(random);
            output_url = image.getString("embed_url");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
        	return output_url;
        }
    }
}
