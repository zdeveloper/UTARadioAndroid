package com.mobi.utaradioandroid;


import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RadioMediaPlayer {

	public RadioMediaPlayer(View v, final MediaPlayer player) {
		// TODO Auto-generated constructor stub
		Button playBtn = (Button) v.findViewById(R.id.play_button);
        playBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (player.isPlaying())
				{
					player.pause();
				} else{
					player.start();
				} 
			}
		});
	}
}
