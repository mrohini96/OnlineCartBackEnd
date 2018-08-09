package com.trianz.onlinecart.util;

public class StringUtils {
	
	public static boolean isEmpty(String s) {
		boolean isEmpty = false;
		if ((s==null) || "".equals(s))
			isEmpty = true;
		return isEmpty;
	}
	
	public static boolean isNonEmpty(String s) {
		boolean isNonEmpty = false;
		if ((s!=null) && !"".equals(s))
			isNonEmpty = true;
		return isNonEmpty;
	}
}
