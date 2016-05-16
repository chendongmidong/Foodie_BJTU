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
	 * @param id 要设置的 id
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
	 * @param restaurantid 要设置的 restaurantid
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
	 * @param time 要设置的 time
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
	 * @param extent 要设置的 extent
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
	 * @param money 要设置的 money
	 */
	public void setMoney(float money) {
		this.money = money;
	}
}
