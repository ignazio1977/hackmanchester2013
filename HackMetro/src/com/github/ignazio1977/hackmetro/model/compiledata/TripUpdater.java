package com.github.ignazio1977.hackmetro.model.compiledata;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.github.ignazio1977.hackmetro.model.enums.Stops;

public class TripUpdater {
	private String name;
	private Map<Stops, String> times = new LinkedHashMap<Stops, String>();

	public String getName() {
		return name;
	}

	public TripUpdater withName(String name) {
		this.name = name;return this;
	}

	public List<Stops> getStops() {
		return new ArrayList<Stops>(times.keySet());
	}

	public Map<Stops, String> getTimes() {
		return times;
	}

	public void addStopTime(Stops stop, String time) {
		this.times.put(stop, time);
	}

	@Override
	public String toString() {
		return name+"\t"+times;
	}

	public String entry(int n) {
		StringBuilder time=new StringBuilder();
		boolean first=true;
		for(Map.Entry<Stops, String> e:times.entrySet()) {
			if(!first) {
				
				time.append(",");
			}
			first=false;
			time.append("\""+e.getValue()+"\"");
		}
		return name+"(STOPS" +n +
						", new String[]{"+time+"}),";
	}

	private String getStopExpression() {
		boolean first=true;
		StringBuilder stop=new StringBuilder();
		for(Map.Entry<Stops, String> e:times.entrySet()) {
			if(!first) {
				
				stop.append(",");

			}
			first=false;
			stop.append(e.getKey());

		}
		return stop.toString();
	}
	public String entrySTOPS() {
		return getStopExpression();
	}
}
