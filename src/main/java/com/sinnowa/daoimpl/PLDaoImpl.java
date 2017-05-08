package com.sinnowa.daoimpl;


import com.sinnowa.dao.DSPLDao;
import com.sinnowa.entity.PlLisoutputEntity;

import com.sinnowa.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
	public List<PlLisoutputEntity> getDSPL(String PLTime) {
        Session session=sessionFactory.openSession(); // 生成一个session
        session.beginTransaction(); // 开启事务

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String str = "2017-05-24 21:14:29";
        Date baseDate,startDate=null,endDate=null;
        try {
            baseDate = sdf.parse(PLTime);
            startDate = Utils.getStartTimeOfDay(baseDate);
            endDate = Utils.getEndTimeOfDay(baseDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String hql = "from PlLisoutputEntity where testTime between ? and ?";
        Query<PlLisoutputEntity> q=session.createQuery(hql,PlLisoutputEntity.class);
        q.setParameter(0,startDate);
        q.setParameter(0,endDate);
        List<PlLisoutputEntity> list = q.getResultList();

        session.getTransaction().commit(); // 提交事务
        session.close(); // 关闭session
        return list;
    }



}