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
	
	/*�ȸ���һ������API�ɣ�getRestaurants
	json�ֶΰ��� 
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
	 * @param phone Ҫ���õ� phone
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
	 * @param intro Ҫ���õ� intro
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
	 * @param id Ҫ���õ� id
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
	 * @param avatarUrl Ҫ���õ� avatarUrl
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
	 * @param name Ҫ���õ� name
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
	 * @param address Ҫ���õ� address
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
	 * @param score Ҫ���õ� score
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
