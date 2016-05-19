
package cn.edu.bjtu.util;

import cn.jpush.api.JPushClient;  
import cn.jpush.api.push.model.Message;  
import cn.jpush.api.push.model.Options;  
import cn.jpush.api.push.model.Platform;  
import cn.jpush.api.push.model.PushPayload;  
import cn.jpush.api.push.model.audience.Audience;  
import cn.jpush.api.push.model.audience.AudienceTarget;  
import cn.jpush.api.push.model.notification.AndroidNotification;  
import cn.jpush.api.push.model.notification.IosNotification;  
import cn.jpush.api.push.model.notification.Notification;  
	  
public class JPush {    	  
	    public static final String APPKEY = "c74edd9e63c1f5957cdaa7e6";
	 	public static final String MASTER_SECRET = "3dd9434ecbc1b22a6e3c2997";
	  
	    public static final String TITLE = "Foodie";  
	    public static final String ALERT = "您的朋友发起了一个新的活动！";  
	    public static final String MSG_CONTENT = "申通快递祝新老客户新春快乐";  
	    public static final String REGISTRATION_ID = "0900e8d85ef";  
	    public static final String TAG = "tag_api";  
	      
	    public  static JPushClient jpushClient=new JPushClient(MASTER_SECRET, APPKEY); 
	    
	    
	    public static PushPayload buildPushObject_all_all_alert() {  //1
	        return PushPayload.alertAll(ALERT);  
	    }  
	      
	    public static PushPayload buildPushObject_all_alias_alert() {  //2
	        return PushPayload.newBuilder()  
	                .setPlatform(Platform.all())//设置接受的平台  
	                .setAudience(Audience.all())//Audience设置为all，说明采用广播方式推送，所有用户都可以接收到  
	                .setNotification(Notification.alert(ALERT))  
	                .build();  
	    }  
	      
	    public static PushPayload buildPushObject_android_tag_alertWithTitle() {  //3
	        return PushPayload.newBuilder()  
	                .setPlatform(Platform.android())  
	                .setAudience(Audience.all())  
	                .setNotification(Notification.android(ALERT, TITLE, null))  
	                .build();  
	    }  
	      
	    public static PushPayload buildPushObject_android_and_ios(String[] tag,String content) {  //4
	        return PushPayload.newBuilder()  
	                .setPlatform(Platform.android_ios())  
	                .setAudience(Audience.tag(tag))  
	                .setNotification(Notification.newBuilder()  
	                        .setAlert(ALERT)  
	                        .addPlatformNotification(AndroidNotification.newBuilder()  
	                                .setTitle(TITLE).build()) 
	                        .build())
	                .setMessage(Message.newBuilder()  
	                        .setMsgContent(content)   
	                        .build())  
	                .build();  
	    }  
	    
	    public static PushPayload anotherbuildPushObject_android_and_ios(String tag) {  //4
	        return PushPayload.newBuilder()  
	                .setPlatform(Platform.android_ios())  
	                .setAudience(Audience.tag(tag))  
	                .setNotification(Notification.newBuilder()  
	                        .setAlert("他妈的该你吃饭了！！")  
	                        .addPlatformNotification(AndroidNotification.newBuilder()  
	                                .setTitle(TITLE).build()) 
	                        .build())
	                .setMessage(Message.newBuilder()  
	                        .setMsgContent("。。。")   
	                        .build())  
	                .build();  
	    }  
	      
	    public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {//5  
	        return PushPayload.newBuilder()  
	                .setPlatform(Platform.ios())  
	                .setAudience(Audience.tag_and("tag1", "tag_all"))  
	                .setNotification(Notification.newBuilder()  
	                        .addPlatformNotification(IosNotification.newBuilder()  
	                                .setAlert(ALERT)  
	                                .setBadge(5)  
	                                .setSound("happy")  
	                                .addExtra("from", "JPush")  
	                                .build())  
	                        .build())  
	                 .setMessage(Message.content(MSG_CONTENT))  
	                 .setOptions(Options.newBuilder()  
	                         .setApnsProduction(true)  
	                         .build())  
	                 .build();  
	    }  
	      
	    public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {  //6
	        return PushPayload.newBuilder()  
	                .setPlatform(Platform.android_ios())  
	                .setAudience(Audience.newBuilder()  
	                        .addAudienceTarget(AudienceTarget.tag("tag1", "tag2"))  
	                        .addAudienceTarget(AudienceTarget.alias("alias1", "alias2"))  
	                        .build())  
	                .setMessage(Message.newBuilder()  
	                        .setMsgContent(MSG_CONTENT)  
	                        .addExtra("from", "JPush")  
	                        .build())  
	                .build();  
	 }  
}  
