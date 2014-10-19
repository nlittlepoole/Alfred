package com.example.android.softkeyboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class Answer {

	public static String getResult(String query) throws IOException{
		String url = "http://http://api.wolframalpha.com/v2/query?input="
				+ query + "&appid=7Q9YPX-3EX95TKLJR";
        URLConnection conn = new URL(url).openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    conn.getInputStream()));
        String result = "";
        String response;
        while ((response = in.readLine()) != null){ 
            result += response;
        }
        in.close();
        
        
        return null;
	}
	
}
