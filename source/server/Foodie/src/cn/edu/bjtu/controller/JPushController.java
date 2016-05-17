/**
 * 
 */
package cn.edu.bjtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

/**
 * @author solitude
 *
 */
@Controller
public class JPushController {
	
	public static final String APPKEY = "c74edd9e63c1f5957cdaa7e6";
	public static final String MASTER_SECRET = "3dd9434ecbc1b22a6e3c2997";
	
	@RequestMapping("test")
	@ResponseBody
	public String testJPush(){
		JPushClient jpushClient = new JPushClient(MASTER_SECRET,APPKEY);
		PushPayload payload = buildPushObject_all_all_alert();
		
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
		return "success";
	}
	
	public static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll("·þÎñÆ÷²âÊÔ");
    }

}
