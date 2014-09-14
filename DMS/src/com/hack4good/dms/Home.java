package com.hack4good.dms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

public class Home extends Activity {
	ProgressBar bar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		bar = (ProgressBar) findViewById(R.id.progressBar1);
		bar.setMax(100);
		bar.setProgress(20);
	}

	
	public void openSearch(View view) {
	    Intent i = new Intent(this, SearchPeople.class);
	    startActivity(i);
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
	//	System.out.println("Clicked login1");
		if (id == R.id.action_settings) {
			Intent i = new Intent(this, Login.class);
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
