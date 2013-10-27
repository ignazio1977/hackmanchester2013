package com.github.ignazio1977.hackmetro.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.github.ignazio1977.hackmetro.model.lines.ClosestStations;
import com.github.ignazio1977.hackmetro.model.lines.Line;
import com.github.ignazio1977.hackmetro.model.lines.StationDistance;
import com.google.common.base.Optional;

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
		List<Hop> candidates=new ArrayList<Hop>();
		if(!search.getStartTime().isPresent()) {
			Calendar c=Calendar.getInstance();
			search.setStartTime(Optional.of(c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)));
		}
		
		for (Line l : Line.values()) {
			if(search.getDestination() instanceof NamedLocation && search.getStart().isPresent() && search.getStart().get() instanceof NamedLocation) {
				Hop hop=l.goesTowards((NamedLocation)search.getStart().get(), (NamedLocation)search.getDestination(), search.getStartTime().get());
				if(hop!=null) {
					//direct connection found
					candidates.add(hop);
				}
			}
		}
		if(!candidates.isEmpty()) {
			Collections.sort(candidates, new Comparator<Hop>() {

				@Override
				public int compare(Hop lhs, Hop rhs) {
					return lhs.duration()-rhs.duration();
				}				
			});
			// add all candidates as possible journeys, shortest first
			for(Hop h:candidates) {
				Journey j=new Journey();
				j.addFirstHop(h);
				journeys.addJourney(j);
			}
			return journeys;
		}
		// no direct connection or the endpoints are not stations
		ClosestStations closestDestinationStations=new ClosestStations();
		for (Line l : Line.values()) {
			StationDistance d=l.findClosestStation(search.getDestination());
			closestDestinationStations.addStation(d);
		}
		// d is the closest station among all lines to the target
		NamedLocation d=closestDestinationStations.getStationDistances().iterator().next().getStation();
		for(Line l:Line.values()) {
			Hop hop=l.goesTowardsBestAttempt(search.getStart().get(), d, search.getStartTime().get());
			if(hop!=null) {
				Journey journey=new Journey();
				journey.addFirstHop(hop);
				// one level of recursion
				for(Line l1:Line.values()) {
					Hop hop1=l1.goesTowardsBestAttempt(search.getStart().get(), hop.getStart(), search.getStartTime().get());
					if(hop1!=null) {
						journey.addFirstHop(hop1);
					}
				}
				// even if no second hop has been found, still return the journey
				// these journeys can be sorted by distance of the start point of the first hop
				journeys.addJourney(journey);
			}
		}
		return journeys;
	}
}
