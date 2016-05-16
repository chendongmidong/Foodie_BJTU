/**
 * 
 */
package cn.edu.bjtu.vo;

import org.springframework.stereotype.Component;

/**
 * @author solitude
 *
 */
@Component
public class Dish {
	
	private String id;
	private String name;
	private float price;
	private String category;
	private double score;
	private double frequency;
	private String restaurantid;
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
	 * @return price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price 要设置的 price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category 要设置的 category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return score
	 */
	public double getScore() {
		return score;
	}
	/**
	 * @param score 要设置的 score
	 */
	public void setScore(double score) {
		this.score = score;
	}
	/**
	 * @return frequency
	 */
	public double getFrequency() {
		return frequency;
	}
	/**
	 * @param frequency 要设置的 frequency
	 */
	public void setFrequency(double frequency) {
		this.frequency = frequency;
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
}
