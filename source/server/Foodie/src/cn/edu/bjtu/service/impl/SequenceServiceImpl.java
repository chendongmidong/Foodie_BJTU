/**
 * 
 */
package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.SequenceDao;
import cn.edu.bjtu.service.SequenceService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.JPush;
import cn.edu.bjtu.vo.Sequence;
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
public class SequenceServiceImpl implements SequenceService {
	
	public static final String APPKEY = "c74edd9e63c1f5957cdaa7e6";
	public static final String MASTER_SECRET = "3dd9434ecbc1b22a6e3c2997";
	@Autowired
	SequenceDao sequenceDao;

	@Override
	public List<Sequence> operSequence(String userid, String type) {
		if(type.equals("add")){
			Sequence se = new Sequence();
			se.setTime(new Date());
			se.setUserid(Integer.valueOf(userid));
			se.setId(IdCreator.createSequenceId());
			
			sequenceDao.save(se);
			
			return sequenceDao.find("from Sequence order by time asc");
		}else{
			//ÍÆËÍÏûÏ¢
			JPushClient jpushClient = new JPushClient(MASTER_SECRET,APPKEY);
			String tag = userid;
			PushPayload payload = JPush.anotherbuildPushObject_android_and_ios(tag);
			
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
			sequenceDao.delete(sequenceDao.get("from Sequence where userid='"+userid+"'"));
			return sequenceDao.find("from Sequence order by time asc");
		}
	}

}
