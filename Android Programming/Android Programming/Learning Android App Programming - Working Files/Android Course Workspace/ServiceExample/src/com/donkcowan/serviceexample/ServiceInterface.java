package com.donkcowan.serviceexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ServiceInterface extends Activity {
	
    // onCreate method.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    // Initialize display.
	    setContentView(R.layout.main);
	    	        
        // Declare buttons for Start and Stop.
	    Button startService = (Button)findViewById(R.id.startServiceButton);
	    Button stopService  = (Button)findViewById(R.id.stopServiceButton);
	        
	    // Set listeners for buttons.
	    startService.setOnClickListener(startServiceListener);
	    stopService.setOnClickListener(stopServiceListener); 
	    
	    // Initialize serviceStatus text field in display.
        TextView tv = (TextView) findViewById(R.id.serviceStatus);
        tv.setText(getString(R.string.serviceNotRunning));
	}   
	// Define OnClickListener for Start Service button.
    private OnClickListener startServiceListener = new OnClickListener() {
       	public void onClick(View v){
       		
       		// Start the Service.
       		Intent serviceIntent = new Intent(ServiceInterface.this,ServiceExecution.class);
       		startService(serviceIntent);
       		
       	    // Display Service Running message.
            TextView tv = (TextView) findViewById(R.id.serviceStatus);
            tv.setText(getString(R.string.serviceRunning));
       	}	        	
    };
	// Define OnClickListener for Stop Service button.
    private OnClickListener stopServiceListener = new OnClickListener() {
       	public void onClick(View v){
       		
       		// Stop the Service.
       		Intent serviceIntent = new Intent(ServiceInterface.this,ServiceExecution.class);
       		stopService(serviceIntent);
       		
       		// Display Service Not Running message.
            TextView tv = (TextView) findViewById(R.id.serviceStatus);
            tv.setText(getString(R.string.serviceNotRunning));
       	}	        	
    };
}
