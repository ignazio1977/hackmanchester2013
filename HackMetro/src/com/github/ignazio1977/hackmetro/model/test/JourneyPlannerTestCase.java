package com.github.ignazio1977.hackmetro.model.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.github.ignazio1977.hackmetro.model.JourneyPlanner;
import com.github.ignazio1977.hackmetro.model.Journeys;
import com.github.ignazio1977.hackmetro.model.NamedLocation;
import com.github.ignazio1977.hackmetro.model.Search;
import com.github.ignazio1977.hackmetro.model.Spot;
import com.github.ignazio1977.hackmetro.model.Station;
import com.github.ignazio1977.hackmetro.model.lines.Distances;
import com.github.ignazio1977.hackmetro.model.lines.Line;
import com.github.ignazio1977.hackmetro.model.lines.StationDistance;

public class JourneyPlannerTestCase {
	private JourneyPlanner testSubject;

	@Before
	public void setUp() {
		testSubject = new JourneyPlanner();

	}

	@Test
	public void shouldCreateJourneys() {
		// given
		Search search = new Search();
		// when
		Journeys journeys = testSubject.computeJourneys(search);
		// then
		assertNotNull(journeys);
	}

	@Test
	public void shouldFindStationOnLineByName() {
		for (Line line : Line.values()) {
			// given
			for (NamedLocation l : line.getStations()) {
				// when
				boolean result = line.containsStation(l);
				// then
				assertTrue(line+" "+l,result);
			}
		}
	}

	@Test
	public void testDistance() {
		// given
		Spot a = new Spot();
		a.setLongitude(100);
		a.setLatitude(100);
		Spot b = new Spot();
		b.setLongitude(100);
		b.setLatitude(100);
		// when
		double distance = Distances.distance(a, b);
		// then
		assertEquals(0D, distance, 0.0001);
		distance = Distances.distance(b, a);
		assertEquals(0D, distance, 0.0001);
		// given
		b.setLongitude(-100);
		b.setLatitude(-100);
		// when
		distance = Distances.distance(a, b);
		// then
		assertEquals(Math.sqrt(80000), distance, 0.0001);
		// given
		b.setLongitude(-100);
		b.setLatitude(0);
		// when
		distance = Distances.distance(a, b);
		// then
		assertEquals(Math.sqrt(50000), distance, 0.0001);
	}

	@Test
	public void shouldFindClosestStation() {
		for (Line line : Line.values()) {
			// given
			Spot station1 = new Station();
			station1.setLatitude(100);
			station1.setLongitude(100);
			Spot station2 = new Station();
			station2.setLatitude(50);
			station2.setLongitude(50);
			Spot station3 = new Station();
			station3.setLatitude(150);
			station3.setLongitude(150);

			Spot spot = new Spot();
			spot.setLatitude(100);
			spot.setLongitude(100);
			// when
			StationDistance result = line.findClosestStation(spot);
			// then
			assertNotNull(result.getStation());
			assertEquals(Distances.distance(spot, result.getStation()), (double) result.getDistance(), 0.0001);
			// given
			spot.setLatitude(1);
			spot.setLongitude(1);
			// when
			result = line.findClosestStation(spot);
			// then
			assertNotNull(result.getStation());
			assertEquals(Distances.distance(spot, result.getStation()), (double) result.getDistance(), 0.0001);
			// given
			spot.setLatitude(200);
			spot.setLongitude(200);
			// when
			result = line.findClosestStation(spot);
			// then
			assertNotNull(result.getStation());
			assertEquals(Distances.distance(spot, result.getStation()), (double) result.getDistance(), 0.0001);
		}
	}
}
