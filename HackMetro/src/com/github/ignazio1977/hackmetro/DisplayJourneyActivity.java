package com.github.ignazio1977.hackmetro;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.ignazio1977.hackmetro.model.Journey;

public class DisplayJourneyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_journey);

		// Get the message from the intent
		Intent intent = getIntent();
		String journeyInfo = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

		// create the text view
		TextView textView = (TextView) findViewById(R.id.journey_info);
		textView.setText("Showing " + journeyInfo);

		// Set the text view as the activity layout
		// setContentView(textView);

		// Get the right List
		ListView hopListView = (ListView) findViewById(R.id.hop_list);
		// List<String> hopList = FakeModel.getHopList(journeyInfo);
		// Journey journey = FakeModel.getFakeJourney(journeyInfo);
		// StationItemAdapter adapter = new StationItemAdapter(this,
		// R.layout.journey_list_row, journey);
		// hopListView.setAdapter(adapter);

		List<String> hopList = FakeModel.getHopList(journeyInfo);
		Journey journey = FakeModel.getFakeJourney(journeyInfo);
		// StationItemAdapter adapter = new StationItemAdapter(this,
		// R.layout.journey_list_row, journey);
		hopListView.setAdapter(new ArrayAdapter<String>(
				DisplayJourneyActivity.this,
				android.R.layout.simple_list_item_1, hopList));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_journey, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
