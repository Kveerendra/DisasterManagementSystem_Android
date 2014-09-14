package com.hack4good.dms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Relief_Camp_Updates extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_relief__camp__updates);
	}

	public void submit(View view) {
		String disaster_name = ((EditText)findViewById(R.id.Disaster_Name)).getText().toString();
		String Volunteers_Requirement = ((EditText)findViewById(R.id.Volunteers_Requirement)).getText().toString();
		String Food = ((EditText)findViewById(R.id.Food)).getText().toString();
		String Water = ((EditText)findViewById(R.id.Water)).getText().toString();
		String Medical = ((EditText)findViewById(R.id.Medical)).getText().toString();
		String Relief_Camp_Address = ((EditText)findViewById(R.id.Relief_Camp_Address)).getText().toString();
		String relief_camp_ph = ((EditText)findViewById(R.id.relief_camp_ph)).getText().toString();
		OKHttp.submitReliefCampDetails(disaster_name,Volunteers_Requirement,Food,Water,Medical,Relief_Camp_Address,relief_camp_ph);
	    Intent i = new Intent(this, Volunteer_Menu.class);
	    startActivity(i);
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.relief__camp__updates, menu);
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
}
