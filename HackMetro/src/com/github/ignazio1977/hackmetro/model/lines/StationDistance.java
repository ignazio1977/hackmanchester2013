package com.github.ignazio1977.hackmetro.model.lines;

import com.github.ignazio1977.hackmetro.model.Location;
import com.github.ignazio1977.hackmetro.model.NamedLocation;
import com.github.ignazio1977.hackmetro.model.Station;

public class StationDistance {
	private NamedLocation station;
	private double distance;
	
	private Line line;

	public double getDistance() {
		return distance;
	}

	public StationDistance withDistance(double distance) {
		this.distance = distance;return this;
	}

	public NamedLocation getStation() {
		return station;
	}

	public StationDistance withStation(NamedLocation station) {
		this.station = station;return this;
	}

	public Line getLine() {
		return line;
	}

	public StationDistance withLine(Line line) {
		this.line = line;return this;
	}

}
