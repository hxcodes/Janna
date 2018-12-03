package com.hxcodes.janna.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {
	public static boolean copy(File src, File target) {
		return false;
	}

	public static boolean copy(String src, String target) {
		return false;
	}

	public static boolean move(File src, File target) {
		return false;
	}

	public static boolean move(String src, String target) {
		return false;
	}

	public static boolean create(String path) {
		return false;
	}

	public static boolean create(File file) {
		return false;
	}

	public static boolean delete(String path) {
		File file = new File(path);
		return delete(file);
	}

	public static boolean delete(File file) {
		return CodeUtils.isNotNull(file) && file.exists() && file.delete();
	}

	public static File temp(String prefix, String suffix) {
		try {
			return Files.createTempFile(prefix, suffix).toFile();
		} catch (IOException e) {
			return null;
		}
	}
}
