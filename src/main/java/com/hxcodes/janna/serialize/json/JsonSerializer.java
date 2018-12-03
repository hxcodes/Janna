package com.hxcodes.janna.serialize.json;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.hxcodes.janna.costs.Symbols;

public interface JsonSerializer {
	<T> T fromJson(String json, Class<T> target);

	String toJson(Object obj);

	default boolean isArray(String json) {
		String temp = StringUtils.trimToEmpty(json);
		return StringUtils.startsWith(temp, Symbols.LEFT_SQUARE) && StringUtils.endsWith(temp, Symbols.RIGHT_SQUARE);
	}

	<T> List<T> fromJsonToArray(String json, Class<T> target);
}