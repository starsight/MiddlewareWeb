package com.sinnowa.daoimpl;

import com.sinnowa.dao.DSPLDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
public class BaseDao<T> implements DSPLDao<T>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean createDSPL(T t) {
        //Configuration configuration=new Configuration().configure(); // 实例化配置文件
        //ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();// 实例化服务登记
        //SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry); // 获取Session工厂
        Session session=sessionFactory.openSession(); // 生成一个session
        session.beginTransaction(); // 开启事务

        session.save(t);//session.persist(ds);

        session.getTransaction().commit(); // 提交事务
        session.close(); // 关闭session
        //sessionFactory.close(); // 关闭session工厂
        return false;
    }

    @Override
    public boolean updateDSPL(T t) {
        return false;
    }

    @Override
    public List<T> getDSPL(String Time) {
        return null;
    }
}
