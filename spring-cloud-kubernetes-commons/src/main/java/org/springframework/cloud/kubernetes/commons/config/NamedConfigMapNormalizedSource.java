/*
 * Copyright 2013-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.kubernetes.commons.config;

import java.util.Objects;

/**
 * A config map source that is based on name.
 *
 * @author wind57
 */
public final class NamedConfigMapNormalizedSource extends NormalizedSource {

	private final String prefix;

	private final boolean includeProfileSpecificSources;

	public NamedConfigMapNormalizedSource(String name, String namespace, boolean failFast, String prefix,
			boolean includeProfileSpecificSources) {
		super(name, namespace, failFast);
		this.prefix = Objects.requireNonNull(prefix);
		this.includeProfileSpecificSources = includeProfileSpecificSources;
	}

	public String prefix() {
		return prefix;
	}

	public boolean profileSpecificSources() {
		return includeProfileSpecificSources;
	}

	@Override
	public NormalizedSourceType type() {
		return NormalizedSourceType.NAMED_CONFIG_MAP;
	}

	@Override
	public String target() {
		return "Config Map";
	}

	@Override
	public String toString() {
		return "{ config-map name : '" + name() + "', namespace : '" + namespace() + "', prefix : '" + prefix() + "' }";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		NamedConfigMapNormalizedSource other = (NamedConfigMapNormalizedSource) o;
		return Objects.equals(this.name(), other.name()) && Objects.equals(this.namespace(), other.namespace());
	}

	@Override
	public int hashCode() {
		return Objects.hash(name(), namespace());
	}

}
