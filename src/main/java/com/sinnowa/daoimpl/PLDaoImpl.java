package com.sinnowa.daoimpl;

import com.sinnowa.dao.DSPLDao;
import com.sinnowa.entity.PlLisoutputEntity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PLDaoImpl implements DSPLDao<PlLisoutputEntity> {

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public boolean updateDS(PlLisoutputEntity pl) {
		// TODO Auto-generated method stub
		return false;
	}
	
}