package com.hack4good.dms;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class SearchPeople extends Activity {
	Spinner spin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_people);
		spin = (Spinner) findViewById(R.id.disasters);
		List<String> listOfItems = getListOfItems();

		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, listOfItems);

		spin.setAdapter(spinnerAdapter);
	}

	private ArrayList<String> getListOfItems() {
		ArrayList<String> al = OKHttp.getDisasters();
		return al;
	}
static final String DATE ="com.hack4good.dms.date";
	public void search(View view) {

		Intent i = new Intent(this, SearchResults.class);
		String string1 =((EditText) (findViewById(R.id.editText1))).getText()+"";
		String string2 =((EditText) (findViewById(R.id.editText2))).getText()+"";
		SearchResults.date = string1;
		SearchResults.name = string2;
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_people, menu);
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
