package com.example.android.softkeyboard;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Example {
	public static ArrayList<JSONObject> getRequest(String url) throws FileNotFoundException{
		ServiceHandler http = new ServiceHandler();
		ArrayList<JSONObject> result = new ArrayList<JSONObject>();
		String json_object;
		json_object = http.makeCall(url, ServiceHandler.GET);
		try {
			JSONObject jsonObj = new JSONObject(json_object);
			JSONArray data = jsonObj.getJSONArray("data");
			for (int i = 0; i < data.length(); i++) {
				JSONObject c = data.getJSONObject(i);
				result.add(c);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
