// Developed by Hesham Fas For Bottle Rocket Test

package com.BottleRocket.bottlerocktest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonAPI {

	public static JSONObject getJsonObjectFromString(String jsonString){
		
		JSONObject json = null;
		
		try {
			 json = new JSONObject(jsonString);
			
		} catch (JSONException e) {
		
			e.printStackTrace();
		}

		return json;
	}
	
	public static JSONArray getJSONArray(String key, JSONObject jo){
		JSONArray ja = new JSONArray();
		try {
		 ja = jo.getJSONArray(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return ja;
	}
	
 public static JSONObject getJSONObjectFromJsonArray(JSONArray ja, int position){
	 JSONObject jo = new JSONObject();
	 try {
		jo = ja.getJSONObject(position);
	} catch (JSONException e) {
		
		e.printStackTrace();
	}
	 return jo;
 }
}
