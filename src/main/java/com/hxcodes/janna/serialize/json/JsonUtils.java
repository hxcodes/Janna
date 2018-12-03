package com.hxcodes.janna.serialize.json;

import java.util.List;

public class JsonUtils {
	private static JsonSerializer SERIALIZER = JsonSerializerFactory.createInstance();

	public static <T> T fromJson(String json, Class<T> target) {
		return SERIALIZER.fromJson(json, target);
	}

	public static String toJson(Object obj) {
		return SERIALIZER.toJson(obj);
	}

	public static boolean isArray(String json) {
		return SERIALIZER.isArray(json);
	}

	public static <T> List<T> fromJsonToArray(String json, Class<T> target) {
		return SERIALIZER.fromJsonToArray(json, target);
	}
}