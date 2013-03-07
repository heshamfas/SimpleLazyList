// Developed by Hesham Fas For Bottle Rocket Test

package com.BottleRocket.bottlerocktest;

import java.util.ArrayList;

import android.graphics.Bitmap;

public final class DataModelsHolder {
	
	
	static ArrayList<StoreDataModel> storeList = new ArrayList<StoreDataModel>();
		   private static DataModelsHolder instance = null;
		   private DataModelsHolder() {
		      // Exists only to defeat instantiation.
		   }
		   public static DataModelsHolder getInstance() {
		      if(instance == null) {
		         instance = new DataModelsHolder();
		      }
		      return instance;
		}
		   public  ArrayList<StoreDataModel> getStoreList(){
			   return storeList;   	   
		   }
		   public void addStoreDataModel(StoreDataModel stdm){
			   
			   storeList.add(stdm);
		   }
		   public void setStoreImage(int position, Bitmap image){
			   storeList.get(position).storeLogo = image; 
		   }
}
