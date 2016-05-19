/**
 * 
 */
package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Dish;

/**
 * @author solitude
 *
 */
public interface DishService {
	
	public List<Dish> getDishesByRestauId(String restauId);
	
	public boolean insertDish(Dish dish);

}
