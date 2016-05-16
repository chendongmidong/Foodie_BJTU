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
public class Coupon {
	
	private String id;
	private String restaurantid;
	private Date time;
	private float extent;
	private float money;
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
	 * @return restaurantid
	 */
	public String getRestaurantid() {
		return restaurantid;
	}
	/**
	 * @param restaurantid Ҫ���õ� restaurantid
	 */
	public void setRestaurantid(String restaurantid) {
		this.restaurantid = restaurantid;
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
	 * @return extent
	 */
	public float getExtent() {
		return extent;
	}
	/**
	 * @param extent Ҫ���õ� extent
	 */
	public void setExtent(float extent) {
		this.extent = extent;
	}
	/**
	 * @return money
	 */
	public float getMoney() {
		return money;
	}
	/**
	 * @param money Ҫ���õ� money
	 */
	public void setMoney(float money) {
		this.money = money;
	}
}
