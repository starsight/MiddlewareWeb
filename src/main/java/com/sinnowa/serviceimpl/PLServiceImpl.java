package com.sinnowa.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinnowa.daoimpl.DSDaoImpl;
import com.sinnowa.daoimpl.PLDaoImpl;
import com.sinnowa.entity.DsLisoutputEntity;
import com.sinnowa.entity.PlLisoutputEntity;
import com.sinnowa.service.DSPLService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class PLServiceImpl implements DSPLService<PlLisoutputEntity> {

    @Autowired
    private PLDaoImpl plDao;

    @Override
    public boolean createDSPL(String plJSON) {
        List<PlLisoutputEntity> list=new ArrayList<PlLisoutputEntity>(JSONArray.parseArray(plJSON,PlLisoutputEntity.class));
        for (PlLisoutputEntity pl :list) {
            plDao.createDSPL(pl);
        }
        return false;
    }

    @Override
	public String getDSPL(String plJSON){
        List<PlLisoutputEntity> list = plDao.getDSPL(plJSON);

        HashMap<String,List<PlLisoutputEntity>> hashMap = new HashMap<>();
        for(PlLisoutputEntity pl :list){
            if(hashMap.get(pl.getSampleId())==null){
                List<PlLisoutputEntity> listtemp =  new ArrayList<>();
                listtemp.add(pl);
                hashMap.put(pl.getSampleId(),listtemp);
            }else{
                List<PlLisoutputEntity> a = hashMap.get(pl.getSampleId());
                a.add(pl);
                hashMap.put(pl.getSampleId(),a);
            }
        }

        JSONObject joo = new JSONObject();

        Collection<List<PlLisoutputEntity>> a = hashMap.values();
        Iterator it = a.iterator();
        while(it.hasNext()){
            List<PlLisoutputEntity> l = (List<PlLisoutputEntity>) it.next();
            //JSONArray jo = new JSONArray();
            //jo.add(l);
            joo.put(l.get(0).getSampleId(),l);
        }

        //String str2 =JSONArray.toJSONString(joo);
	    return JSON.toJSONString(joo);
    }

    @Override
    public boolean  updateDSPL(String plJSON) {
        return false;
    }

}
