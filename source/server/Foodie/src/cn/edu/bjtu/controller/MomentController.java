/**
 * 
 */
package cn.edu.bjtu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;

import cn.bjtu.edu.bean.MomentBean;
import cn.edu.bjtu.service.MomentService;
import cn.edu.bjtu.vo.Moment;

/**
 * @author solitudeycq
 *
 */
@Controller
@RequestMapping(value="/moments",produces="text/html;charset=UTF-8")
public class MomentController {
	@Autowired
	MomentService momentService;
	
	@RequestMapping("insertMoment")
	@ResponseBody
	public void insertMoment(Moment moment){
		momentService.insertMoment(moment);
	}
	@RequestMapping("getFriendsMoments")
	@ResponseBody
	public String getallmoments(){
		List<Moment> m = momentService.getAllMoments();
		List<MomentBean> mb = new ArrayList<MomentBean>();
		for(int i = 0;i<m.size();i++){
			Moment tempm = m.get(i);
			MomentBean tempmb = new MomentBean();
			tempmb.setName(tempm.getName());
			tempmb.setAvatorUrl(tempm.getAvatorUrl());
			tempmb.setImageUrls(tempm.getImageUrls().split(","));
			tempmb.setContent(tempm.getContent());
			mb.add(tempmb);
		}
		JSONArray moments = JSONArray.fromObject(mb);
		return moments.toString();
	}
	
	@RequestMapping("getMyMoments")
	@ResponseBody
	public String getMyMoment(String name){
		Moment moment = momentService.getMomentByName(name);
		MomentBean mb = new MomentBean();
		mb.setAvatorUrl(moment.getAvatorUrl());
		mb.setContent(moment.getContent());
		mb.setImageUrls(moment.getImageUrls().split(","));
		mb.setName(moment.getName());
		List<MomentBean> m = new ArrayList<MomentBean>();
		m.add(mb);
		
		JSONArray moments = JSONArray.fromObject(mb);
		return moments.toString();
	}
	
	@RequestMapping("searchMoments")
	@ResponseBody
	public String searchMoments(String key){
		List<Moment> m = momentService.getAllMoments();
		List<MomentBean> mb = new ArrayList<MomentBean>();
		for(int i = 0;i<m.size();i++){
			Moment tempm = m.get(i);
			MomentBean tempmb = new MomentBean();
			tempmb.setName(tempm.getName());
			tempmb.setAvatorUrl(tempm.getAvatorUrl());
			tempmb.setImageUrls(tempm.getImageUrls().split(","));
			tempmb.setContent(tempm.getContent());
			if(((tempmb.getName()).contains(key))||((tempmb.getContent()).contains(key))){
			    mb.add(tempmb);
			}
		}
		JSONArray moments = JSONArray.fromObject(mb);
		return moments.toString();
	}
}
