package com.hxcodes.janna.serialize.json;

import org.springframework.util.ClassUtils;

public class JsonSerializerFactory {
	public static JsonSerializer createInstance() throws ClassNotFoundException {
		if (ClassUtils.isPresent("com.google.gson.Gson", null)) {
			return new GsonSerializer();
		}

		if (ClassUtils.isPresent("com.fasterxml.jackson.databind.ObjectMapper", null)) {
			return new JacksonSerializer();
		}

		if (ClassUtils.isPresent("com.alibaba.fastjson.JSONObject", null)) {
			return new FastJsonSerializer();
		}

		throw new ClassNotFoundException();
	}
}