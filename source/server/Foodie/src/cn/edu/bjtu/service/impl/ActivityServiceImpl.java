/**
 * 
 */
package cn.edu.bjtu.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bjtu.edu.bean.ActivityBean;
import cn.edu.bjtu.dao.ActivityDao;
import cn.edu.bjtu.service.ActivityService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.JPush;
import cn.edu.bjtu.util.ParseTime;
import cn.edu.bjtu.vo.Activity;
import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

/**
 * @author solitude
 *
 */
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
	public static final String APPKEY = "c74edd9e63c1f5957cdaa7e6";
	public static final String MASTER_SECRET = "3dd9434ecbc1b22a6e3c2997";
	@Autowired
	ActivityDao activityDao;

	@Override
	public boolean addactivity(ActivityBean activityBean) {
		Activity ac = new Activity();
		ac.setId(IdCreator.createActivityId());
		ac.setLocation(activityBean.getLocation());
		ac.setName(activityBean.getName());
		ac.setReceTime(new Date());
		ac.setTime(new Date(ParseTime.parseTime(activityBean.getTime())));
		ac.setUserid(activityBean.getUserid());
		
		activityDao.save(ac);
		
		//ÍÆËÍÏûÏ¢
		JPushClient jpushClient = new JPushClient(MASTER_SECRET,APPKEY);
		String[] tag = ac.getUserid().split(",");
		String content = ac.getName();
		PushPayload payload = JPush.buildPushObject_android_and_ios(tag, content);
		
		try {
	        PushResult result = jpushClient.sendPush(payload);
	        System.out.println("Got result - " + result);

	    } catch (APIConnectionException e) {
	        // Connection error, should retry later
	        System.out.println("Connection error, should retry later::" + e.toString());

	    } catch (APIRequestException e) {
	        // Should review the error, and fix the request
	        System.out.println("Should review the error, and fix the request::"+ e.toString());
	        System.out.println("HTTP Status: " + e.getStatus());
	        System.out.println("Error Code: " + e.getErrorCode());
	        System.out.println("Error Message: " + e.getErrorMessage());
	    }
		
		return true;
	}

}
