/**
 * 
 */
package cn.edu.bjtu.controller;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.SequenceService;
import cn.edu.bjtu.service.SequenceUserViewService;
import cn.edu.bjtu.vo.Sequence;
import cn.edu.bjtu.vo.Sequence_User_View;
import net.sf.json.JSONArray;

/**
 * @author solitude
 *
 */
@Controller
@RequestMapping(value="sequence",produces="text/html;charset=UTF-8")
public class SequenceController {
	@Autowired
	SequenceService sequenceService;
	@Autowired
	SequenceUserViewService suvs;
	
	@RequestMapping("list")
	@ResponseBody
	public String opSequence(String userid,String type) throws JSONException{
		long size = (sequenceService.operSequence(userid, type)).size();
		String code = "{\"code\":\"";
		code = code + size+"\"}";
		JSONObject result = new JSONObject(code);
		return result.toString();
	}
	
	@RequestMapping("all")
	@ResponseBody
	public String allSequences(){
		List<Sequence_User_View> s = suvs.all();
		JSONArray ss = JSONArray.fromObject(s);
		return ss.toString();
	}
}
