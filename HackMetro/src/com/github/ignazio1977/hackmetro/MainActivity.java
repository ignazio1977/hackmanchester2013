package com.github.ignazio1977.hackmetro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	public static final String EXTRA_MESSAGE = "com.github.ignazio1977.hackmetro.MESSAGE";
	protected static final int FROM_VALUE = 0;
	protected static final int TO_VALUE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		android.view.View.OnClickListener fromClickListener = new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,
						SearchViewStationsActivity.class);
				startActivityForResult(intent, FROM_VALUE);
			}
		};
		EditText from = (EditText) findViewById(R.id.from);
		from.setOnClickListener(fromClickListener);
		EditText to = (EditText) findViewById(R.id.to);
		android.view.View.OnClickListener toClickListener = new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,
						SearchViewStationsActivity.class);
				startActivityForResult(intent, TO_VALUE);
			}
		};
		to.setOnClickListener(toClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void getJourneys(View view) {
		Intent intent = new Intent(this, DisplayJourneysActivity.class);
		EditText fromText = (EditText) findViewById(R.id.from);
		EditText toText = (EditText) findViewById(R.id.to);
		String message = toText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
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
