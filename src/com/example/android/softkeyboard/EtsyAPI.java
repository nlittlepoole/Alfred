package com.example.android.softkeyboard;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class EtsyAPI {

    private static final String API_KEY = "b5sszih25m5mdbfsf0p100r2";

    public static String getListing(String keyword) {
        try {
            keyword = URLEncoder.encode(keyword, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String base_url = "https://openapi.etsy.com/v2/listings/active.json?api_key=" + API_KEY;
        String request_url = base_url + "&keywords=" + keyword;

        ServiceHandler http = new ServiceHandler();
        String json_object;
        json_object = http.makeCall(request_url, ServiceHandler.GET);
        String output_url = "";
        Log.w("etsy", json_object.toString());
        try {
            JSONObject jsonObj = new JSONObject(json_object);
            Log.w("etsy", jsonObj.toString());
            JSONArray data = jsonObj.getJSONArray("results");
            JSONObject listing = (JSONObject) data.get(0);
            output_url = listing.getString("url");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return output_url;
        }
    }

}
