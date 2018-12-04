package com.hxcodes.janna.serialize.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;

public class JsonSerializerFactory {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonSerializerFactory.class);

	public static JsonSerializer createInstance() throws ClassNotFoundException {
		if (ClassUtils.isPresent("com.google.gson.Gson", null)) {
			LOGGER.info("json serializer created by gson");
			return new GsonSerializer();
		}

		if (ClassUtils.isPresent("com.fasterxml.jackson.databind.ObjectMapper", null)) {
			LOGGER.info("json serializer created by jackson");
			return new JacksonSerializer();
		}

		if (ClassUtils.isPresent("com.alibaba.fastjson.JSONObject", null)) {
			LOGGER.info("json serializer created by fastjson");
			return new FastJsonSerializer();
		}

		throw new ClassNotFoundException("must import json process library, GSON, or FASTJSON, or JACKSON");
	}
}