package com.mobi.utaradioandroid;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RadioMediaPlayer extends Activity {
	private MediaPlayer player;
	private Button playBtn;
	
	public RadioMediaPlayer(View v) {
		// TODO Auto-generated constructor stub
		player = new MediaPlayer();	
		playBtn = (Button) findViewById(R.id.play_button);
		playBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					player.setDataSource("webmedia-2.uta.edu:1935/uta_radio/live");
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
			}
		});
	}
}
