
// Developed by Hesham Fas For Bottle Rocket Test
package com.BottleRocket.bottlerocktest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.util.Log;

public class HttpAPI {

	// General HttpConnection
	public static InputStream HttpGet(String urlString) throws IOException {

		InputStream in = null;
		int response = -1;
		URL url = new URL(urlString);
		URLConnection con = url.openConnection();
		if (!(con instanceof HttpURLConnection)) {
			throw new IOException("Not an HTTP connection");
		}
		try {
			HttpURLConnection httpConn = (HttpURLConnection) con;
			httpConn.setAllowUserInteraction(false);
			httpConn.setInstanceFollowRedirects(true);
			httpConn.setRequestMethod("GET");
			httpConn.connect();
			response = httpConn.getResponseCode();
			if (response == HttpURLConnection.HTTP_OK) {
				Log.d("Response", "Was OK");
				in = httpConn.getInputStream();
			}
			else{
				return null;// in order to show the dialog
			}
		} catch (Exception ex) {
			// Log.d("Networking", ex.getLocalizedMessage());
			System.out.println("Exception occured");
			throw new IOException("Error connecting");
		}
		return in;
	}// end openHttpConnection

}
