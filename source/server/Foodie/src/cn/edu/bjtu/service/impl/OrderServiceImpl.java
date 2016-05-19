/**
 * 
 */
package cn.edu.bjtu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.dao.OrderinfoUserViewDao;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Orderinfo;
import cn.edu.bjtu.vo.Orderinfo_User_View;

/**
 * @author solitude
 *
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderinfoUserViewDao orderinfoUserViewDao;

	@Override
	public boolean insertOrder(Orderinfo order) {
		order.setId(IdCreator.createOrderId());
		orderDao.save(order);
		return true;
	}

	@Override
	public List<Orderinfo_User_View> getOrdersByRestauId(String restaurantid) {
		String hql = "from Orderinfo_User_View where restaurantid='"+restaurantid+"'";
		
		return orderinfoUserViewDao.find(hql);
	}

}
