package com.sinnowa.serviceimpl;

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
	public boolean updateDS(String dsJSON) {

		//dsDao.updateDS();
		return false;
	}

}
