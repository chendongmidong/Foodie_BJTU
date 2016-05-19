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
	private Date time;//�ʱ��
	private String location;
	private String userid;
	private Date receTime;//������ʱ��
	
	
	/**
	 * @return receTime
	 */
	public Date getReceTime() {
		return receTime;
	}
	/**
	 * @param receTime Ҫ���õ� receTime
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
	 * @return location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location Ҫ���õ� location
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
	 * @param userid Ҫ���õ� userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
}
