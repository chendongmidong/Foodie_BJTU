/**
 * 
 */
package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Restaurant;

/**
 * @author solitude
 *
 */
public interface RestaurantService {
	
	public List<Restaurant> getAllRestaurants();
	
	public Restaurant getRestaurantByName(String name);

}
