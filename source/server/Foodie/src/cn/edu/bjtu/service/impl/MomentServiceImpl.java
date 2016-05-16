/**
 * 
 */
package cn.edu.bjtu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.MomentDao;
import cn.edu.bjtu.service.MomentService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Moment;

/**
 * @author solitudeycq
 *
 */
@Transactional
@Repository
public class MomentServiceImpl implements MomentService {
	@Autowired
	MomentDao momentDao;

	@Override
	public boolean insertMoment(Moment moment) {
		moment.setId(IdCreator.createMomentId());
		
		momentDao.save(moment);
		return true;
	}

	@Override
	public List<Moment> getAllMoments() {
		String hql = "from Moment";
		return momentDao.find(hql);
	}

	@Override
	public Moment getMomentByName(String name) {
		String hql = "from Moment where name='"+name+"'";
		return momentDao.get(hql);
	}
}
