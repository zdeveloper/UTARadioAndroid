package com.mobi.utaradioandroid;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RadioMediaPlayer extends Activity {

	public RadioMediaPlayer(Button playBtn) {
		// TODO Auto-generated constructor stub
        //app code
       // Button playBtn = (Button) findViewById(R.id.play_button);
        final MediaPlayer player = new MediaPlayer();
        try {
			player.setDataSource("rtsp://webmedia-2.uta.edu:1935/uta_radio/live");
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
			player.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        playBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (player.isPlaying())
				{
					player.stop();
				} else{
					player.start();
				} 
			}
		});
	}
}
