package com.example.android.softkeyboard;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
	public static String direct(String query) {

		LocationManager lm = (LocationManager)LatinKeyboardView.mContext.getSystemService(LatinKeyboardView.mContext.LOCATION_SERVICE); 
		Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		double longitude = location.getLongitude();
		double latitude = location.getLatitude();
		
        String base_url = "https://maps.googleapis.com/maps/api/directions/json?key=AIzaSyBCXVXUOcD8eYWwijCmxdDhlf5qiRBOfdY&origin="+ latitude  + "," +  longitude;
        
        //query = query.replace(" to "," ");
        String mode = query.split(" by ").length > 1 ?  query.split(" by ")[1] : "";
		query = query.split(" by ")[0];
        try {
			query = URLEncoder.encode(query, "utf-8");
			mode = URLEncoder.encode(mode, "utf-8").replace("train", "transit").replace("train", "transit").replace("car", "driving").replace("bike", "bicycling").replace("walk", "walking").replace("foot", "walking").replace("bicycle", "bicycling");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		String request_url; 
		mode = mode.equals("transit") ? mode + "&departure_time=" + String.valueOf(System.currentTimeMillis() / 1000L) : mode;
		if(mode.length() < 1){
			request_url = base_url + "&destination="+ query  ;
		}
		else{
			request_url = base_url + "&destination="+ query + "&mode="+mode  ;
			}
		
        
        ServiceHandler http = new ServiceHandler();
        String json_object;
        json_object = http.makeCall(request_url, ServiceHandler.GET);
        String output_url = "";
        try {
            JSONObject jsonObj = new JSONObject(json_object);
            JSONArray data = jsonObj.getJSONArray("routes");
            //int random = Bot.fishPlayRandom(0, data.length());
            data = data.getJSONObject(0).getJSONArray("legs");
            JSONObject route = data.getJSONObject(0);
            output_url = "\n ETA: " + route.getJSONObject("duration").getString("text");
            JSONArray steps = route.getJSONArray("steps");
            for (int i = 0; i < steps.length(); i++) {
            	  String step = steps.getJSONObject(i).getString("html_instructions");
            	  output_url = output_url + "\n"+i+ ". " + URLDecoder.decode(step, "ISO-8859-1");
            	}
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            return output_url;
        }
    }
}
