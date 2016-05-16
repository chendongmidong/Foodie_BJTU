/**
 * 
 */
package cn.edu.bjtu.vo;

import org.springframework.stereotype.Component;

/**
 * @author solitudeycq
 *
 */
@Component
public class Moment {
	
	private String id;
	private String name;
	private String avatorUrl;
	private String content;
	private String imageUrls;
	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id 要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}
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
	public String getImageUrls() {
		return imageUrls;
	}
	/**
	 * @param imageUrls 要设置的 imageUrls
	 */
	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}
	

}
