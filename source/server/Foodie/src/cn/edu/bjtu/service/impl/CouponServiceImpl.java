/**
 * 
 */
package cn.edu.bjtu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.CouponDao;
import cn.edu.bjtu.service.CouponService;
import cn.edu.bjtu.vo.Coupon;

/**
 * @author solitude
 *
 */
@Service
@Transactional
public class CouponServiceImpl implements CouponService {
	@Autowired
	CouponDao couponDao;

	@Override
	public List<Coupon> getCouponsByRestauId(String restauId) {
		String hql = "from Coupon where restaurantid='"+restauId+"'";
		return couponDao.find(hql);
	}

}
