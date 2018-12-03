package com.hxcodes.janna.serialize.json;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.hxcodes.janna.utils.CodeUtils;

public class FastJsonSerializer implements JsonSerializer {

	@Override
	public <T> T fromJson(String json, Class<T> target) {
		return CodeUtils.isNotBlank(json) ? JSONObject.parseObject(json, target) : null;
	}

	@Override
	public String toJson(Object obj) {
		return CodeUtils.isNull(obj) ? EMPTY_OBJECT : JSONObject.toJSONString(obj);
	}

	@Override
	public <T> List<T> fromJsonToArray(String json, Class<T> target) {
		List<T> result = Lists.newArrayList();
		if (CodeUtils.isNotBlank(json)) {
			try {
				if (isArray(json)) {
					result.addAll(JSONObject.parseArray(json, target));
				} else {
					T t = fromJson(json, target);
					result.add(t);
				}
			} catch (Exception e) {
				LOGGER.error("parse json 2 array fail, json:{}, target clz:{}", json, target.getName(), e);
			}

		}
		return result;
	}
}
