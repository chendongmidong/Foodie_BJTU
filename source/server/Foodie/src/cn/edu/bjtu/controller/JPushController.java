/**
 * 
 */
package cn.edu.bjtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.util.JPush;
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
	
	@RequestMapping("test1")
	@ResponseBody
	public String testJPush1(){
		JPushClient jpushClient = new JPushClient(MASTER_SECRET,APPKEY);
		PushPayload payload = JPush.buildPushObject_all_all_alert();
		
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
	@RequestMapping("test2")
	@ResponseBody
	public String testJPush2(){
		JPushClient jpushClient = new JPushClient(MASTER_SECRET,APPKEY);
		PushPayload payload = JPush.buildPushObject_all_alias_alert();
		
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
	@RequestMapping("test3")
	@ResponseBody
	public String testJPush3(){
		JPushClient jpushClient = new JPushClient(MASTER_SECRET,APPKEY);
		PushPayload payload = JPush.buildPushObject_android_tag_alertWithTitle();
		
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
	/*@RequestMapping("test4")
	@ResponseBody
	public String testJPush4(){
		JPushClient jpushClient = new JPushClient(MASTER_SECRET,APPKEY);
		PushPayload payload = JPush.buildPushObject_android_and_ios();
		
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
	}*/
	@RequestMapping("test5")
	@ResponseBody
	public String testJPush5(){
		JPushClient jpushClient = new JPushClient(MASTER_SECRET,APPKEY);
		PushPayload payload = JPush.buildPushObject_ios_tagAnd_alertWithExtrasAndMessage();
		
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
	@RequestMapping("test6")
	@ResponseBody
	public String testJPush6(){
		JPushClient jpushClient = new JPushClient(MASTER_SECRET,APPKEY);
		PushPayload payload = JPush.buildPushObject_ios_audienceMore_messageWithExtras();
		
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
}
