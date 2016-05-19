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
public class Orderinfo_User_View {
	
	private String orderid;
	private int userid;
	private String restaurantid;
	private Date time;
	private String dishes;
	private String seats;
	private String username;
	/**
	 * @return orderid
	 */
	public String getOrderid() {
		return orderid;
	}
	/**
	 * @param orderid Ҫ���õ� orderid
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
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
	 * @return dishes
	 */
	public String getDishes() {
		return dishes;
	}
	/**
	 * @param dishes Ҫ���õ� dishes
	 */
	public void setDishes(String dishes) {
		this.dishes = dishes;
	}
	/**
	 * @return seats
	 */
	public String getSeats() {
		return seats;
	}
	/**
	 * @param seats Ҫ���õ� seats
	 */
	public void setSeats(String seats) {
		this.seats = seats;
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
