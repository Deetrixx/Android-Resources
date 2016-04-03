package com.donkcowan.asynctaskexample;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.ProgressDialog;

public class AsyncTaskMain extends Activity {
	
	// Declare progress bar variable.
	ProgressDialog progressBar;
	int progressIncr = 1;
	
    // onCreate method.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    // Initialize display.
	    setContentView(R.layout.main); 
	        
        // Declare button variable for Start Task.
	    Button startTask = (Button)findViewById(R.id.startTaskButton);
	        
	    // Set listener for button.
	    startTask.setOnClickListener(startTaskListener);
	}   
	// Define OnClickListener for startTask button.
    private OnClickListener startTaskListener = new OnClickListener() {
       	public void onClick(View v){
       		
       		// Get application context.
		    Context context = getApplicationContext();

			// Create ProcessDialog object.
       		progressBar = new ProgressDialog(v.getContext());
	    
       		// Create async task object.
       		BackgroundTask testBackgroundTask = new BackgroundTask();
       		
       		// Execute background task.
       		testBackgroundTask.execute(context);
       		
       		// Toast message.
       		CharSequence text = getString(R.string.mainThreadRunning);
       		int duration = Toast.LENGTH_LONG;
		    Toast toast = Toast.makeText(context, text, duration);
		    toast.show();
       	}	        	
    };   
    // Define AsyncTask class.
    private class BackgroundTask extends AsyncTask<Context, Integer, String> {
        
    	// Pre execution method.
        @Override
        protected void onPreExecute() {
            
            // Set progress bar characteristics and values.
            CharSequence message = getString(R.string.progressMessage);
			progressBar.setCancelable(true);
			progressBar.setMessage(message);
			progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progressBar.setProgress(0);
			progressBar.setMax(100);
			progressBar.show();	        	
        }  
        // Background method.
    	@Override
    	protected String doInBackground(Context... params) {
    		
    	    // Background task.
    	    for (int i = 0; i <= 100; i += progressIncr) {
    	        try {Thread.sleep(100);} 
    	        catch (InterruptedException e) {e.printStackTrace();}
    	          
    	        // Publish progress.
    	        publishProgress(progressIncr);
    	        
    	        // Check for cancellation of background task.
    	        if (isCancelled()) break;
    	    }
    	    // Return completion text.
			return getString(R.string.backgroundTaskCompleted);
        }
    	// Progress updates method.
    	@Override
    	protected void onProgressUpdate(Integer... values) {
    		
    	    // Update progress bar.
    	    progressBar.incrementProgressBy(progressIncr);    		
    	}
        // Post execution method.
        @Override
        protected void onPostExecute(String result) {

        	// Dismiss progress bar.
            progressBar.dismiss();
        	
       		// Toast completion message.
		    Context context = getApplicationContext();        	
       		int duration = Toast.LENGTH_LONG;
		    Toast toast = Toast.makeText(context, result, duration);
		    toast.show();
        }
    }     
}
