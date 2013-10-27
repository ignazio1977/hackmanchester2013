package com.github.ignazio1977.hackmetro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.ignazio1977.hackmetro.model.Hop;
import com.github.ignazio1977.hackmetro.model.Journey;

public class FakeModel {

	public static final List<String> fakeJourneys = new ArrayList<String>(
			Arrays.asList("12:00 Journey 1", "12:10 Journey 2",
					"12:30 Journey 3"));

	public static final List<String> fakeJourney_1 = new ArrayList<String>(
			Arrays.asList("12:00 Stop 1", "12:10 Stop 2", "12:30 Stop 3"));

	public static final List<String> fakeJourney_2 = new ArrayList<String>(
			Arrays.asList("13:00 Stop 1", "13:10 Stop 2", "13:30 Stop 3"));

	public static final List<String> fakeJourney_3 = new ArrayList<String>(
			Arrays.asList("14:00 Stop 1", "14:10 Stop 2", "14:30 Stop 3"));

	public static List<String> getHopList(String journeyInfo) {
		if (journeyInfo.equals("12:00 Journey 1")) {
			return fakeJourney_1;
		} else if (journeyInfo.equals("12:10 Journey 2")) {
			return fakeJourney_2;
		} else if (journeyInfo.equals("12:30 Journey 3")) {
			return fakeJourney_3;
		} else {
			return new ArrayList<String>();
		}
	}

	public static final Journey fJourney_1 = new Journey();

	public static Journey getFakeJourney(String journeyInfo) {
		Hop hop1 = new Hop();

		return null;
	}
}
