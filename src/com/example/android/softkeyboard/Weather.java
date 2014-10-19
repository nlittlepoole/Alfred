package com.example.android.softkeyboard;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.location.Location;
import android.location.LocationManager;

public class Weather {
	public static String getWeather() {
		
		LocationManager lm = (LocationManager)LatinKeyboardView.mContext.getSystemService(LatinKeyboardView.mContext.LOCATION_SERVICE); 
		Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		double longitude = location.getLongitude();
		double latitude = location.getLatitude();
		
        String base_url = "https://api.forecast.io/forecast/f2276d56f2a767b79562447e18c5667c/";

        String request_url = base_url  +latitude  + "," +  longitude;

        ServiceHandler http = new ServiceHandler();
        String json_object;
        json_object = http.makeCall(request_url, ServiceHandler.GET);
        String output_url = "";
        try {
            JSONObject jsonObj = new JSONObject(json_object);
            JSONObject data =(JSONObject) jsonObj.get("currently");
            output_url = "Temperature: "+ data.getString("temperature") + "\n" + "Conditions: "+ data.getString("summary") ;
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
        	return output_url;
        }
    }
}
