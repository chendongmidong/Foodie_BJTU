/**
 * 
 */
package cn.bjtu.edu.bean;

/**
 * @author solitude
 * 该Bean的作用是给安卓端返回数据用的
 */
public class MomentBean {
	
	private String name;
	private String avatorUrl;
	private String content;
	private String[] imageUrls;
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return avatorUrl
	 */
	public String getAvatorUrl() {
		return avatorUrl;
	}
	/**
	 * @param avatorUrl 要设置的 avatorUrl
	 */
	public void setAvatorUrl(String avatorUrl) {
		this.avatorUrl = avatorUrl;
	}
	/**
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content 要设置的 content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return imageUrls
	 */
	public String[] getImageUrls() {
		return imageUrls;
	}
	/**
	 * @param imageUrls 要设置的 imageUrls
	 */
	public void setImageUrls(String[] imageUrls) {
		this.imageUrls = imageUrls;
	}
}
