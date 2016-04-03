package com.donkcowan.firstappprojectenhancement;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class MainActivity extends Activity implements OnRatingBarChangeListener {

	@Override
	// onCreate method.
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Initialize screen display.
		setContentView(R.layout.activity_main);
		
		// Set listener for rating bar.
		((RatingBar)findViewById(R.id.ratingBar1)).setOnRatingBarChangeListener(this);
	}

	// Define listener method for rating bar change.
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromTouch) {
     
        // Log message showing number of stars entered.
		Log.i("AppTest","My message");
		Log.i("AppTest",Float.toString(rating));
    }
	@Override
	// onCreateOptionsMenu method.
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
