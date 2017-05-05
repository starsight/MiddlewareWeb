package com.sinnowa.daoimpl;

import com.sinnowa.dao.DSPLDao;
import com.sinnowa.entity.DsLisoutputEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DSDaoImpl implements DSPLDao<DsLisoutputEntity> {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public boolean updateDSPL(DsLisoutputEntity ds) {
		//Configuration configuration=new Configuration().configure(); // 实例化配置文件
		//ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();// 实例化服务登记
		//SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry); // 获取Session工厂
		Session session=sessionFactory.openSession(); // 生成一个session
		session.beginTransaction(); // 开启事务

		session.save(ds);//session.persist(ds);

		session.getTransaction().commit(); // 提交事务
		session.close(); // 关闭session
		//sessionFactory.close(); // 关闭session工厂
		return false;
	}

	public boolean getDS(){
		Session session=sessionFactory.openSession(); // 生成一个session
		List list= session.createQuery("from DsLisoutputEntity ").list();
        session.close();
		return false;
	}

}
