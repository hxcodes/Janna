package com.hxcodes.janna.utils;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.hxcodes.janna.costs.Symbol;

public class CtrlUtils {
	/** 可能包含真实IP信息的头参数KEY */
	private static final String[] HEADER_REAL_IP = new String[] { "X-Forwarded-For", "Proxy-Client-IP", "X-Real-IP",
			"WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR" };
	/** 需要忽略的IP地址列表 */
	private static final String[] IGNORE_REAL_IP_START = new String[] { "unknown", "10.", "192.", "172.", "255.",
			"254.", "0.", "local", "0:", "127." };

	/**
	 * 获取请求中的真实地址, 此方法在内网中使用时, 无法获取预期的结果<br />
	 * 获取规则：<br />
	 * 1. remoteAddr<br />
	 * 2. headers:"X-Forwarded-For", "Proxy-Client-IP", "X-Real-IP",
	 * "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR"<br />
	 * 3. 排除以下开头的IP地址:"unknown", "10.", "192.", "172.", "255.", "254.", "0.",
	 * "local", "0:", "127."
	 * 
	 * @param request {@link HttpServletRequest}
	 * @return 真实的外网IP地址
	 */
	public static String realAddr(final HttpServletRequest request) {
		List<String> addrs = Lists.newArrayList(request.getRemoteAddr());

		Arrays.asList(HEADER_REAL_IP).forEach(key -> {
			String[] temp = StringUtils.split(request.getHeader(key), Symbol.COMMA);
			if (ArrayUtils.isNotEmpty(temp)) {
				CollectionUtils.addAll(addrs, temp);
			}
		});

		String ip = addrs.stream().filter(addr -> {
			return CodeUtils.isNotBlank(addr) && !StringUtils.startsWithAny(addr, IGNORE_REAL_IP_START);
		}).findFirst().orElse(StringUtils.EMPTY);

		return StringUtils.trimToEmpty(ip);
	}

	public static String param(ServletRequest rqst, String key) {
		return rqst.getParameter(key);
	}

	public static String param(ServletRequest rqst, String key, String defaultStr) {
		return StringUtils.defaultIfEmpty(param(rqst, key), defaultStr);
	}

	public static String header(HttpServletRequest rqst, String key) {
		return rqst.getHeader(key);
	}

	public static String header(HttpServletRequest rqst, String key, String defaultStr) {
		return StringUtils.defaultIfEmpty(header(rqst, key), defaultStr);
	}

	public static String find(HttpServletRequest rqst, String key) {
		return CodeUtils.or(CtrlUtils.param(rqst, key), CtrlUtils.header(rqst, key));
	}

	public static String find(HttpServletRequest rqst, String key, String defaultStr) {
		return CodeUtils.or(CtrlUtils.param(rqst, key), CtrlUtils.header(rqst, key, defaultStr));
	}
}
