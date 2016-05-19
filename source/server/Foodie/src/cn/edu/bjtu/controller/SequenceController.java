/**
 * 
 */
package cn.edu.bjtu.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.SequenceService;

/**
 * @author solitude
 *
 */
@Controller
@RequestMapping(value="sequence",produces="text/html;charset=UTF-8")
public class SequenceController {
	@Autowired
	SequenceService sequenceService;
	
	@RequestMapping("list")
	@ResponseBody
	public String opSequence(String userid,String type) throws JSONException{
		long size = (sequenceService.operSequence(userid, type)).size();
		String code = "{\"code\":\"";
		code = code + size+"\"}";
		JSONObject result = new JSONObject(code);
		return result.toString();
	}
}
