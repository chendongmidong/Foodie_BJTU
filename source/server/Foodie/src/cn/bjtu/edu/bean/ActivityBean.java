/**
 * 
 */
package cn.bjtu.edu.bean;

import java.util.Date;

/**
 * @author solitude
 *
 */
public class ActivityBean {
	
	private String id;
	private String name;
	private String time;//活动时间 格式2015-06-03-09
	private String location;
	private String userid;
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
	 * @return time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time 要设置的 time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location 要设置的 location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid 要设置的 userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
}
