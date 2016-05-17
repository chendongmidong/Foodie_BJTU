/**
 * 
 */
package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Moment;

/**
 * @author solitudeycq
 *
 */
public interface MomentService {
	
	public boolean insertMoment(Moment moment);
	
	public List<Moment> getAllMoments();
	public Moment getMomentByName(String name);
	public String updateImageUrls(String userid,String strImageContent,String type);

}
