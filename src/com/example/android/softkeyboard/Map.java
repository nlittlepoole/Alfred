package com.example.android.softkeyboard;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.location.Location;
import android.location.LocationManager;

public class Map {
	public static String pin() {

		LocationManager lm = (LocationManager)LatinKeyboardView.mContext.getSystemService(LatinKeyboardView.mContext.LOCATION_SERVICE); 
		Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		double longitude = location.getLongitude();
		double latitude = location.getLatitude();
		
        String base_url = "https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyBCXVXUOcD8eYWwijCmxdDhlf5qiRBOfdY&latlng=";
        String request_url = base_url  + latitude  + "," +  longitude;
        ServiceHandler http = new ServiceHandler();
        String json_object;
        json_object = http.makeCall(request_url, ServiceHandler.GET);
        String output_url = "";
        try {
            JSONObject jsonObj = new JSONObject(json_object);
            JSONArray data = jsonObj.getJSONArray("results");
            //int random = Bot.fishPlayRandom(0, data.length());
            JSONObject adress = (JSONObject) data.get(0);
            output_url = adress.getString("formatted_address");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            return output_url;
        }
    }
}
