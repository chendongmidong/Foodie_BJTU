/**
 * 
 */
package cn.edu.bjtu.util;

/**
 * @author solitude
 * ������Ϊ�˴���URL�����ظ��ͻ���
 */
public class ParseUrl {
	
	public static String parseUrl(String url){
		String relUrl = "";
		if(url!=null){
			String[] every_urls = url.split(",");
			for(int i=0;i<every_urls.length;i++){
				String every_url = every_urls[i];
				String[] parsedUrl = every_url.split("/");
				if(relUrl.equals("")){
				relUrl = relUrl + parsedUrl[parsedUrl.length-1];
				}else{
					relUrl = relUrl + "," + parsedUrl[parsedUrl.length-1];
				}
			}
		}
		return relUrl;
	}

}
