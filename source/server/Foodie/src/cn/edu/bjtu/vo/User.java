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
	 * @param avatar 要设置的 avatar
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
	 * @param id 要设置的 id
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
	 * @param username 要设置的 username
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
	 * @param password 要设置的 password
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
	 * @param phone 要设置的 phone
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
	 * @param sex 要设置的 sex
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
	 * @param age 要设置的 age
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
	 * @param email 要设置的 email
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
	 * @param tag 要设置的 tag
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
	 * @param friends 要设置的 friends
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
	 * @param coupons 要设置的 coupons
	 */
	public void setCoupons(String coupons) {
		this.coupons = coupons;
	}
}
