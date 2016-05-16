/**
 * 
 */
package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Coupon;

/**
 * @author solitude
 *
 */
public interface CouponService {
	
	public List<Coupon> getCouponsByRestauId(String restauId);

}
