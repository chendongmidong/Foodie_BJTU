/**
 * 
 */
package cn.edu.bjtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Orderinfo;

/**
 * @author solitude
 *
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;

	@Override
	public boolean insertOrder(Orderinfo order) {
		order.setId(IdCreator.createOrderId());
		orderDao.save(order);
		return true;
	}

}
