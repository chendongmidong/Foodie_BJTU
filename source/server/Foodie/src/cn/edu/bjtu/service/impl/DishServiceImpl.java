/**
 * 
 */
package cn.edu.bjtu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.DishDao;
import cn.edu.bjtu.service.DishService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Dish;

/**
 * @author solitude
 *
 */
@Service
@Transactional
public class DishServiceImpl implements DishService {
	@Autowired
	DishDao dishDao;

	@Override
	public List<Dish> getDishesByRestauId(String restauId) {
		String hql = "from Dish where restaurantid='"+restauId+"'";
		return dishDao.find(hql);
	}

	@Override
	public boolean insertDish(Dish dish) {
		dish.setId(IdCreator.createDishId());
		dishDao.save(dish);
		return true;
	}
	
	

}
