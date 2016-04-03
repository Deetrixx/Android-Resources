package com.donkcowan.serviceexample;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

@SuppressLint("HandlerLeak")

// Define Service - an application component that can perform
// long running operations in the background and 
// does not provide a user interface.
public class ServiceExecution extends Service {

    // Declare variables for Looper and ServiceHandler.
    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;
	  
    // Handler that receives messages from the thread.
    private final class ServiceHandler extends Handler {
    	
    	// Constructor for class. 
    	// Run once on creation of handler object.
        public ServiceHandler(Looper looper) {
        	
        	// Override super class to use looper provided.
        	super(looper);
        }
        // Handler receives message and carries out the work of the service.
	    @Override
	    public void handleMessage(Message msg) {

	    	// REPLACE THIS CODE WITH YOUR APP CODE
            // Wait before Toasting Service Message  
	    	// to give the Service Started message time to display.	    	
    	    for (int i = 0; i <= 30; i ++) {
    	        try {Thread.sleep(100);} 
    	        catch (InterruptedException e) {e.printStackTrace();}
    	    }
	        // Toast Service Message.
	  		Context context = getApplicationContext();
			CharSequence text = getString(R.string.serviceMessage);
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			      
	        // Service can stop itself using the stopSelf() method.
			// Not using in this app.  Example statement shown below.
	        //stopSelf(msg.arg1);
	    }
    }	 
	// onBind method.
	@Override
	public IBinder onBind(Intent arg0) {
		
		// Binding not being used in this app.
		return null;
    }
	// onCreate method.  Create a thread and service handler with looper.
	@Override
	public void onCreate() {
		super.onCreate();
        
		// Create a thread with a looper.
	    HandlerThread thread = new HandlerThread("ServiceStartArguments",
	    		               android.os.Process.THREAD_PRIORITY_BACKGROUND);
	    // Start the thread.
	    thread.start();
	    
	    // Get the thread's looper.
	    mServiceLooper = thread.getLooper();
	    
	    // Create a service handler.
	    mServiceHandler = new ServiceHandler(mServiceLooper);		
	}
	// onStartCommand method. 
	// Send message to service handler and display toast that service has started.
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		// Get message from message pool using handler.
	    Message msg = mServiceHandler.obtainMessage();
	    
	    // Set start ID (unique to the specific start) in message.
	    msg.arg1 = startId;
	    
	    // Send message to start job.
	    mServiceHandler.sendMessage(msg);		
		
	    // Toast Service Started message.
		Context context = getApplicationContext();
		CharSequence text = getString(R.string.serviceStarted);
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();	
		
		// Start a sticky.
		return START_STICKY;
	}	
	// onDestroy method.   Display toast that service has stopped.
	@Override
	public void onDestroy() {
		super.onDestroy();
		
		// Toast Service Stopped.
		Context context = getApplicationContext();
		CharSequence text = getString(R.string.serviceStopped);
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
}
