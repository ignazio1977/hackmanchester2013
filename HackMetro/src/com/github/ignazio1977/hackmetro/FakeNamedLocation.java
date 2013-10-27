package com.github.ignazio1977.hackmetro;

import com.github.ignazio1977.hackmetro.model.NamedLocation;
import com.google.common.base.Optional;

public class FakeNamedLocation implements NamedLocation {
	private Optional<String> name = Optional.absent();

	public FakeNamedLocation(String name) {
		this.name = Optional.of(name);
	}

	@Override
	public Optional<Double> getLongitude() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Double> getLatitude() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<String> getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
