package com.mobi.utaradioandroid;

import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class SplashActivity extends Activity {

	// public static MediaPlayer player;
	// we are using this array list to share the MediaPlayer object player
	// between all classes
	// we cannot put MediaPlayer object inside the intent extra but we can put
	// an array list
	// public static ArrayList<MediaPlayer> mediaPlayer;

	public static MediaPlayer mPlayer = new MediaPlayer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			
			//mPlayer.setDataSource("http://webmedia-2.uta.edu:1935/uta_radio/live/playlist.m3u8");
			mPlayer.setDataSource("rtsp://webmedia-2.uta.edu:1935/uta_radio/live");
			mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mPlayer.prepareAsync();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//mPlayer.start();

		setContentView(R.layout.activity_splash);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		// sleep for 3 seconds
		new Thread(new Runnable() {
			public void run() {
				int sleepTimeInSeconds = 3;
				try {
					Thread.sleep(sleepTimeInSeconds * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					Intent i = new Intent(SplashActivity.this,
							MainActivity.class);
					startActivity(i);
					finish();
				}
			}
		}).start();

	}

}
