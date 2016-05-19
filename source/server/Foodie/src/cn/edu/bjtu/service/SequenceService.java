/**
 * 
 */
package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Sequence;

/**
 * @author solitude
 *
 */
public interface SequenceService {
	
	public List<Sequence> operSequence(String userid,String type);
	
	public List<Sequence> all();

}
