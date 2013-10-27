package com.github.ignazio1977.hackmetro;

import java.util.ArrayList;
import java.util.List;

import com.github.ignazio1977.hackmetro.model.NamedLocation;

public class Utils {

	public static List<String> extractStringLocation(
			List<NamedLocation> asNamedLocations) {
		List<String> toReturn = new ArrayList<String>(asNamedLocations.size());
		for (NamedLocation loc : asNamedLocations) {
			toReturn.add(loc.getName().get());
		}
		return toReturn;
	}
}
