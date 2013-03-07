// Developed by Hesham Fas For Bottle Rocket Test

package com.BottleRocket.bottlerocktest;

import java.io.IOException;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;

public class ImageController {
	public ImageView iv;
	DataModelsHolder dmh = DataModelsHolder.getInstance();
	StoreDataModel sdm;

	public ImageController() {
	}

	public void SetImageViewBitmap(ImageView imageView, int position) {
		sdm = dmh.storeList.get(position);
		iv = imageView;
		if (sdm.storeLogo != null) {
			iv.setImageBitmap(sdm.storeLogo);
		} else {
			imageView.setImageResource(R.drawable.ic_launcher);
			new DownloadImageTask().execute(sdm.storeLogoURL);
		}
	}

	private StoreDataModel downloadStoreDataModelImages(StoreDataModel stDM) {
		String storeLogoURL = stDM.storeLogoURL;
		Bitmap bitmap = null;
		InputStream in = null;

		try {
			in = HttpAPI.HttpGet(storeLogoURL);
			bitmap = BitmapFactory.decodeStream(in);
			in.close();
			stDM.storeLogo = bitmap;
		} catch (IOException e1) {
			Log.d("NetworkingActivity", e1.getLocalizedMessage());
		}
		return stDM;
	}

	// a method to download Store Images
	public Bitmap getImageFromURL() {

		Bitmap bitmap = null;
		InputStream in = null;
		try {
			in = HttpAPI.HttpGet(sdm.storeLogoURL);
			bitmap = BitmapFactory.decodeStream(in);
			in.close();

		} catch (IOException e1) {
			Log.d("NetworkingActivity", e1.getLocalizedMessage());
		}

		return bitmap;
	}

	// inner AsyncTask Class to get images from the web
	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

		@Override
		protected Bitmap doInBackground(String... arg0) {
			
			return getImageFromURL();
		}

		protected void onPostExecute(Bitmap image) {
			try {
				if(image != null)
				{
					iv.setImageBitmap(image);
					sdm.storeLogo = image;
				}		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
		}// end class DownloadImageTask

	}

