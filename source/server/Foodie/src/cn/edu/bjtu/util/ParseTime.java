/**
 * 
 */
package cn.edu.bjtu.util;

import java.util.Date;

/**
 * @author solitude
 * ������Ϊ�˽���ʱ��Ϊlong�ͣ���Ȼ�����ַ�������long����
 * ���������ַ���Ϊ2015-05-18-09���ֱ����������ʱ��
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
