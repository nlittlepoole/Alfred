package com.example.android.softkeyboard;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

public class Image {

	public static String getImage(String query){
		
		String result_url="";
		try{
			String url = "https://api.imgur.com/3/gallery/hot/viral/0";
	        URLConnection conn = new URL(url).openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                                    conn.getInputStream()));
	        String result = "";
	        String response;
	        while ((response = in.readLine()) != null){ 
	            result += response;
	        }
	        in.close();
	        String imgurURL = "http://www.imgur.com/";
	        JSONObject json = new JSONObject(result);
	        JSONArray array = json.getJSONArray("data");
	        for(int i = 0; i < array.length(); i++){
	        	JSONObject jsonobj = array.getJSONObject(i);
	        	Log.w("imgur", jsonobj.getString("title"));
	        	if(jsonobj.getString("title").contains(query)){
	        		result_url = imgurURL + jsonobj.getString("id");
	        		break;
	        	}
	        	
	        }
	     
		}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    finally{
	    	return result_url;
	    }
	    
	}
	
}
