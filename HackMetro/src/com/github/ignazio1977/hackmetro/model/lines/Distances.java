package com.github.ignazio1977.hackmetro.model.lines;

import com.github.ignazio1977.hackmetro.model.Location;
import com.github.ignazio1977.hackmetro.model.Spot;
import com.google.common.base.Optional;

public class Distances {
	/**
	 * @param a
	 *            first spot
	 * @param b
	 *            second spot
	 * @return Euclidean distance between two spots.
	 */
	public static double distance(Location a, Location b) {
		double x = distance(a.getLongitude(), b.getLongitude());
		double y = distance(a.getLatitude(), b.getLatitude());
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * @return distance between two doubles; if they have the same sign, this is
	 *         their difference; if the have different signs, the difference is
	 *         the sum of the absolute values.
	 */
	public static double distance(Optional<Double> a, Optional<Double> b) {
		if (Math.signum(a.get()) != Math.signum(b.get())) {
			return Math.abs(a.get()) + Math.abs(b.get());
		}
		return Math.abs(a.get() - b.get());
	}
}
