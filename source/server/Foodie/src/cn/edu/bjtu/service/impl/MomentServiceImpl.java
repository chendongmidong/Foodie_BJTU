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
import cn.edu.bjtu.util.FoodieUploadFile;
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

	@Override
	public String updateImageUrls(String userid, String strImageContent, String type) {
		// �����typeָ���ǵڼ�����Ƭ����ʾ����
		
		//�Ȱ�type�ÿ�
		type = "";
		int count = 0;
		String hql = "from Moment where userid='"+userid+"'";
		Moment mo = momentDao.get(hql);
		
		//����type
		if(((mo.getImageUrls()+"").equals("null"))||(((mo.getImageUrls()).equals("")))){
			count = 1;
			type = type + (count+"");
		}else{
			String[] l = mo.getImageUrls().split(",");
			count = l.length + 1;
			type = type + (count+"");
		}
		
		String url = FoodieUploadFile.mobileuploadFile(userid, strImageContent, type);
		
		//����moment��imageUrls�ֶ�
		if(((mo.getImageUrls()+"").equals("null"))||(((mo.getImageUrls()).equals("")))){
			mo.setImageUrls(url);
		}else{
			mo.setImageUrls(mo.getImageUrls()+","+url);
		}
		
		//����moment
		momentDao.update(mo);
		
		return mo.getImageUrls();
	}
}
