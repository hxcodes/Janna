package com.hxcodes.janna.serialize.json;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.hxcodes.janna.costs.DatePatterns;
import com.hxcodes.janna.utils.CodeUtils;

public class GsonSerializer implements JsonSerializer {
	private Gson gson = new GsonBuilder().enableComplexMapKeySerialization().serializeNulls()
			.setDateFormat(DatePatterns.DEFAULT).setVersion(1.0).create();
	private JsonParser parser = new JsonParser();

	@Override
	public <T> T fromJson(String json, Class<T> target) {
		return this.gson.fromJson(json, target);
	}

	@Override
	public String toJson(Object obj) {
		return CodeUtils.isNull(obj) ? EMPTY_OBJECT : gson.toJson(obj);
	}

	@Override
	public <T> List<T> fromJsonToArray(String json, Class<T> target) {
		JsonElement element = this.parser.parse(json);
		List<T> result = Lists.newArrayList();

		if (element.isJsonObject()) {
			CollectionUtils.addIgnoreNull(result, gson.fromJson(element, target));
		} else if (element.isJsonArray()) {
			element.getAsJsonArray().forEach(ele -> {
				CollectionUtils.addIgnoreNull(result, gson.fromJson(ele, target));
			});
		}

		return result;
	}
}