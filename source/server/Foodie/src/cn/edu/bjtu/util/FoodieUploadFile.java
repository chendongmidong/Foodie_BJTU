/**
 * 
 */
package cn.edu.bjtu.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import Decoder.BASE64Decoder;

/**
 * @author solitude
 *
 */
public class FoodieUploadFile {
	//�����ļ������ؾ��Ե�ַ
	public static String mobileuploadFile(String userid,String strImageContent,String type){
		BASE64Decoder decoder = new BASE64Decoder();
		String imgFilePath = "";
		if(type.equals("user")){
			imgFilePath = imgFilePath + FoodieUploadPath.getUserAvatarPath() + userid + ".jpg";
		}else{
			imgFilePath = imgFilePath + FoodieUploadPath.getFriendsPicturePath() + userid + "_" + type + ".jpg";
		}
		try {
			byte[] bytes = decoder.decodeBuffer(strImageContent);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// �����쳣����
					bytes[i] += 256;
				}
			}
			//����ͼƬ
			OutputStream out = new FileOutputStream(imgFilePath);		
			out.write(bytes);		
			out.flush();
			out.close();
			return imgFilePath;
		} catch (IOException e) {
			return "�洢ʧ��";
		}	
	}
}
