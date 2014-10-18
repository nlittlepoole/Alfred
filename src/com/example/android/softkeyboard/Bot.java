package com.example.android.softkeyboard;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Bot {
	private String name;
	private static final String BITLY_API_TOKEN = "66691df0b4df6faffe0c35b3eac990dc5df44e30";

	public Bot(String input_name){
		name = input_name;
	}
	
	public String request(String input_request){
		String response;
		switch (input_request) {
        case "Monday":
        	response = "";
            break;
        case "Sunday":
        	response = "";
            break;
        default:
            response = "Unknown request, please try again";
		}
		return response;
	}
	public String getName(){
		return name;
	}

	public static String shortenURL(String input_url){
		/**
		 * Take in a url and shorten it using the bit.ly or google or whatever url shortening service
		 */
		String bitly_base = "http://api-ssl.bitly.com/v3/shorten?access_token=" + BITLY_API_TOKEN;
        String bitly_api_call = bitly_base + "longUrl=" + input_url;
        ServiceHandler http = new ServiceHandler();
        ArrayList<JSONObject> result = new ArrayList<JSONObject>();
        String json_object;
        json_object = http.makeCall(bitly_api_call, ServiceHandler.GET);
        String output_url = "";
        try {
            JSONObject jsonObj = new JSONObject(json_object);
            JSONObject data = jsonObj.getJSONObject("data");
            output_url = data.getString("url");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return output_url;
	}
	
	private static int fishPlayRandom(int min, int max){
		/**
		 * Query fishPlayPokemon api to get position, then normalize to some double on interval [0,1]
		 * multiply double by difference of the bounds and then add to the min for a random variable on 
		 * input interval
		 */
		return 0;
	}
	
	
}
