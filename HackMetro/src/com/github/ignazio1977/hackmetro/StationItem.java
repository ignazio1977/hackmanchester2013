package com.github.ignazio1977.hackmetro;

import com.github.ignazio1977.hackmetro.model.Station;

public class StationItem {
	private final Station station;
	private final String icon;

	public StationItem(Station station, String icon) {
		this.station = station;
		this.icon = icon;
	}
}
