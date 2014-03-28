package org.example.helloandroid;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

public class HttpExample extends Activity {
	TextView httpStuff;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
	       
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpex);
		httpStuff = (TextView) findViewById(R.id.tvHttp);
		LoadGetResponse loader = new LoadGetResponse();
		loader.execute("start");
	}

		
	
	public class LoadGetResponse extends AsyncTask<String,Integer,String>{
		
		protected void onPreExecute(String s){
			
		}
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			GetMethodEx test = new GetMethodEx();
			String returned = null;
			try{
				returned = test.getInternetData();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return returned;
		}
		
		protected void onProgressUpdated(Integer...progress){
			
		}
		
		protected void onPostExecute(String result){
			httpStuff.setText(result);
			
		}
	}


}
