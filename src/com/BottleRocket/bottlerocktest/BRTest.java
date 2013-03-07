// Developed by Hesham Fas For Bottle Rocket Test
package com.BottleRocket.bottlerocktest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BRTest extends Activity {
	String url = "http://strong-earth-32.heroku.com/stores.aspx";
	DataController dc = new DataController(url);
	DataModelsHolder dmh = DataModelsHolder.getInstance();
	TextView tv;
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_brtest);
		if(true){};
		lv = (ListView) findViewById(R.id.store_listView);
	
		if (dmh.getStoreList().size() == 0) {
			new ReadJSONFeedTask().execute(dc) ;
		} else {
			populateList();
		}

		// user clicks on the list
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent i = new Intent(getBaseContext(), StoreDetails.class);
				i.putExtra("position", position);
				startActivity(i);
			}
		});

	}

	private void populateList() {
		lv.setAdapter(new StoreListAdapter(this));
	}// end populateList

	// /////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////ASYNCTASC
	// AsyncTask inner Class to get JSON data from the web

	private class ReadJSONFeedTask extends
			AsyncTask<DataController, Void, String> {
		@Override
		protected String doInBackground(DataController... dataController) {

			return dataController[0].readJSONFeed();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			
			try {				
					if(!result.trim().isEmpty()){
						dc.populateStoreModels(result);	
						populateList();
						
						Toast.makeText(getBaseContext(), "" + dmh.getStoreList().size(), Toast.LENGTH_LONG).show();
					}					
				 else {
					showErrorDialog();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}// end class ReadJSONFeedTask

	public void showErrorDialog() {
		BTDialog dialogFragment = BTDialog
				.newInstance("Data Error has occured");
		dialogFragment.show(getFragmentManager(), "dialog");
	}
	public void doPositiveClick() {

	}
	public void doNegativeClick() {

	}

}
