/**
 * 
 */
package cn.bjtu.edu.bean;

/**
 * @author solitude
 *
 */
public class OrderBean {
	
	private String userid;
	private String restaurantid;
	private String time;
	private String dishes;
	private String seats;
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
}
