package com.example.android.softkeyboard;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.json.JSONObject;

import android.util.Log;

public class Bot {
	private String name;
	
	public Bot(String input_name){
		name = input_name;
		Log.w("fishPlayRandom", new Integer(fishPlayRandom(1, 2)).toString());
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
        	response = "animate me";
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
        	response = "weather me";
            break;
        case "finance me":
        	response = "finance me";
            break;
        case "search me":
        	response = "search me";
            break;
        case "inform me":
        	response = "inform me";
            break;
        case "shop me":
        	response = "shop me";
            break;
        case "clarify me":
        	response = "clarify me";
            break;
        case "define me":
        	response = "define me";
            break;
        case "reccomend me":
        	response = "reccomend me";
            break;
        case "schedule me":
        	response = "reccomend me";
            break;
        default:
            response = "Unknown request, please try again";
		}
		return response;
	}
	public String getName(){
		return name;
	}

	private static String shortenURL(String input_url){
		/**
		 * take in a url and shorten it using the bit.ly or google or whatever url shortening service
		 */
		String ouput_url= "";
		
		return ouput_url;
	}
	
	private static int fishPlayRandom(int min, int max){
		/**
		 * Query fishPlayPokemon api to get position, then normalize to some double on interval [0,1]
		 * multiply double by difference of the bounds and then add to the min for a random variable on 
		 * input interval
		 */
		ArrayList<JSONObject> json = new ArrayList<JSONObject>();
		try {
			json = Example.getRequest("http://api.fishplayspokemon.com/position");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		return 0;
	}
	
	
}
