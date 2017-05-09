package com.sinnowa.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.sinnowa.daoimpl.DSDaoImpl;
import com.sinnowa.entity.DsLisoutputEntity;
import com.sinnowa.service.DSPLService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DSServiceImpl implements DSPLService<DsLisoutputEntity>{

	@Autowired
	private DSDaoImpl dsDao;

	@Override
	public boolean createDSPL(String dsJSON) {
		DsLisoutputEntity dsLisoutputEntity = JSON.parseObject(dsJSON,DsLisoutputEntity.class);
		dsDao.createDSPL(dsLisoutputEntity);
		return false;
	}

	@Override
	public String getDSPL(String plJSON) {
        //dsDao.getDS();
		return null;
	}

	@Override
	public boolean updateDSPL(String dsJSON) {

		return false;
	}


}
