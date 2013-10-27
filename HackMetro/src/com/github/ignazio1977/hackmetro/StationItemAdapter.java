package com.github.ignazio1977.hackmetro;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ignazio1977.hackmetro.model.Hop;
import com.github.ignazio1977.hackmetro.model.Journey;
import com.github.ignazio1977.hackmetro.model.Station;

public class StationItemAdapter extends ArrayAdapter<Station> {

	private final Context context;
	// private final String[] Ids;
	private final int rowResourceId;
	private final Journey journey;

	private final int lastPosition;

	public StationItemAdapter(Context context, int textViewResourceId,
			Journey journey) {
		super(context, textViewResourceId);
		this.context = context;
		this.rowResourceId = textViewResourceId;
		this.journey = journey;
		this.lastPosition = getLastPosition();
	}

	private int getLastPosition() {
		Iterator<Hop> hopsIt = journey.getHops().iterator();
		int counter = 0;
		while (hopsIt.hasNext()) {
			counter++;
		}
		return counter;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(rowResourceId, parent, false);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
		TextView textView = (TextView) rowView.findViewById(R.id.textView);

		Station item = getItem(position);
		// textView.setText(item.getName().get());
		textView.setText("test");
		String imageFile = getImageFile(position);

		// get input stream
		try {
			InputStream ims = context.getAssets().open(imageFile);
			// load image as Drawable
			Drawable d = Drawable.createFromStream(ims, "src");
			// set image to ImageView
			imageView.setImageDrawable(d);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rowView;
	}

	private String getImageFile(int position) {
		if (position == 0) {
			return "ic_start.png";
		} else if (position == lastPosition) {
			return "ic_end.png";
		} else {
			return "ic_change.png";
		}
	}

	@Override
	public Station getItem(int position) {
		// TODO Auto-generated method stub
		return super.getItem(position);
	}
}
