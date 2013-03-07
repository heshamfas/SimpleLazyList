
// Developed by Hesham Fas For Bottle Rocket Test

package com.BottleRocket.bottlerocktest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

// class responsible populating data models
public class DataController {
	String url;
	
	
	public DataController(String URL) {
		url = URL;
	}
	// Connecting to server and Parsing the Json String
	public String readJSONFeed() {
		StringBuilder stringBuilder = new StringBuilder();
		InputStream content;
		try {
			content = HttpAPI.HttpGet(url);
			if(content!=null){
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					content));
			String line;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				}// end while
			}//end if
			else{
				return null; // to provoc the dialog
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//Log.d("String Builder Result", "" + stringBuilder.toString());
		return stringBuilder.toString();
	}// end readJSONFeed
	

	public void populateStoreModels(String jsonResponse) {
		DataModelsHolder dmh = DataModelsHolder.getInstance();
		
		JSONObject jo = JsonAPI.getJsonObjectFromString(jsonResponse);
		
		JSONArray ja = JsonAPI.getJSONArray("stores", jo);
		int jsonArrayLength = ja.length();
		
		for (int i = 0; i < ja.length(); i++) {
			try {
				JSONObject jObject = (JSONObject) ja.get(i);
				StoreDataModel storeDataModel = new StoreDataModel();

				storeDataModel.storeName = jObject.getString("name");
				storeDataModel.storeAddress = jObject.getString("address");
				storeDataModel.storeCity = jObject.getString("city");
				storeDataModel.storeState = jObject.getString("state");
				storeDataModel.storeZip = jObject.getString("zipcode");
				storeDataModel.storePhone = jObject.getString("phone");
				storeDataModel.storeId = jObject.getString("storeID");
				storeDataModel.storeLatitude = jObject.getString("latitude");
				storeDataModel.storeLongitude = jObject.getString("latitude");
				storeDataModel.storeLogoURL = jObject.getString("storeLogoURL");
				storeDataModel.object_unique_id = i;
				dmh.addStoreDataModel(storeDataModel);
			
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
		}

	}
}
