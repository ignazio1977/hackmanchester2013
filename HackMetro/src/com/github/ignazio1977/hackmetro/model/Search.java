package com.github.ignazio1977.hackmetro.model;

import java.util.Date;

import com.google.common.base.Optional;

public class Search {
	private Optional<Location> start = Optional.absent();
	private Location destination;
	private Optional<String> startTime=Optional.absent();
	private Optional<String> latestTime=Optional.absent();

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

	public Optional<String> getStartTime() {
		return startTime;
	}

	public void setStartTime(Optional<String> startTime) {
		this.startTime = startTime;
	}

	public Optional<String> getLatestTime() {
		return latestTime;
	}

	public void setLatestTime(Optional<String> latestTime) {
		this.latestTime = latestTime;
	}

}
