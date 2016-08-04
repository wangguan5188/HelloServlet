package com.omnipotent.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 类型转换处理工具类
 * 
 * @author zhangtb
 * @date 2016-8-4 22:21:30
 * @since 1.0.0
 */
public class StringUtil {

	public static boolean isBlank(String s) {
		if (s == null || s.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public static String loop(String s, int count, String split) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < count; i++) {
			sb.append(s);
			int last_index = count - 1;
			if (i < last_index) {
				sb.append(split);
			}
		}
		return sb.toString();
	}

	public static String listToString(List<String> list, String split) {
		StringBuffer sb = new StringBuffer();
		if (list != null) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				String s = list.get(i);
				sb.append(s);
				int last_index = size - 1;
				if (i < last_index) {
					sb.append(split);
				}
			}
		}
		return sb.toString();
	}

	public static List<String> stringToList(String s, String split) {
		if (s == null || s.trim().equals("")) {
			return new ArrayList<String>();
		} else {
			String[] arr = s.split(split);
			List<String> list = Arrays.asList(arr);
			return list;
		}
	}

	public static List<Integer> stringToIntList(String s, String split) {
		if (s == null || s.trim().equals("")) {
			return new ArrayList<Integer>();
		} else {
			String[] arr = s.split(split);
			List<Integer> list = new ArrayList<Integer>();
			for (String str : arr) {
				int t = toInt(str);
				list.add(t);
			}
			return list;
		}
	}

	public static String toString(Object obj) {
		if (obj != null && !obj.toString().trim().equals("")) {
			return obj.toString();
		} else {
			return "";
		}
	}

	public static String toString(Object obj, String init) {
		if (obj != null && !obj.toString().trim().equals("")) {
			return obj.toString();
		} else {
			return init;
		}
	}

	public static int toInt(Object obj) {
		if (obj == null) {
			return 0;
		}
		String s = obj.toString();
		if (s != null && !s.trim().equals("")) {
			if (s.matches("\\d+")) {
				return Integer.parseInt(s);
			}
		}
		return 0;
	}

	public static int toInt(Object obj, int i) {
		if (obj == null) {
			return i;
		}
		String s = obj.toString();
		if (s != null && !s.trim().equals("")) {
			if (s.matches("-?\\d+")) {
				return Integer.parseInt(s);
			}
		}
		return i;
	}

	public static long toLong(Object obj, long i) {
		if (obj == null) {
			return i;
		}
		String s = obj.toString();
		if (s != null && !s.trim().equals("")) {
			if (s.matches("\\d+")) {
				return Long.parseLong(s);
			}
		}
		return i;
	}

	public static float toFloat(Object obj) {
		if (obj == null) {
			return 0.0f;
		}
		String s = obj.toString();
		if (s != null && !s.trim().equals("")) {
			if (s.matches("\\d+(\\.\\d+)?")) {
				return Float.parseFloat(s);
			}
		}
		return 0.0f;
	}

	/**
	 * String类型数据转换成队列
	 * @Date: 2014-1-10上午09:54:36
	 * @Description: List<String>
	 * @param s String数据
	 * @param split 分隔符
	 * @return
	 */
	public static List<String> StringtoList(String s, String split) {
		List<String> list = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(s, split);
		while (tokenizer.hasMoreElements()) {
			String str = (String) tokenizer.nextElement();
			list.add(str);
		}
		return list;
	}

	/**
	 * String类型数据转换成数组
	 * @Date: 2014-1-10上午09:54:36
	 * @Description: String[]
	 * @param s String数据
	 * @param split 分隔符
	 * @return
	 */
	public static String[] toStringArray(String s, String split) {
		String[] sArray = new String[] {};
		if (!isBlank(s))
			sArray = s.split(split);
		return sArray;
	}

	public static Timestamp stringToTimestamp(String dateStr) {
		if (StringUtil.isBlank(dateStr)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		try {
			Date date = sdf.parse(dateStr);
			date.getTime();
			cal.setTime(date);
			return new Timestamp(cal.getTimeInMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}
		cal.setTime(new Date());
		return new Timestamp(cal.getTimeInMillis());
	}

}
