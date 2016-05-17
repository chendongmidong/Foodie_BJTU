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
public class User{
	
	private int id;
	private String username;
	private String password;
	private String phone;
	private String sex;
	private int age;
	private String email;
	private String tag;
	private String friends;
	private String coupons;
	private String avatar;
	
	
	/**
	 * @return avatar
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * @param avatar Ҫ���õ� avatar
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id Ҫ���õ� id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username Ҫ���õ� username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password Ҫ���õ� password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
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
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex Ҫ���õ� sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age Ҫ���õ� age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email Ҫ���õ� email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag Ҫ���õ� tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return friends
	 */
	public String getFriends() {
		return friends;
	}
	/**
	 * @param friends Ҫ���õ� friends
	 */
	public void setFriends(String friends) {
		this.friends = friends;
	}
	/**
	 * @return coupons
	 */
	public String getCoupons() {
		return coupons;
	}
	/**
	 * @param coupons Ҫ���õ� coupons
	 */
	public void setCoupons(String coupons) {
		this.coupons = coupons;
	}
}
