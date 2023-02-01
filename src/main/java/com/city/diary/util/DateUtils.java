package com.city.diary.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/*
 * 日期转换工厂类
 */

public class DateUtils {

	public static Date StrToDate(String date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		try {
			return new Date(simpleDateFormat.parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public class JsonUtil {

	    public static String getJson(Object object){
	        return getJson(object,"yyyy-MM-dd HH:mm:ss");
	    }

	    public static String getJson(Object object, String dateFormat){

	        ObjectMapper mapper = new ObjectMapper();
	        //1.如何让他不返回时间戳！关闭它的功能就好！
	        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
	        //2.时间格式化问题！自定日期格式对象
	        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	        //3.让mapper指定时间日期格式为simpleDateFormat
	        mapper.setDateFormat(sdf);

	        try {
	            return mapper.writeValueAsString(object);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	}

}
