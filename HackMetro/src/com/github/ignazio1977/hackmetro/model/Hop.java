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
}
