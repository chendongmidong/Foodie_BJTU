/**
 * 
 */
package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Orderinfo;
import cn.edu.bjtu.vo.Orderinfo_User_View;

/**
 * @author solitude
 *
 */
public interface OrderService {
	
	public boolean insertOrder(Orderinfo order);
	
	public List<Orderinfo_User_View> getOrdersByRestauId(String restaurantid);

}
