package com.sinnowa.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sinnowa.daoimpl.DSDaoImpl;
import com.sinnowa.daoimpl.PLDaoImpl;
import com.sinnowa.entity.DsLisoutputEntity;
import com.sinnowa.entity.PlLisoutputEntity;
import com.sinnowa.service.DSPLService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PLServiceImpl implements DSPLService<PlLisoutputEntity> {

    @Autowired
    private PLDaoImpl plDao;

	@Override
	public boolean updateDSPL(String plJSON) {
        List<PlLisoutputEntity> list=new ArrayList<PlLisoutputEntity>(JSONArray.parseArray(plJSON,PlLisoutputEntity.class));
        for (PlLisoutputEntity pl :list) {
            plDao.updateDSPL(pl);
        }
		return false;
	}

}
