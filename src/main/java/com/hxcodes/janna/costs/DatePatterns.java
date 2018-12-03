package com.hxcodes.janna.costs;

public interface DatePatterns {
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	String DEFAULT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * yyyy-MM-dd HH:mm:ss.SSS
	 */
	String NORMAL_LONG = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * yyyy-MM-dd
	 */
	String ONLY_DATE = "yyyy-MM-dd";
	
	/**
	 * yyyy年MM月dd
	 */
	String ONLY_DATE_CN = "yyyy年MM月dd";

	/**
	 * HH:mm:ss
	 */
	String ONLY_TIME = "HH:mm:ss";

	/**
	 * HH:mm:ss.SSS
	 */
	String ONLY_TIME_LONG = "HH:mm:ss.SSS";
}
