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

public class SearchResults extends Activity {
	protected static Context Context = null;
	ArrayList<String> results;
	ArrayList<String> ids;
	ListView listview;
	static String date, name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_results);
		Context= this;
		Intent i = new Intent();
		if (date != null && name!=null) {
			results = OKHttp.getNamesFromDateAndName(date, name);
			ids = OKHttp.getIdsFromDateAndName(date, name, results);
			
		} else if (name!=null) {
			results = OKHttp.getNamesFromName(name);
			ids = OKHttp.getIdsFromName(name, results);
		} else {
			results = OKHttp.getNamesFromName(date);
			ids = OKHttp.getIdsFromName(date, results);
		}
		listview = (ListView) findViewById(R.id.listView1);
		final StableArrayAdapter adapter = new StableArrayAdapter(this,
				android.R.layout.simple_list_item_1, results);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Person_Display.Pid = ids.get(position);
				Person_Display.Pname = results.get(position);
				Intent i = new Intent(Context, Person_Display.class);
				startActivity(i);
			}

		});
	}




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_results, menu);
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
