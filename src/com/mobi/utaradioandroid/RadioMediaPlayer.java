package com.mobi.utaradioandroid;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RadioMediaPlayer {
	
	private TextView tvSong;
	private TextView tvArtist;
	private Button playBtn;
	
	public RadioMediaPlayer(View v, final MediaPlayer player) {
		// TODO Auto-generated constructor stub
		playBtn = (Button) v.findViewById(R.id.play_button);
        tvSong = (TextView) v.findViewById(R.id.tv_Song);
        tvArtist = (TextView) v.findViewById(R.id.tv_Artist);
        
        new loadData().execute("http://radio.uta.edu/mediaplayer/nowplaying.xml");
        
		playBtn.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (player.isPlaying())
				{
					playBtn.setText("play");
					player.pause();
				} else{
					player.start();
					playBtn.setText("pause");
				} 
			}
		}); 
	}
	
	
	public class loadData extends AsyncTask<String, Integer, String>{
		
		private HandlingXMLStuff hxl;
		
		@Override
		protected String doInBackground(String... url) {
			
			XmlParser xp = new XmlParser();
			hxl = new HandlingXMLStuff();
			return xp.doInBackground(url[0], hxl);
		}

		@Override
		protected void onPostExecute(String result) {
			
			tvSong.setText(hxl.getSong());
			tvArtist.setText(hxl.getArtist());
			
		}
		
	
	}
}
