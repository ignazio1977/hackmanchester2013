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

	/** duration of the hop in minutes */
	public int duration() {
		String[] startTime = getStartTime().split(":");
		String[] endTime = getDestinationTime().split(":");
		int start = Integer.parseInt(startTime[0]) * 60
				+ Integer.parseInt(startTime[1]);
		int end = Integer.parseInt(endTime[0]) * 60
				+ Integer.parseInt(endTime[1]);
		// can go wrong after midnight
		return end - start;
	}
	@Override
	public String toString() {
		return start+" ("+getStartTime()+") -> "+stop+" ("+getDestinationTime()+") duration: "+duration();

	}

}
