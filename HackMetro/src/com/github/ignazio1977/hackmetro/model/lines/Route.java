//package com.github.ignazio1977.hackmetro.model.lines;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeSet;
//
//import com.github.ignazio1977.hackmetro.model.compiledata.TripUpdater;
//import com.github.ignazio1977.hackmetro.model.enums.Trips;
//import com.google.common.base.Supplier;
//import com.google.common.collect.Multimap;
//import com.google.common.collect.Multimaps;
//
//import android.R.integer;
//
//public class Route {
//	// private Set<Integer> services=new TreeSet<Integer>();
//	private Multimap<String, Trips> trips = Multimaps.newMultimap(
//			new HashMap<String, Collection<Trips>>(),
//			new Supplier<Collection<Trips>>() {
//
//				@Override
//				public Collection<Trips> get() {
//					return new LinkedHashSet<Trips>();
//				}
//			});
//	private Set<String> tripNames = new HashSet<String>();
//	private String name;
//
//	public Route(String n) {
//		name = n;
//	}
//
//	public void addService(String s) {
//		// services.add(Integer.parseInt(s.replace("Serv", "")));
//	}
//
//	public void addTrip(String s, String head) {
//		tripNames.add(s);
//		trips.put(head, Trips.valueOf(s));
//
//	}
//
//	public Set<String> usedTrips() {
//		return tripNames;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	@Override
//	public String toString() {
//
//		return name + "\t" + trips;
//	}
//
//	public boolean containsTrip(String name2) {
//		return tripNames.contains(name2);
//	}
//
//	public Trips getTrip(String name2) {
//		for (Trips t : trips.values()) {
//			if (t.name().equals(name2)) {
//				return t;
//			}
//		}
//		return null;
//	}
//
//	public Iterable<Trips> getTrips() {
//		return trips.values();
//	}
//
// }
