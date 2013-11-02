package com.github.ignazio1977.hackmetro;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.github.ignazio1977.hackmetro.model.Journey;
import com.github.ignazio1977.hackmetro.model.JourneyPlanner;
import com.github.ignazio1977.hackmetro.model.Journeys;
import com.github.ignazio1977.hackmetro.model.Search;
import com.github.ignazio1977.hackmetro.model.enums.Stops;
import com.google.common.base.Optional;

public class MainActivity extends Activity {

	public static final String EXTRA_MESSAGE = "com.github.ignazio1977.hackmetro.MESSAGE";
	protected static final int FROM_VALUE = 0;
	protected static final int TO_VALUE = 1;

	private ListView journeysListView;
	private ArrayAdapter<String> journeyListAdapter;

	private final List<String> journeysInfoList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Configure to and from
		EditText from = (EditText) findViewById(R.id.from);
		ConfigureTextField(from, FROM_VALUE);

		EditText to = (EditText) findViewById(R.id.to);
		ConfigureTextField(to, TO_VALUE);

		journeysListView = (ListView) findViewById(R.id.journeys_list);

		journeyListAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, journeysInfoList);
		journeysListView.setAdapter(journeyListAdapter);
		// set click listener show journey on the journeysListView
		// journeysListView
		journeysListView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent,
							final View view, int position, long id) {
						Intent intent = new Intent(MainActivity.this,
								DisplayJourneyActivity.class);
						final String item = (String) parent
								.getItemAtPosition(position);
						intent.putExtra(EXTRA_MESSAGE, item);
						startActivity(intent);
					}

				});
	}

	private void ConfigureTextField(EditText from, final int staticStringId) {
		android.view.View.OnClickListener fromClickListener = new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,
						SearchViewStationsActivity.class);
				startActivityForResult(intent, staticStringId);
			}
		};
		from.setOnClickListener(fromClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void getJourneys(View view) {
		// XXX: This should change with the real Journeys:
		Search search = createSearch();
		if (search != null) {
			JourneyPlanner planner = new JourneyPlanner();
			Journeys computeJourneys = planner.computeJourneys(search);
			Log.i("info", "heloooooo " + computeJourneys.toString());
			journeysInfoList.clear();
			for (Journey journey : computeJourneys.getJourneys()) {
				Log.i("info", journey.toString());
				journeysInfoList.add(journey.toString());
			}
			((BaseAdapter) journeysListView.getAdapter())
					.notifyDataSetChanged();
		}
	}

	private Search createSearch() {
		EditText from = (EditText) findViewById(R.id.from);
		String start = from.getText().toString();
		System.out.println(start);
		EditText to = (EditText) findViewById(R.id.to);
		String end = to.getText().toString();
		System.out.println(end);

		if (start != null && !start.isEmpty() && !start.equals(end)
				&& end != null && !end.isEmpty()) {
			Stops actualStart = null;
			Stops actualEnd = null;
			for (Stops s : Stops.values()) {
				if (s.getName().get().equals(start)) {
					actualStart = s;
				}
				if (s.getName().get().equals(end)) {
					actualEnd = s;
				}
			}
			Search search = new Search();
			search.setStart(actualStart);
			search.setDestination(actualEnd);
			// XXX: This needs to change
			search.setStartTime(Optional.of("06:20"));
			return search;
		} else {
			return null;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case (MainActivity.FROM_VALUE): {
			if (resultCode == Activity.RESULT_OK) {
				EditText from = (EditText) findViewById(R.id.from);
				from.setText(data
						.getStringExtra(SearchViewStationsActivity.SEARCH_STATION_ID));
			}
			break;
		}
		case (MainActivity.TO_VALUE): {
			if (resultCode == Activity.RESULT_OK) {
				EditText to = (EditText) findViewById(R.id.to);
				to.setText(data
						.getStringExtra(SearchViewStationsActivity.SEARCH_STATION_ID));
			}
			break;
		}

		}
	}
}
