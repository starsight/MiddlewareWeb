package com.sinnowa.daoimpl;

import com.sinnowa.dao.DSPLDao;
import com.sinnowa.entity.DsLisoutputEntityPK;
import com.sinnowa.entity.PlLisoutputEntity;
import com.sinnowa.util.Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
public class BaseDao<T> implements DSPLDao<T>{

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public T get(Class<T> entityclass, Serializable id){
        Session session=sessionFactory.getCurrentSession(); // 生成一个session
        session.beginTransaction(); // 开启事务

        T t = session.get(entityclass,id);

        session.getTransaction().commit(); // 提交事务
        //session.close(); // 关闭session
        return t;
    }

    public Serializable save(T t){
        Session session=sessionFactory.getCurrentSession(); // 生成一个session
        session.beginTransaction(); // 开启事务

        Serializable s = session.save(t);//session.persist(ds);

        session.getTransaction().commit(); // 提交事务

        return s;
    }

    public void update(T t){
        Session session=sessionFactory.getCurrentSession(); // 生成一个session
        session.beginTransaction(); // 开启事务

        session.saveOrUpdate(t);

        session.getTransaction().commit(); // 提交事务
    }

    public T getDSPLById(String hql,Object[] objects){
        Session session=getSessionFactory().getCurrentSession(); // 生成一个session
        session.beginTransaction(); // 开启事务
        Query q = session.createQuery(hql);
        for(int i=0;i<objects.length;i++){
            q.setParameter(i,objects[i]);
        }
        /*q.setParameter(0,plLisoutputEntity.getSampleId());
        q.setParameter(1,plLisoutputEntity.getBarCode());
        q.setParameter(2,plLisoutputEntity.getDevice());
        q.setParameter(3,plLisoutputEntity.getItem());*/
        /*q.setParameter(0,"000001");
        //q.setParameter(1,"E");
        q.setParameter(1,"PL_12");
        q.setParameter(2,"AAR");*/
        //List li = q.list();
        T pl = (T) q.uniqueResult();
        session.getTransaction().commit(); // 提交事务
        return pl;
    }

    public List<T> getDSPL(String hql,Object[] objects) {
        Session session=getSessionFactory().getCurrentSession(); // 生成一个session
        session.beginTransaction(); // 开启事务

        Query<T> q=session.createQuery(hql);
        for(int i=0;i<objects.length;i++){
            q.setParameter(i,objects[i]);
        }
        List<T> list = q.getResultList();

        session.getTransaction().commit(); // 提交事务
        //session.close(); // 关闭session
        return list;
    }
}
