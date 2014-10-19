package com.example.android.softkeyboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Search {

	public static String getResult(String query){
		String result_url="";
		try{
			String url = "http://en.wikipedia.org/w/api.php?format=json&action=query&titles="
					+ query + "&rvprop=content";
	        URLConnection conn = new URL(url).openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                                    conn.getInputStream()));
	        String result = "";
	        String response;
	        while ((response = in.readLine()) != null){ 
	            result += response;
	        }
	        in.close();
	        
	        JSONObject json = new JSONObject(result);
	        String pageid = (String) json.getJSONObject("query")
	        		.getJSONObject("pages").keys().next();
	
	        result_url = "http://en.wikipedia.org/wiki?curid=" + pageid;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return result_url;
		}
	}
	
}
