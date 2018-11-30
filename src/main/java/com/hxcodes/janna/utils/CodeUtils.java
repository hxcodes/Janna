package com.hxcodes.janna.utils;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

public class CodeUtils {
	private static final String EMPTY = "";
	private static final String PLACEHOLDER = "{}";
	private static final int EMPTY_LENGTH = 0;

	public static boolean isNotEmpty(String text) {
		return !CodeUtils.isEmpty(text);
	}

	public static boolean isEmpty(String text) {
		return CodeUtils.len(text) == EMPTY_LENGTH;
	}

	public static boolean isNotBlank(String text) {
		return !CodeUtils.isBlank(text);
	}

	public static boolean isBlank(String text) {
		int len;

		if ((len = CodeUtils.len(text)) == EMPTY_LENGTH) {
			return true;
		}

		for (int i = 0; i < len; i++) {
			if (!Character.isWhitespace(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static String join(Object... objects) {
		int len;
		if ((len = CodeUtils.len(objects)) == EMPTY_LENGTH) {
			return EMPTY;
		}

		StringBuilder builder = new StringBuilder(len * 8);
		for (int i = 0; i < len; i++) {
			builder.append(objects[i]);
		}
		return builder.toString();
	}

	public static String fmt(String pattern, Object... args) {
		if (CodeUtils.isBlank(pattern)) {
			return EMPTY;
		}

		int argsLen = args.length, strLen = pattern.length();
		StringBuilder builder = new StringBuilder(strLen + 36).append(pattern);

		int offset = 0, argIdex = 0;
		while (offset < strLen && argIdex < argsLen) {
			offset = builder.indexOf(PLACEHOLDER, offset);
			Object value = CodeUtils.isNull(args[argIdex++]) ? EMPTY : args[argIdex++];
			builder.delete(offset, offset + 2).insert(offset, value);
			offset += 2;
		}

		return builder.toString();
	}

	public static boolean isNull(Object obj) {
		return null == obj;
	}

	public static boolean isNotNull(Object obj) {
		return null != obj;
	}

	public static int len(String text) {
		return null == text ? 0 : text.length();
	}

	public static int len(Object[] objects) {
		return null == objects ? 0 : objects.length;
	}

	public static int size(Collection<?> collect) {
		return null == collect ? 0 : collect.size();
	}

	public static int size(Map<?, ?> map) {
		return null == map ? 0 : map.size();
	}

	public static boolean isEmpty(Collection<?> collect) {
		return CodeUtils.size(collect) == EMPTY_LENGTH;
	}

	public static boolean isNotEmpty(Collection<?> collect) {
		return !CodeUtils.isEmpty(collect);
	}

	public static boolean isEmpty(Map<?, ?> map) {
		return CodeUtils.size(map) == EMPTY_LENGTH;
	}

	public static boolean isNotEmpty(Map<?, ?> map) {
		return !CodeUtils.isEmpty(map);
	}

	public static boolean isArray(Object obj) {
		return CodeUtils.isNotNull(obj) && obj.getClass().isArray();
	}

	public static <T> T create(Supplier<T> supplier) {
		return supplier.get();
	}

	public static <T> T or(T nullable, T defaultVal) {
		return CodeUtils.isNotNull(nullable) ? nullable : defaultVal;
	}
}
