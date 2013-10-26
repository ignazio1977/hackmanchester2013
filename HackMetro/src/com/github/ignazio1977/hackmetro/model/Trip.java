package com.github.ignazio1977.hackmetro.model;

import com.github.ignazio1977.hackmetro.model.enums.Stops;

public interface Trip {
String getHeadline();
Iterable<Stops> getStops();
}
