package com.github.ignazio1977.hackmetro.model.compiledata;

public class StopUpdater {
	private String id;
	private double longitude;
	private double latitude;
	private String name;

	public String getId() {
		return id;
	}

	public StopUpdater withId(String id) {
		this.id = id;
		return this;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setName(String s) {
		this.name = s;
	}
@Override
public String toString() {
	return id+"\t"+name+"\t"+latitude+"\t"+longitude;
}

public String entry() {
	return id+"("+name+", "+latitude+","+longitude+"),";
}
}
