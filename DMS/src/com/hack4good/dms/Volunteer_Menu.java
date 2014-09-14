package com.hack4good.dms;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Volunteer_Menu extends Activity {

	protected static Context Context = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Context= this;
		setContentView(R.layout.activity_volunteer__menu);
		ListView listview = (ListView) findViewById(R.id.listView1);
		listview = (ListView) findViewById(R.id.listView1);
		ArrayList<String> list= new ArrayList<>();
		list.add("Survival Info");
		list.add("Death Details");
		list.add("Relief Camp Updates");
		final StableArrayAdapter adapter = new StableArrayAdapter(this,
				android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent i = null;
				switch (position) {
				case 0: i = new Intent(Context, Survival_Info.class);
					break;
				case 1: i = new Intent(Context, Death_Details.class);
					break;
				case 2: i = new Intent(Context, Relief_Camp_Updates.class);
					
					break;
				}
				startActivity(i);
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.volunteer__menu, menu);
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
