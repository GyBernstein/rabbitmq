package com.gaoyuan.spring.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;


public class CommonUtil {
	
	/**
	 * 2016年11月16日上午9:25:55
	 * @author zhangx
	 * 日期格式化
	 * @param format
	 * @param date
	 * @return
	 */
	public static String formatData(String format,Date date) {
		if (StringUtils.isEmpty(format)) {
			format=ImesConstant.DATA_FORMAT_YMDHMS_24;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 将字符格式日期转换成日期格式
	 * @param format
	 * @param dateStr
	 * @return
	 */
	public static Date getDate(String format,String dateStr){
		Date date = null;
		try {
			if (StringUtils.isEmpty(format)) {
				format=ImesConstant.DATA_FORMAT_YMDHMS_24;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
