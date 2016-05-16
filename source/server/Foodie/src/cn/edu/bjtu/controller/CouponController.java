/**
 * 
 */
package cn.edu.bjtu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.CouponService;
import cn.edu.bjtu.vo.Coupon;
import net.sf.json.JSONArray;

/**
 * @author solitude
 *
 */
@Controller
@RequestMapping(value="/coupon",produces="text/html;charset=UTF-8")
public class CouponController {
	@Autowired
	CouponService couponService;
	
	@RequestMapping(value="getCouponsByRestauId")
	@ResponseBody
	public String getCouponByRestauId(String restaurantId){
		List<Coupon> coupons = couponService.getCouponsByRestauId(restaurantId);
		JSONArray coupon = JSONArray.fromObject(coupons);
		return coupon.toString();
	}

}
