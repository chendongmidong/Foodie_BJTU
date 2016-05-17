/**
 * 
 */
package cn.edu.bjtu.vo;

import org.springframework.stereotype.Component;

/**
 * @author solitude
 *
 */
@Component
public class Restaurant {
	
	/*先给我一个饭店API吧，getRestaurants
	json字段包含 
	avatarUrl
	name
	address
	score*/
	
	private String id;
	private String avatarUrl;
	private String name;
	private String address;
	private int score;
	private String phone;
	private String intro;
	
	
	/**
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone 要设置的 phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return intro
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * @param intro 要设置的 intro
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
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
	 * @return avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}
	/**
	 * @param avatarUrl 要设置的 avatarUrl
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
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
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address 要设置的 address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score 要设置的 score
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
