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
public class Activity {
	
	private String id;
	private String name;
	private Date time;//活动时间
	private String location;
	private String userid;
	private Date receTime;//发起活动的时间
	
	
	/**
	 * @return receTime
	 */
	public Date getReceTime() {
		return receTime;
	}
	/**
	 * @param receTime 要设置的 receTime
	 */
	public void setReceTime(Date receTime) {
		this.receTime = receTime;
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
	public Date getTime() {
		return time;
	}
	/**
	 * @param time 要设置的 time
	 */
	public void setTime(Date time) {
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
