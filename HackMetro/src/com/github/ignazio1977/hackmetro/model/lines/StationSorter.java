package com.github.ignazio1977.hackmetro.model.lines;

import java.util.Comparator;

public class StationSorter implements Comparator<StationDistance> {

	@Override
	public int compare(StationDistance arg0, StationDistance arg1) {
		return Double.compare(arg0.getDistance(), arg1.getDistance());
	}

}
