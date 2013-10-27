package com.github.ignazio1977.hackmetro.model.lines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClosestStations {
	private List<StationDistance> stations = new ArrayList<StationDistance>();
	private boolean sorted = false;

	public void addStation(StationDistance stationDistance) {
		stations.add(stationDistance);
		sorted = false;
	}

	public Iterable<StationDistance> getStationDistances() {
		if (!sorted) {
			Collections.sort(stations, new StationSorter());
			sorted = true;
		}
		return stations;
	}
	public Set<Line> getLines(){
		Set<Line> set=new HashSet<Line>();
		for(StationDistance d:stations) {
			set.add(d.getLine());
		}
		return set;
	}
}
