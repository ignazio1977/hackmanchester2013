package com.github.ignazio1977.hackmetro.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** All the available journeys between a start spot and an end spot. */
public class Journeys {
	private final List<Journey> journeys = new ArrayList<Journey>();

	/**
	 * @param journey
	 *            journey to add to the collection of journeys
	 */
	public void addJourney(Journey journey) {
		journeys.add(journey);
	}

	/**
	 * Sort the list of journeys.
	 * 
	 * @param comparator
	 *            a comparator to sort the list of journeys, e.g., by start
	 *            time, by duration, or by number of changes
	 */
	public void sort(Comparator<Journey> comparator) {
		try {
			Collections.sort(journeys, comparator);
		} catch (IllegalArgumentException e) {
			// if a comparator is badly defined, Java might throw an exception
			// in this case we do not want to abort the application, just leave
			// the collection unsorted.
		}
	}
}
