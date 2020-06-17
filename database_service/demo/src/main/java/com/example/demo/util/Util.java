package com.example.demo.util;

import java.text.SimpleDateFormat;

public class Util {


	/** 
	 * @param 返回java.sql.Date格式的 
	 * */  
	public static java.sql.Date strToDate(String strDate) {  
	    String str = strDate;  
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	    java.util.Date d = null;  
	    try {  
	        d = format.parse(str);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    java.sql.Date date = new java.sql.Date(d.getTime());  
	    return date;  
	}
};

