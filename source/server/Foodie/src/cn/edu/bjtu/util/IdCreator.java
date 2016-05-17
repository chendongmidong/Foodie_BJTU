package cn.edu.bjtu.util;

import java.util.Calendar;
import java.util.Date;

/**
 * idÉú³ÉÀà
 * @author RussWest0
 *
 */
public class IdCreator {
	
	public static String createMomentId(){
		return "MO"+(int)(Math.random()*100000000);
	}
	
	public static String createRestaurantId(){
		return "RE" +(int)(Math.random()*100000000);
	}
	public static int createUserId(){
		return (int)(Math.random()*100000000);
	}
	public static String createCouponId(){
		return "CO"+(int)(Math.random()*100000000);
	}
	public static String createDishId(){
		return "DI"+(int)(Math.random()*100000000);
	}
	public static String createOrderId(){
		return "OR"+(int)(Math.random()*100000000);
	}
}
