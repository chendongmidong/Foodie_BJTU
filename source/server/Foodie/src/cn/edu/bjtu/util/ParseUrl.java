/**
 * 
 */
package cn.edu.bjtu.util;

/**
 * @author solitude
 * 该类是为了处理URL，返回给客户端
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
