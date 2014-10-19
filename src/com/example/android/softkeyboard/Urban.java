package com.example.android.softkeyboard;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;

public class Urban {

	
    public static String define(String query) {
        String base_url = "http://api.urbandictionary.com/v0/define?term=";
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
        String output_url = "I don't know the definition";
        try {
            JSONObject jsonObj = new JSONObject(json_object);
            JSONArray data = jsonObj.getJSONArray("list");
           int random = Bot.fishPlayRandom(0, data.length());
            JSONObject definition = (JSONObject) data.get(random);
            output_url = definition.getString("definition");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
        	return output_url;
        }
    }
}
