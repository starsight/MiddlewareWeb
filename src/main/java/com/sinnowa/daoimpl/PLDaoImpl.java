package com.sinnowa.daoimpl;


import com.sinnowa.dao.DSPLDao;
import com.sinnowa.entity.PlLisoutputEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

	public PlLisoutputEntity getDSPL(String PL){
        Session session=sessionFactory.openSession(); // 生成一个session
        session.beginTransaction(); // 开启事务

        String hql = "from PlLisoutputEntity where sampleId like ?";
        Query<PlLisoutputEntity> q=session.createQuery(hql,PlLisoutputEntity.class);
        q.setParameter(0,"333");
        List<PlLisoutputEntity> list = q.getResultList();

        session.getTransaction().commit(); // 提交事务
        session.close(); // 关闭session

        return null;
    }



}