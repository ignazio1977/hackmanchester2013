package com.github.ignazio1977.hackmetro.model;

import java.util.Set;

import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.v4.content.ContextCompat;

import com.github.ignazio1977.hackmetro.model.lines.ClosestStations;
import com.github.ignazio1977.hackmetro.model.lines.Line;
import com.github.ignazio1977.hackmetro.model.lines.StationDistance;

public class JourneyPlanner {

	public JourneyPlanner() {
	}

	/**
	 * @param search
	 *            search criteria to determine a collection of journeys.
	 *            Includes start and end spot, and expected departure time.
	 * @return a collection of journeys that allow to move from start spot to
	 *         end spot.
	 */
	public Journeys computeJourneys(Search search) {
		Journeys journeys = new Journeys();
		ClosestStations destination = new ClosestStations();
		for (Line l : Line.values()) {
			StationDistance d = l.findClosestStation(search.getDestination());
			destination.addStation(d);
		}
		ClosestStations source = new ClosestStations();
		for (Line l : Line.values()) {
			StationDistance d = l.findClosestStation(search.getStart().get());
			source.addStation(d);
		}
		
		Set<Line> lines=destination.getLines();
		lines.retainAll(source.getLines());
		
		System.out.println("JourneyPlanner.computeJourneys() destination: "
				+ search.getDestination());
		StationDistance next = destination.getStationDistances().iterator().next();
		System.out
				.println("JourneyPlanner.computeJourneys() closest station: "
						+ next);
		StationDistance next2 = source.getStationDistances().iterator().next();
		System.out
				.println("JourneyPlanner.computeJourneys() closest station to source: "
						+ next2);
		System.out.println("candidate lines: "+next.getLine()+" "+next2.getLine());
		return journeys;
	}
}
