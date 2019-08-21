package com.nd.common;

public class StringUtil {
	public static boolean empty(Object obj) {
		boolean flag=true;// true表示为空
		if(obj!=null&&
				!"".equals(obj.toString())) {
			flag=false;
		}
		return flag;
	}
}
