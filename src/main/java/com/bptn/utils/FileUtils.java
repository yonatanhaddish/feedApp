package com.bptn.utils;
import java.nio.file.*;


public class FileUtils {
	
	private static String HOME = System.getProperty("user.home");
	
//	check if test.txt file exists.
	Path p = Paths.get(HOME);
	
	if (File.exists( p )) {
		System.out.println("file found", p);
	}
}
