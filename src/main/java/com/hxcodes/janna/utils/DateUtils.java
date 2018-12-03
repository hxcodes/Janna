package com.hxcodes.janna.utils;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.hxcodes.janna.costs.DatePatterns;

public class DateUtils {
	private final static Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

	private static Map<String, FastDateFormat> formaters = Maps.newHashMap();

	private static FastDateFormat getFormatter(String pattern) {
		FastDateFormat formatter = formaters.get(pattern);
		if (CodeUtils.isNull(formatter)) {
			formatter = FastDateFormat.getInstance(pattern);
			formaters.put(pattern, formatter);
		}

		return formatter;
	}

	public static Date now() {
		return Date.from(Instant.now());
	}

	public static Date epoch() {
		return Date.from(Instant.EPOCH);
	}

	public static String formatNow() {
		return DateUtils.formatNow(DatePatterns.DEFAULT);
	}

	public static String formatNow(String pattern) {
		FastDateFormat formater = getFormatter(pattern);
		return formater.format(DateUtils.now());
	}

	public static Date parse(String timestamp, String pattern) {
		FastDateFormat formater = getFormatter(pattern);
		try {
			return formater.parse(timestamp);
		} catch (ParseException e) {
			LOGGER.error("date parse error, timestamp:{}, pattern:{}", timestamp, pattern, e);

			return null;
		}
	}

	public static String fmt(Date date, String pattern) {
		FastDateFormat formater = getFormatter(pattern);
		return formater.format(date);
	}

	public static String fmt(long millis, String pattern) {
		FastDateFormat formater = getFormatter(pattern);
		return formater.format(millis);
	}
}