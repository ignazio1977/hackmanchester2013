package com.github.ignazio1977.hackmetro.model;

import java.util.Date;

import com.google.common.base.Optional;

public class Search {
	private Optional<Location> start = Optional.absent();
	private Location destination;
	private Optional<Date> startTime;
	private Optional<Date> latestTime;

	public Optional<Location> getStart() {
		return start;
	}

	public void setStart(Location start) {
		this.start = Optional.of(start);
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public Optional<Date> getStartTime() {
		return startTime;
	}

	public void setStartTime(Optional<Date> startTime) {
		this.startTime = startTime;
	}

	public Optional<Date> getLatestTime() {
		return latestTime;
	}

	public void setLatestTime(Optional<Date> latestTime) {
		this.latestTime = latestTime;
	}

}
