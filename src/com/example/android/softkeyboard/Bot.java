package com.example.android.softkeyboard;

public class Bot {
	private String name;
	
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
		return 0;
	}
	
	
}
