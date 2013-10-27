package com.github.ignazio1977.hackmetro;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.github.ignazio1977.hackmetro.model.NamedLocation;
import com.github.ignazio1977.hackmetro.model.enums.Stops;

public class SearchViewStationsActivity extends Activity implements
		SearchView.OnQueryTextListener {

	protected static final String SEARCH_STATION_ID = "SearchViewFilterMode";
	private SearchView mSearchView;
	private ListView mListView;
	private ArrayAdapter<String> mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_stations);

		mSearchView = (SearchView) findViewById(R.id.search_view);
		mListView = (ListView) findViewById(R.id.list_view);

		List<NamedLocation> asNamedLocations = Stops.asNamedLocations();
		List<String> stops = Utils.extractStringLocation(asNamedLocations);
		mListView.setAdapter(mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, stops));
		mListView.setTextFilterEnabled(true);
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {
				final String station = (String) parent
						.getItemAtPosition(position);
				mSearchView.setQuery(station, false);
			}

		});
		setupSearchView();
	}

	private void setupSearchView() {
		mSearchView.setIconifiedByDefault(false);
		mSearchView.setOnQueryTextListener(this);
		mSearchView.setSubmitButtonEnabled(false);
		// mSearchView.setQueryHint(getString(R.string.cheese_hunt_hint));
	}

	@Override
	public boolean onQueryTextChange(String arg0) {
		if (TextUtils.isEmpty(arg0)) {
			mListView.clearTextFilter();
		} else {
			mListView.setFilterText(arg0.toString());
		}
		return true;
	}

	@Override
	public boolean onQueryTextSubmit(String searchText) {
		Intent resultIntent = new Intent();
		resultIntent.putExtra(SEARCH_STATION_ID, searchText);
		setResult(Activity.RESULT_OK, resultIntent);
		finish();
		return false;
	}

}
