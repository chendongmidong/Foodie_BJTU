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
	 * @param orderid 要设置的 orderid
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
	 * @param userid 要设置的 userid
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
	 * @return dishes
	 */
	public String getDishes() {
		return dishes;
	}
	/**
	 * @param dishes 要设置的 dishes
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
	 * @param seats 要设置的 seats
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
	 * @param username 要设置的 username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
