package com.example.android.softkeyboard;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

public class Foursquare {
	public static String getRecommendation(String query) {
		
		LocationManager lm = (LocationManager)LatinKeyboardView.mContext.getSystemService(LatinKeyboardView.mContext.LOCATION_SERVICE); 
		Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		double longitude = location.getLongitude();
		double latitude = location.getLatitude();
		
		String near = query.split(" near").length > 1 ?  query.split(" near")[1] : "";
		query = query.split(" near")[0];
		
		String base_url;

        try {
			query = URLEncoder.encode(query, "utf-8");
			near = URLEncoder.encode(near, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		if(near.length() < 1){
			base_url = "https://api.foursquare.com/v2/venues/explore?client_id=EUIPWB2WSI453AYFCIHJLLOSWDJB01QNHTXTKKQEWTMCU01F&client_secret=HHK0YNVVPCVY0HF1KNVPEE2MDLAZFNER0UADEISYU2LVUOV3&v=20130815&ll="+latitude+"," + longitude+ "&query=";
		}
		else{
			base_url = "https://api.foursquare.com/v2/venues/explore?client_id=EUIPWB2WSI453AYFCIHJLLOSWDJB01QNHTXTKKQEWTMCU01F&client_secret=HHK0YNVVPCVY0HF1KNVPEE2MDLAZFNER0UADEISYU2LVUOV3&v=20130815&near=" + near + "&query=";
		}
        
        String request_url = base_url  + query;
        
        ServiceHandler http = new ServiceHandler();
        String json_object;
        json_object = http.makeCall(request_url, ServiceHandler.GET);
        String output_url = "";
        try {
            JSONArray jsonObj = new JSONObject(json_object).getJSONObject("response").getJSONArray("groups");
            JSONArray data = jsonObj.getJSONObject(0).getJSONArray("items");
           int random = Bot.fishPlayRandom(0, data.length());
            JSONObject place = (JSONObject) data.get(random);
            output_url = place.getJSONObject("venue").getString("name") + "("+place.getJSONObject("venue").getString("url") + ")";
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
        	return output_url;
        }
    }
}
