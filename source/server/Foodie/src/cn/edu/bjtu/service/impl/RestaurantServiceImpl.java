/**
 * 
 */
package cn.edu.bjtu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.RestaurantDao;
import cn.edu.bjtu.service.RestaurantService;
import cn.edu.bjtu.vo.Restaurant;

/**
 * @author solitude
 *
 */
@Transactional
@Repository
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	RestaurantDao restaurantDao;

	@Override
	public List<Restaurant> getAllRestaurants() {
		String hql = "from Restaurant";
		return restaurantDao.find(hql);
	}

	@Override
	public Restaurant getRestaurantByName(String name) {
		String hql = "from Restaurant where name='"+name+"'";
		return restaurantDao.get(hql);
	}

}
