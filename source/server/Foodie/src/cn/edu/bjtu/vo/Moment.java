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
	 * @param id Ҫ���õ� id
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
	 * @param name Ҫ���õ� name
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
	 * @param avatorUrl Ҫ���õ� avatorUrl
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
	 * @param content Ҫ���õ� content
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
	 * @param imageUrls Ҫ���õ� imageUrls
	 */
	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}
	

}
