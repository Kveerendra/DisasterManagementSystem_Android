package com.hack4good.dms;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Person_Display extends Activity {
	String url;

	ImageView img;
	Bitmap bitmap;
	ProgressDialog pDialog;
HashMap<String, String > person; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person__display);
		img = (ImageView) findViewById(R.id.img);
		new LoadImage().execute(url);
		person = OKHttp.getPerson(Pname,Pid);
		((TextView)findViewById(R.id.name)).setText(person.get("name"));
		((TextView)findViewById(R.id.clocation)).setText(person.get("clocation"));
		((TextView)findViewById(R.id.contact)).setText(person.get("contact"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.person__display, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

static String Pname,Pid;
			public void setName(String name) {
	this.Pname = name;
}
public void setPId(String Pid) {
	this.Pid = Pid;
}
	private class LoadImage extends AsyncTask<String, String, Bitmap> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(Person_Display.this);
			pDialog.setMessage("Loading Image ....");
			pDialog.show();
		}

		protected Bitmap doInBackground(String... args) {
			try {
				bitmap = BitmapFactory.decodeStream((InputStream) new URL(
						args[0]).getContent());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bitmap;
		}

		protected void onPostExecute(Bitmap image) {
			if (image != null) {
				img.setImageBitmap(image);
				pDialog.dismiss();
				
			} else {
				pDialog.dismiss();
				Toast.makeText(Person_Display.this,
						"Image Does Not exist or Network Error",
						Toast.LENGTH_SHORT).show();
			}
		}
	}
}
