package com.github.ignazio1977.hackmetro.model;

import java.util.Date;

import com.google.common.base.Optional;

public class Search {
	private Optional<Spot> start=Optional.absent();
	private Spot destination;
	private Optional<Date> startTime;
	private Optional<Date> latestTime;

	public Optional<Spot> getStart() {
		return start;
	}

	public void setStart(Spot start) {
		this.start = Optional.of(start);
	}

	public Spot getDestination() {
		return destination;
	}

	public void setDestination(Spot destination) {
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
