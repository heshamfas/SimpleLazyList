// Developed by Hesham Fas For Bottle Rocket Test

package com.BottleRocket.bottlerocktest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StoreDetails extends Activity {
	DataModelsHolder dmh = DataModelsHolder.getInstance();
	StoreDataModel sdm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store_details);
		Intent i = this.getIntent();
		int position = i.getIntExtra("position", 0);
		sdm = dmh.getStoreList().get(position);
		
		fillViews();		
	}
	private void fillViews(){
		TextView tv_storeName = (TextView) findViewById(R.id.tv_storeName);
		tv_storeName.setText(sdm.storeName);
		TextView tv_storeId= (TextView) findViewById(R.id.tv_storeId);
		tv_storeId.setText(sdm.storeId);
		TextView tv_storeAddress = (TextView) findViewById(R.id.tv_storeAddress);
		tv_storeAddress.setText(sdm.storeAddress);
		TextView tv_storeCity = (TextView) findViewById(R.id.tv_storeCity);
		tv_storeCity.setText(sdm.storeCity);
		TextView tv_storeState = (TextView) findViewById(R.id.tv_storeState);
		tv_storeState.setText(sdm.storeState);
		TextView tv_storeZip = (TextView) findViewById(R.id.tv_StoreZip);
		tv_storeZip.setText(sdm.storeZip);
		TextView tv_storePhone = (TextView) findViewById(R.id.tv_StorePhone);
		tv_storePhone.setText(sdm.storePhone);
		TextView tv_storeLatitude = (TextView) findViewById(R.id.tv_storeLatitude);
		tv_storeLatitude.setText(sdm.storeLatitude);
		TextView tv_storeLongitude = (TextView) findViewById(R.id.tv_StoreLongitude);
		tv_storeLongitude.setText(sdm.storeLongitude);	
		
		ImageView iv = (ImageView)findViewById(R.id.imageView1);
		iv.setImageBitmap(sdm.storeLogo);
	}
	
	public void backToList(View v){
		
		Intent intent = new Intent(this, BRTest.class);
		startActivity(intent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_store_details, menu);
		return true;
	}

}
