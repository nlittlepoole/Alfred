package com.example.android.softkeyboard;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import java.net.*;
import java.io.*;

public class Bot {
	private String name;

	private static final String BITLY_API_TOKEN = "66691df0b4df6faffe0c35b3eac990dc5df44e30";

	public Bot(String input_name){
		name = input_name;
//		Log.w("fishPlayRandom", new Integer(fishPlayRandom(1, 2)).toString());
		Log.w("urlShortener", shortenURL("http://google.com"));
		Log.w("nytimes", NYTimes.getArticle("ebola"));
	}
	
	public String request(String input_request){
		int split =  input_request.indexOf(" me ") > 0? (input_request.indexOf(" me ") + 4) : 0;
		String action = input_request.substring(0,split).toLowerCase().trim();
		String params = input_request.substring(split).toLowerCase().trim();
		Log.w("Routing", action);
		String response;
		switch (action) {
        case "show me":
        	
        	response = "show me";
            break;
        case "animate me":
        	String gif_url = Giphy.getGif(params);
        	response = !gif_url.equals("")? "Alfred: Here's your Gif " + Bot.shortenURL(gif_url) : "Alfred: I can't find a gif";
            break;
        case "calculate me":
        	response = "calculate me";
            break;
        case "answer me":
        	response = "answer me";
            break;
        case "tell me":
        	response = "tell me";
            break;
        case "direct me":
        	response = "direct me";
        	break;
        case "weather me":
        	String weather =  Weather.getWeather();
        	response = weather.length()>0 ?"Alfred: " + weather : "Alfred: I don't know the weather at your location";

            break;
        case "finance me":
        	response = "finance me";
            break;
        case "search me":
        	response = "search me";
            break;
        case "inform me":
        	String article_url = NYTimes.getArticle(params);
        	response = !article_url.equals("") ? "Alfred: Here's your NYTimes article: " + Bot.shortenURL(article_url) : "Alfred: I don't have any info on this";
            break;
        case "shop me":
        	response = "shop me";
            break;
        case "clarify me":
        	response = "clarify me";
            break;
        case "define me":
        	response =  "Alfred: " +Urban.define(params);
            break;
        case "reccomend me":
        	response = "reccomend me";
            break;
        case "schedule me":
        	response = "schedule me";
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
		String bitly_base = "https://api-ssl.bitly.com/v3/shorten?access_token=" + BITLY_API_TOKEN + "&";
        String bitly_api_call = bitly_base + "longUrl=" + input_url;
        ServiceHandler http = new ServiceHandler();
        Log.w("urlShortener", "in shortenURL");
//        ArrayList<JSONObject> result = new ArrayList<JSONObject>();
        String json_object;
        json_object = http.makeCall(bitly_api_call, ServiceHandler.GET);
        Log.w("urlShortener", json_object);

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
	
	public static int fishPlayRandom(int min, int max) throws Exception{
		/**
		 * Query fishPlayPokemon api to get position, then normalize to some double on interval [0,1]
		 * multiply double by difference of the bounds and then add to the min for a random variable on 
		 * input interval
		 */
		URL url = new URL("http://api.fishplayspokemon.com/position");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));
        String jsonString = in.readLine();
        in.close();
        jsonString.replaceAll("\n","\\n");
        JSONObject json = new JSONObject(jsonString);
        double x = json.getDouble("x");
        double y = json.getDouble("y");
        double value = 1 - Math.exp(-Math.abs((x/(x+y)-y/(x+y))));
        int index = (int) ((max - min) * value) + min;
        if(index == max)
        	index = max - 1;
        
		return index;
	}
	
	
}
