package com.github.ignazio1977.hackmetro.model;

import com.google.common.base.Optional;

public interface NamedLocation extends Location {
	Optional<String> getName();
}
