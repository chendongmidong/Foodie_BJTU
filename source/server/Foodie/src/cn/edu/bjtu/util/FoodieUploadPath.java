/**
 * 
 */
package cn.edu.bjtu.util;

import java.io.File;

/**
 * @author solitude
 *  �����ϴ�·��
 */
public class FoodieUploadPath {
	
	public static File file = null;
	
	public static String getUserAvatarPath(){
		String path= "/usr/local/foodie/user/";
		file=new File(path);
		file.mkdirs();//��ֹ�ļ��в�����
		return path;
	}
	
	public static String getFriendsPicturePath(){
		String path= "/usr/local/foodie/friend/";
		file=new File(path);
		file.mkdirs();//��ֹ�ļ��в�����
		return path;
	}

}
