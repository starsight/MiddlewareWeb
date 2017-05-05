package com.sinnowa.daoimpl;


import com.sinnowa.dao.DSPLDao;
import com.sinnowa.entity.PlLisoutputEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PLDaoImpl implements DSPLDao<PlLisoutputEntity> {

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public boolean updateDSPL(PlLisoutputEntity pl){
		Session session=sessionFactory.openSession(); // 生成一个session
		session.beginTransaction(); // 开启事务
		session.save(pl);
        //session.persist(pl);
		session.getTransaction().commit(); // 提交事务
		session.close(); // 关闭session
		return false;
	}



}