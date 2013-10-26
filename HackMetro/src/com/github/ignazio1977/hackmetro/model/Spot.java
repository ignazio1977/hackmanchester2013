package com.github.ignazio1977.hackmetro.model;

import com.google.common.base.*;

public class Spot implements Location{
	private Optional<Double> longitude = Optional.absent();
	private Optional<Double> latitude = Optional.absent();

	public Optional<Double> getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = Optional.of(longitude);
	}

	public Optional<Double> getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude =  Optional.of( latitude);
	}
}
