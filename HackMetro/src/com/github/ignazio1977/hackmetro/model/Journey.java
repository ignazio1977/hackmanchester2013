package com.github.ignazio1977.hackmetro.model;

import java.util.ArrayList;
import java.util.List;

/**A journey is a sequence of hops between a start spot and an end spot.*/
public class Journey {
	private final List<Hop> hops = new ArrayList<Hop>();
	public void addHop(Hop hop){
		hops.add(hop);
	}

	/**@return all the hops in this journey.*/
	public Iterable<Hop> getHops() {
		return hops;
	}
	/**@return the number of hops in this journey.*/
	public int size() {
		return hops.size();
	}
}
