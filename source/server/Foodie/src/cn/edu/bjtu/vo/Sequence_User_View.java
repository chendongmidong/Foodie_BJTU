/**
 * 
 */
package cn.edu.bjtu.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author solitude
 *
 */
@Component
public class Sequence_User_View {
	private String id;
	private Date time;
	private int userid;
	private String username;
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
	 * @return time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time Ҫ���õ� time
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @return userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid Ҫ���õ� userid
	 */
	public void setUserid(int userid) {
		this.userid = userid;
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
}
