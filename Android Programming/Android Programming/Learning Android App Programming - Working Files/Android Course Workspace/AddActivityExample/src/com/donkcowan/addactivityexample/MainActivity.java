package com.donkcowan.addactivityexample;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import com.donkcowan.addactivityexample.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		int variableTest = 1;
		int variableUse = variableTest;
		Log.i("AppTest","My message");
		Log.i("AppTest",Integer.toString(variableUse));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
