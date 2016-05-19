/**
 * 
 */
package cn.edu.bjtu.util;

/**
 * @author solitude
 *  拼接图片的地址，可直接给客户端使用
 *
 */
public class URLGenerator {
	
	public static final String USER_URL_PRE = "http://123.56.143.59:8585/Foodie/images/user/";
	public static final String FRIEND_URL_PRE = "http://123.56.143.59:8585/Foodie/images/friend/";
	public static final String DISH_URL_PRE = "http://123.56.143.59:8585/Foodie/images/dish/";
	
	public static String genernator(String type,String originUrl){
		if(type.equals("user")){
			String[] temp = originUrl.split("/");
			return USER_URL_PRE+temp[temp.length-1];		
		}else if(type.equals("dish")){
			String[] temp = originUrl.split("/");
			return DISH_URL_PRE+temp[temp.length-1];
		}
		return "";
	}

}
