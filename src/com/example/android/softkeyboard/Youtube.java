package com.example.android.softkeyboard;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Youtube {
	public static String getVideo(String query) {

        String base_url = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&videoCategoryId=10&key=AIzaSyBCXVXUOcD8eYWwijCmxdDhlf5qiRBOfdY&q=";
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
        String output_url = "";
        try {
            JSONObject jsonObj = new JSONObject(json_object);
            JSONArray data = jsonObj.getJSONArray("items");
            //int random = Bot.fishPlayRandom(0, data.length());
            JSONObject video = (JSONObject) data.get(0);
            output_url = video.getJSONObject("id").getString("videoId");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            return output_url;
        }
    }
}
