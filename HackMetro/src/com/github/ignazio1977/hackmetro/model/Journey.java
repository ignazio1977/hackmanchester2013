package com.github.ignazio1977.hackmetro.model;

import java.util.ArrayList;
import java.util.List;

/** A journey is a sequence of hops between a start spot and an end spot. */
public class Journey {
	private final List<Hop> hops = new ArrayList<Hop>();

	/**Add a hop. Insertion happens at the top of the list, so the first hop added is the last hop to be followed.*/
	public void addFirstHop(Hop hop) {
		hops.add(0,hop);
	}

	/** @return all the hops in this journey. */
	public List<Hop> getHops() {
		return hops;
	}

	/** @return the number of hops in this journey. */
	public int size() {
		return hops.size();
	}
	@Override
	public String toString() {
		
		return "hops: "+size()+" "+hops;
	}
}
