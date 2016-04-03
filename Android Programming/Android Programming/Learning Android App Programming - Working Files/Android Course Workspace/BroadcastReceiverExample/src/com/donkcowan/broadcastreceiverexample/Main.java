package com.donkcowan.broadcastreceiverexample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

// Declare main activity for the application.
public class Main extends Activity {
    
	// Define the filter that will activate the BroadcastReceiver.
	//
	// In this example the ACTION_TIME_TICK intent is used.
	// This intent is issued by the Android system every minute
	// at the same instant the clock minute notification display is changed.
    private IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);  	
	
	// Instantiate BroadcastReceiver.
	private BroadcastReceiver receiver = new BroadcastReceiver(){

		// Define actions to be taken when broadcast is received.
		@Override
		public void onReceive(Context c, Intent i) {
			
			// Do the work of the BroadcastReceiver.
			// In this example, a message is toasted to the user.
			Toast.makeText(getBaseContext(), 
					       "ACTION_TIME_TICK intent received.", 
					       Toast.LENGTH_LONG)
					       .show();
			
			// Once the BroadcastReceiver returns from this method, 
			// the system considers the object to be finished
			// and no longer active.  Because of this, the onReceive method:
			//   - cannot implement asynchronous operations
			//   - cannot show a dialog 
            //   - cannot bind to a service
			
			// When long running BroadcastReceivers are needed,
			// use a Service component in conjunction with 
			// the BroadcastReceiver component.
			
			// For broadcasting only within an application,
			// consider using the LocalBroadcastManager class.
	     }
	};
    // Initialize the user interface in the onCreate method
	// of the main activity.
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);  
    } 
    // Register the receiver with its filter.
	// In some cases, the filter can be registered using the Manifest.  
	// See the documentation for the individual intent 
	// to determine when the Manifest can be used.
    @Override  
    protected void onResume() {  
        this.registerReceiver(receiver, filter);  
        super.onResume();  
    } 
    // Unregister the receiver when the application is paused.
    @Override  
    protected void onPause() {  
        this.unregisterReceiver(receiver);  
        super.onPause();  
    }  
}