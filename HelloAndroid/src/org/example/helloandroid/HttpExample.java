package org.example.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

public class HttpExample extends Activity {
	TextView httpStuff;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
	       if (android.os.Build.VERSION.SDK_INT > 9) {
               StrictMode.ThreadPolicy policy = 
                       new StrictMode.ThreadPolicy.Builder().permitAll().build();
               StrictMode.setThreadPolicy(policy);
               }
	       
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpex);
		httpStuff = (TextView) findViewById(R.id.tvHttp);
		GetMethodEx test = new GetMethodEx();
		String returned;
		try{
			returned = test.getInternetData();
			httpStuff.setText(returned);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
