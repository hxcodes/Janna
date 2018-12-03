package com.hxcodes.janna.serialize.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.hxcodes.janna.utils.CodeUtils;

public class JacksonSerializer implements JsonSerializer {
	private static ObjectMapper mapper = new ObjectMapper();

	@Override
	public <T> T fromJson(String json, Class<T> target) {
		try {
			return mapper.readValue(json, target);
		} catch (IOException e) {
			LOGGER.error("parse json 2 object error, json:{}, target clz:{}", json, target.getName(), e);
		}

		return null;
	}

	@Override
	public String toJson(Object obj) {
		try {
			return CodeUtils.isNull(obj) ? EMPTY_OBJECT : mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOGGER.error("parse object 2 json error, obj clzz:{}", obj.getClass().getName(), e);
		}

		return EMPTY_OBJECT;
	}

	@Override
	public <T> List<T> fromJsonToArray(String json, Class<T> target) {
		JavaType javaType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, target);
		try {
			return mapper.readValue(json, javaType);
		} catch (IOException e) {
			LOGGER.error("parse json 2 collection error, json:{}, collection clz:{}", json, target.getName(), e);
		}

		return Lists.newArrayList();
	}

}