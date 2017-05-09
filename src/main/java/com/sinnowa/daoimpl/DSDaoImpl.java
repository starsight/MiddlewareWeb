package com.sinnowa.daoimpl;

import com.sinnowa.dao.DSPLDao;
import com.sinnowa.entity.DsLisoutputEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DSDaoImpl extends BaseDao<DsLisoutputEntity> {

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public boolean updateDSPL(DsLisoutputEntity dsLisoutputEntity) {
		return false;
	}

	@Override
	public List<DsLisoutputEntity> getDSPL(String Time) {
		Session session=sessionFactory.openSession(); // 生成一个session
		List list= session.createQuery("from DsLisoutputEntity ").list();
		session.close();
		return null;
	}
}
