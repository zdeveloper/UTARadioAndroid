package com.mobi.utaradioandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        
        int sleepTimeInSeconds = 3;
        try {
			Thread.sleep(sleepTimeInSeconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			Intent i = new Intent(SplashActivity.this, MainActivity.class);
			startActivity(i);
			finish();
		}
        
        
    }

}
