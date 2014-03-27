package org.example.helloandroid;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button firstButton;
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		textview = (TextView) findViewById(R.id.textView1);
		firstButton = (Button) findViewById(R.id.button1);
		firstButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.err.println("clicked");
			    AsyncTaskRunner runner = new AsyncTaskRunner();
			    runner.execute("hi");
				// TODO Auto-generated method stub
				textview.setText("hello");
			}
		});
		
		
	}
	 /**
	  * @author Prabu
	  * Private class which runs the long operation. ( Sleeping for some time )
	  */
	 private class AsyncTaskRunner extends AsyncTask<String, String, String> {

	  private String resp;

	  @Override
	  protected String doInBackground(String... params) {
		System.err.println("in background thread");
	   //publishProgress("Sleeping..."); // Calls onProgressUpdate()
	   
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://localhost:3000/post");
		
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("key1", "value1"));
		pairs.add(new BasicNameValuePair("key2", "value2"));
		String trial = "no reponse";
		HttpResponse response;

		try {
			System.err.println("Trying");
			post.setEntity(new UrlEncodedFormEntity(pairs));
			response = client.execute(post);
			trial = response.toString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return trial;
	  }

	  /*
	   * (non-Javadoc)
	   * 
	   * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	   */
	  @Override
	  protected void onPostExecute(String result) {
	   // execution of result of Long time consuming operation
	  // TextView finalResult = null;
	//finalResult.setText(result);
	  }

	  /*
	   * (non-Javadoc)
	   * 
	   * @see android.os.AsyncTask#onPreExecute()
	   */
	  @Override
	  protected void onPreExecute() {
	   // Things to be done before execution of long running operation. For
	   // example showing ProgessDialog
	  }

	  /*
	   * (non-Javadoc)
	   * 
	   * @see android.os.AsyncTask#onProgressUpdate(Progress[])
	   */
	  @Override
	  protected void onProgressUpdate(String... text) {
//	   TextView finalResult = null;
//	finalResult.setText(text[0]);
	   // Things to be done while execution of long running operation is in
	   // progress. For example updating ProgessDialog
	  }

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}}
