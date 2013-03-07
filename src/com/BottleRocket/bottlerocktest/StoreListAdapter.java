// Developed by Hesham Fas For Bottle Rocket Test

package com.BottleRocket.bottlerocktest;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.R.color.*;
public class StoreListAdapter extends BaseAdapter {
	Context context;
	int itemBackground;
	DataModelsHolder dmh = DataModelsHolder.getInstance();
	ArrayList<StoreDataModel> storeDataModels = dmh.getStoreList();
	private LayoutInflater inflater;
	boolean flag= false;
	int temp_unique_id = 0; // giving an Id to the list item
	int temp_getCount_called = 0; //seeing how many times getCount called
	

	public StoreListAdapter(Context c) {
		//super(c, R.layout.list_item);
		context = c;
		inflater = (LayoutInflater) c
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);			
	}

	@Override
	public int getCount() {
		Log.d("Image Array Size", "" + storeDataModels.size());
		temp_getCount_called += 1;
		//Toast.makeText(context, "getCount" + temp_getCount_called	,Toast.LENGTH_LONG).show();
		return storeDataModels.size();
	}

	
	@Override
	public boolean hasStableIds(){
		return true;
	}

	@Override
	public int getItemViewType(int pos){
		return IGNORE_ITEM_VIEW_TYPE;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		
		if (convertView == null) {
			view = inflater.inflate(R.layout.list_item, null);
		
			//	Color color = ;
	
					
		
			
			StoreDataModel stdm = storeDataModels.get(position) ;

			TextView tvStoreName = (TextView) view
					.findViewById(R.id.store_Name);
			tvStoreName.setText(stdm.storeName);
			TextView tvStoreCity = (TextView) view
					.findViewById(R.id.store_City);
			tvStoreCity.setText(stdm.storeCity);
			TextView tvStoreState = (TextView) view
					.findViewById(R.id.store_state);
			tvStoreState.setText(stdm.storeState);
			TextView tvStorePhone = (TextView) view
					.findViewById(R.id.store_phone);
			tvStorePhone.setText(stdm.storePhone);

			// for testing
			TextView tv_unique_id = (TextView) view
					.findViewById(R.id.unique_id);
			tv_unique_id.setText("" + position);
			temp_unique_id += 1;
			TextView tv_obj_unique_id = (TextView) view
					.findViewById(R.id.obj_unique_id);
			tv_obj_unique_id.setText(" objID: " +stdm.object_unique_id);
			// end for testing

			ImageView iv = (ImageView) view.findViewById(R.id.logo);
			ImageController ic = new ImageController();
			ic.SetImageViewBitmap(iv, position);
			}
	
		if ((position % 2 ) == 0){
			view.setBackgroundColor(context.getResources().getColor(android.R.color.background_light));
			
			}else
			{
				view.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
			
			}
			//Toast.makeText(context, "GetView Called " + unique_id, Toast.LENGTH_SHORT).show();			
			return view;		
	}// end getView

}// end class image Adapter

