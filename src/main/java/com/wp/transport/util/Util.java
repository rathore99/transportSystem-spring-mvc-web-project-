package com.wp.transport.util;

import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;

public class Util {
	
	public  static String generateUniqueFileName() {
	    String filename = "";
	    long millis = System.currentTimeMillis();
	    String datetime = new Date().toGMTString();
	    datetime = datetime.replace(" ", "");
	    datetime = datetime.replace(":", "");
	    String rndchars = RandomStringUtils.randomAlphanumeric(16);
	    filename = rndchars + "_" + datetime + "_" + millis;
	    return filename;
	}
	public static boolean uploadfile() {
		return true;
	}
}
