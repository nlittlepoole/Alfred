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
