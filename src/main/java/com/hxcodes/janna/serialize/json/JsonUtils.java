package com.hxcodes.janna.serialize.json;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

	private static JsonSerializer SERIALIZER = null;
	static {
		try {
			SERIALIZER = JsonSerializerFactory.createInstance();
		} catch (ClassNotFoundException e) {
			LOGGER.error("Json library must be introduced, GSON, or FASTJSON, or JACKSON", e);
		}
	}

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