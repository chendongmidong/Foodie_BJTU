/**
 * 
 */
package cn.edu.bjtu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.SequenceUserViewDao;
import cn.edu.bjtu.service.SequenceUserViewService;
import cn.edu.bjtu.vo.Sequence_User_View;

/**
 * @author solitude
 *
 */
@Service
@Transactional
public class SequenceUserViewServiceImpl implements SequenceUserViewService {
	@Autowired
	SequenceUserViewDao sequenceUserViewDao;

	@Override
	public List<Sequence_User_View> all() {
		String hql = "from Sequence_User_View";
		return sequenceUserViewDao.find(hql);
	}
	
	

}
