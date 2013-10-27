package com.github.ignazio1977.hackmetro.model.lines;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.github.ignazio1977.hackmetro.model.Hop;
import com.github.ignazio1977.hackmetro.model.Location;
import com.github.ignazio1977.hackmetro.model.Spot;
import com.github.ignazio1977.hackmetro.model.NamedLocation;
import com.github.ignazio1977.hackmetro.model.Trip;
import com.github.ignazio1977.hackmetro.model.enums.Stops;
import com.github.ignazio1977.hackmetro.model.enums.TripsMET1I;
import com.github.ignazio1977.hackmetro.model.enums.TripsMET1O;
import com.github.ignazio1977.hackmetro.model.enums.TripsMET2I;
import com.github.ignazio1977.hackmetro.model.enums.TripsMET2O;
import com.github.ignazio1977.hackmetro.model.enums.TripsMET3I;
import com.github.ignazio1977.hackmetro.model.enums.TripsMET3O;
import com.github.ignazio1977.hackmetro.model.enums.TripsMET4I;
import com.github.ignazio1977.hackmetro.model.enums.TripsMET4O;
import com.github.ignazio1977.hackmetro.model.enums.TripsMET5I;
import com.github.ignazio1977.hackmetro.model.enums.TripsMET5I_2;
import com.github.ignazio1977.hackmetro.model.enums.TripsMET5O;
import com.github.ignazio1977.hackmetro.model.enums.TripsMET5O_2;

/** Represents a line, i.e., a collection of stations. */
public enum Line {
	ROUTEMET1I {
		@Override
		public List<Trip> getTrips() {
			List<Trip> toReturn = new ArrayList<Trip>();
			for (Trip t : TripsMET1I.values()) {
				toReturn.add(t);
			}
			return toReturn;
		}
	},
	ROUTEMET1O {
		@Override
		public List<Trip> getTrips() {
			List<Trip> toReturn = new ArrayList<Trip>();
			for (Trip t : TripsMET1O.values()) {
				toReturn.add(t);
			}
			return toReturn;
		}
	},
	ROUTEMET2I {
		@Override
		public List<Trip> getTrips() {
			List<Trip> toReturn = new ArrayList<Trip>();
			for (Trip t : TripsMET2I.values()) {
				toReturn.add(t);
			}
			return toReturn;
		}
	},
	ROUTEMET2O {
		@Override
		public List<Trip> getTrips() {
			List<Trip> toReturn = new ArrayList<Trip>();
			for (Trip t : TripsMET2O.values()) {
				toReturn.add(t);
			}
			return toReturn;
		}
	},
	ROUTEMET3I {
		@Override
		public List<Trip> getTrips() {
			List<Trip> toReturn = new ArrayList<Trip>();
			for (Trip t : TripsMET3I.values()) {
				toReturn.add(t);
			}
			return toReturn;
		}
	},
	ROUTEMET3O {
		@Override
		public List<Trip> getTrips() {
			List<Trip> toReturn = new ArrayList<Trip>();
			for (Trip t : TripsMET3O.values()) {
				toReturn.add(t);
			}
			return toReturn;
		}
	},
	ROUTEMET4I {
		@Override
		public List<Trip> getTrips() {
			List<Trip> toReturn = new ArrayList<Trip>();
			for (Trip t : TripsMET4I.values()) {
				toReturn.add(t);
			}
			return toReturn;
		}
	},
	ROUTEMET4O {
		@Override
		public List<Trip> getTrips() {
			List<Trip> toReturn = new ArrayList<Trip>();
			for (Trip t : TripsMET4O.values()) {
				toReturn.add(t);
			}
			return toReturn;
		}
	},
	ROUTEMET5I {
		@Override
		public List<Trip> getTrips() {
			List<Trip> toReturn = new ArrayList<Trip>();
			for (Trip t : TripsMET5I.values()) {
				toReturn.add(t);
			}
			return toReturn;
		}
	},
	ROUTEMET5O {
		@Override
		public List<Trip> getTrips() {
			List<Trip> toReturn = new ArrayList<Trip>();
			for (Trip t : TripsMET5O.values()) {
				toReturn.add(t);
			}
			return toReturn;
		}
	},
	ROUTEMET5I_2 {
		@Override
		public List<Trip> getTrips() {
			List<Trip> toReturn = new ArrayList<Trip>();
			for (Trip t : TripsMET5I_2.values()) {
				toReturn.add(t);
			}
			return toReturn;
		}
	},
	ROUTEMET5O_2 {
		@Override
		public List<Trip> getTrips() {
			List<Trip> toReturn = new ArrayList<Trip>();
			for (Trip t : TripsMET5O_2.values()) {
				toReturn.add(t);
			}
			return toReturn;
		}
	};

	public List<NamedLocation> getStations() {
		Set<Stops> set = new LinkedHashSet<Stops>();
		for (Trip t : getTrips()) {
			for (Stops stop : t.getStops()) {
				set.add(stop);
			}
		}
		return new ArrayList<NamedLocation>(set);
	}

	public abstract List<Trip> getTrips();

	/**
	 * @param spot
	 *            a spot to match
	 * @return true if the spot provided is a station on this line. This method
	 *         does not do any approximate search, i.e., will not return the
	 *         closest station to the searched spot.
	 */
	public boolean containsStation(Location spot) {
		for (NamedLocation s : getStations()) {
			if (spot instanceof NamedLocation
					&& s.getName().equals(((NamedLocation) spot).getName())) {
				return true;
			}
			if (spot.getLatitude().equals(s.getLatitude())
					&& spot.getLongitude().equals(s.getLongitude())) {
				return true;
			}
		}
		return false;
	}

	public StationDistance findClosestStation(Location spot) {
		NamedLocation closest = null;
		double closestDistance = Double.MAX_VALUE;
		for (NamedLocation s : getStations()) {
			double distance = Distances.distance(s, spot);
			if (distance < closestDistance) {
				closest = s;
				closestDistance = distance;
			}
		}
		return new StationDistance().withStation(closest)
				.withDistance(closestDistance).withLine(this);
	}

	/**
	 * @return the best hop if this line has trips which stop at a and b and have a stop
	 *         closer to a than to b and the time at point a is before the time
	 *         at point b
	 */
	public Hop goesTowards(NamedLocation a, NamedLocation b, String currentTime) {
		if (getStations().contains(b) && getStations().contains(a)) {
			for (Trip t : getTrips()) {
				if (t.getTime(a).compareTo(t.getTime(b)) < 0
						&& t.getTime(a).compareTo(currentTime) > 0) {
					// a valid trip that we can still catch
					Hop hop = new Hop();
					hop.setTrip(t);
					hop.setStart(a);
					hop.setDestination(b);
					return hop;
				}
			}
		}
		return null;
	}
	/**
	 * @return the best hop if this line has trips which stop at b and have a stop
	 *         closer to a than to b and the time at point a is before the time
	 *         at point b
	 */
	public Hop goesTowardsBestAttempt(Location a, NamedLocation b, String currentTime) {
		return goesTowards(findClosestStation(a).getStation(), b, currentTime);
	}
}
