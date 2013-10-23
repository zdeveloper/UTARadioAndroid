package com.mobi.utaradioandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RadioMediaPlayer {
	
	private TextView tvSong;
	private TextView tvArtist;
	private Button playBtn;
	
	public RadioMediaPlayer(View v, final MediaPlayer player) {
		
		playBtn = (Button) v.findViewById(R.id.play_button);
        tvSong = (TextView) v.findViewById(R.id.tv_Song);
        tvArtist = (TextView) v.findViewById(R.id.tv_Artist);
        
        
        new loadDataFromXML().execute("http://radio.uta.edu/mediaplayer/nowplaying.xml");
        
		playBtn.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				
				if (player.isPlaying())
				{
					playBtn.setText("play");
					player.pause();
				} else{
					playBtn.setText("pause");
					player.start();
				} 
			}
		}); 
	}
	
	//this class handles getting the data from UTA radio such as song name and artist
	public class loadDataFromXML extends AsyncTask<String, Integer, String>{
		
		//the xmlParser saves all its data on the content handler, thats where we're getting it from
		private HandlingXMLStuff hxl;
		
		@Override
		protected String doInBackground(String... url) {
			
			XmlParser xp = new XmlParser();
			hxl = new HandlingXMLStuff();
			xp.doInBackground(url[0], hxl);
			return "";	//dummy return
		}

		@Override
		protected void onPostExecute(String result) {
			
			//\\// //\\ \\//\\// //\\  |(.)(.)|  /(.)(.)\ guess who's in the picture
			tvSong.setText(hxl.getSong());
			tvArtist.setText(hxl.getArtist());
			Log.d("USER", "Executing command");
			new getArtData().execute("");
		}
	}
	
	/**
	 *  This class is used retrieve the album art for the song.
	 *  We use last.fm API to get this info
	 * @author zedd
	 *
	 */
	public class getArtData extends AsyncTask<String, Integer, String>{
		
		String apiKey;
		String songName;
		String artistName;
		
		private String downloadDocumentFromInternet(String URL) throws Exception{
			//making an http client
			HttpClient httpClient = new DefaultHttpClient();
			//making http post
			HttpPost httpPost = new HttpPost(URL);
			//making an http post request using httpClient and httpPost and saving that to httpResponse
			HttpResponse httpResponse = httpClient.execute(httpPost);
			//getting the entity from the response
			HttpEntity httpEntity = httpResponse.getEntity();
			//making an inputStram from response entity
			InputStream inputStream = httpEntity.getContent();
			
			//the following section covers converting the input stream into a string
			
			//making an input stram reader, also called a BufferedReader
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			//String builder, Duh!
			StringBuilder sb = new StringBuilder();
			
			String line=null;
			while( (line = reader.readLine()) != null)
			{
				sb.append(line + "\n");		//appending each line read to the string builder and adding the new line character at the end of each line
			}
			reader.close();		//closing the reader, good practice
			return sb.toString();	//finally getting the string	 
		}

		@Override
		protected String doInBackground(String... params) {
			//Map gsonMap;
			String doc = null;
			try {
				doc = downloadDocumentFromInternet("http://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key=7f8d036638619be79d49391d8dbe2d11&artist=coldplay&track=clocks&format=json");
				
				Gson gson = new Gson();
				JsonMackup jsonclass = new JsonMackup();
				jsonclass = gson.fromJson(doc, JsonMackup.class);
				ArrayList<JsonMackup.Image> images = jsonclass.getTrack().getAlbum().getImage();
				Log.d("USER", images.get(0).gettext());
				
				
				/*
				//The follwing code is not working
				JSONObject jObject = new JSONObject(doc.replace("\\", ""));
				JSONArray jArray = jObject.getJSONArray("image");
				
				for(int i=0; i<jArray.length(); i++)
				{
					try {
				        JSONObject oneObject1 = jArray.getJSONObject(i);
				        JSONArray jArray1 = oneObject1.getJSONArray(i+"");
				        JSONObject oneObject = jArray.getJSONObject(i);
				        
				        // Pulling items from the array
				        String url = oneObject.getString("#text");
				        String size = oneObject.getString("size");
				        
				        Log.d("USER", "URL: " + url + "\nSIZE: " + size);
				        
				    } catch (Exception e) {
				    	 Log.d("USER", "Error in parsing object from JSONArray");
				    }
				}
				/**/
				
			} catch (Exception e) {
				Log.d("USER", "Error in getArtData: " + e.toString());
			}
			
			
			return doc;
		}

		@Override
		protected void onPostExecute(String result) {
			//Log.d("USER", result.replace("\\", ""));
		}
		
	}
	
}
