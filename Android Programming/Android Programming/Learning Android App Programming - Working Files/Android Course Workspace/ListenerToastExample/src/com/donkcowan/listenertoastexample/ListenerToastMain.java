package com.donkcowan.listenertoastexample;

import java.util.Random;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ListenerToastMain extends Activity {
	
    // onCreate method.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    // Initialize display.
	    setContentView(R.layout.main);
	        
        // Declare button variable for Get Answer.
	    Button getAnswer = (Button)findViewById(R.id.getAnswerButton);
	        
	    // Set listener for button.
	    getAnswer.setOnClickListener(getAnswerListener);    
	}   
	// Define OnClickListener for getAnswer button.
    private OnClickListener getAnswerListener = new OnClickListener() {
       	public void onClick(View v){
       		
       		// Generate answer number.
       		Random toastGen = new Random();
       		int toastNum = toastGen.nextInt(19);
       		toastNum++;
       		
       		// Get answer text.
       		CharSequence text = "";
       		switch (toastNum) {
       		    case 1:  text = getString(R.string.answer1);  break;
       		    case 2:  text = getString(R.string.answer2);  break;
       		    case 3:  text = getString(R.string.answer3);  break;
       		    case 4:  text = getString(R.string.answer4);  break;
       		    case 5:  text = getString(R.string.answer5);  break;
       		    case 6:  text = getString(R.string.answer6);  break;
       		    case 7:  text = getString(R.string.answer7);  break;
       		    case 8:  text = getString(R.string.answer8);  break; 
       		    case 9:  text = getString(R.string.answer9);  break;
       		    case 10: text = getString(R.string.answer10); break;
       		    case 11: text = getString(R.string.answer11); break;
       		    case 12: text = getString(R.string.answer12); break;
       		    case 13: text = getString(R.string.answer13); break;
       		    case 14: text = getString(R.string.answer14); break;
       		    case 15: text = getString(R.string.answer15); break;
       		    case 16: text = getString(R.string.answer16); break;
       		    case 17: text = getString(R.string.answer17); break;
       		    case 18: text = getString(R.string.answer18); break;
       		    case 19: text = getString(R.string.answer19); break;
       		    case 20: text = getString(R.string.answer20); break;       		    
       		}
       		// Toast answer.
		    Context context = getApplicationContext();
		    int duration = Toast.LENGTH_LONG;
		    Toast toast = Toast.makeText(context, text, duration);
		    toast.show();
       	}	        	
    };
}
