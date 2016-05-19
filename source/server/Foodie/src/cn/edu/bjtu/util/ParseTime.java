/**
 * 
 */
package cn.edu.bjtu.util;

import java.util.Date;

/**
 * @author solitude
 * 该类是为了解析时间为long型，当然返回字符串或者long都行
 * 传进来的字符串为2015-05-18-09，分别代表年月日时。
 *
 */
public class ParseTime {
	
	@SuppressWarnings("deprecation")
	public static String parseStrTime(String originTime){
		String relTime = "";
		String[] strTime = originTime.split("-");
		Date date = new Date(Integer.valueOf(strTime[0])-1900,Integer.valueOf(strTime[1])-1,Integer.valueOf(strTime[2]),Integer.valueOf(strTime[3]),0,0);
		relTime = date.getTime()+"";
		return relTime;
	}
	@SuppressWarnings("deprecation")
	public static long parseTime(String originTime){
		String[] strTime = originTime.split("-");
		Date date = new Date(Integer.valueOf(strTime[0])-1900,Integer.valueOf(strTime[1])-1,Integer.valueOf(strTime[2]),Integer.valueOf(strTime[3]),0,0);
		return date.getTime();
	}

}
