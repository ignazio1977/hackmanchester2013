package com.github.ignazio1977.hackmetro.model;

import com.google.common.base.Optional;

public class Station extends Spot implements NamedLocation {
	private Optional<String> name = Optional.absent();

	public Optional<String> getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Optional.of(name);
	}

}
