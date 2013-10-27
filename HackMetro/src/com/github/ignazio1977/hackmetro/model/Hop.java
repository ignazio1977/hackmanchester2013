package com.github.ignazio1977.hackmetro.model;

public class Hop {

	private Trip trip;
	private NamedLocation start;
	private NamedLocation stop;

	public NamedLocation getStart() {
		return start;
	}

	public NamedLocation getDestination() {
		return stop;
	}

	public String getStartTime() {
		return trip.getTime(start);
	}

	public String getDestinationTime() {
		return trip.getTime(stop);
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public void setStart(NamedLocation start) {
		this.start = start;
	}

	public void setDestination(NamedLocation stop) {
		this.stop = stop;
	}

}
