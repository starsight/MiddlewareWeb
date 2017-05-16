package com.sinnowa.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sinnowa.daoimpl.DSDaoImpl;
import com.sinnowa.entity.DsLisoutputEntity;
import com.sinnowa.entity.DsLisoutputEntityPK;
import com.sinnowa.entity.DsLisoutputEntity;
import com.sinnowa.entity.PlLisoutputEntity;
import com.sinnowa.service.DSPLService;
import com.sinnowa.util.Utils;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class DSServiceImpl implements DSPLService<DsLisoutputEntity>{

	@Autowired
	private DSDaoImpl dsDao;

	@Override
	public boolean createDSPL(String dsJSON) {
		DsLisoutputEntity dsLisoutputEntity = JSON.parseObject(dsJSON,DsLisoutputEntity.class);
		dsDao.save(dsLisoutputEntity);
		return false;
	}


	@Override
	public boolean updateDSPL(String dsJSON) {
        DsLisoutputEntityPK dsLisoutputEntity = JSON.parseObject(dsJSON,DsLisoutputEntityPK.class);
        String hql = "from DsLisoutputEntity where sampleId=? and device =? and item =?";

        Object[] objects =new Object[3];
        objects[0] = dsLisoutputEntity.getSampleId();
        objects[1] = dsLisoutputEntity.getDevice();
        objects[2] = dsLisoutputEntity.getItem();
        //objects[3] = "生化";

        DsLisoutputEntity ds = dsDao.getDSPLById(hql,objects);

        ds.setIssend(true);

        dsDao.update(ds);

		return false;
	}

    public String getDSPLByTime(String dsJSON){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String str = "2017-05-24 21:14:29";
        Date baseDate,startDate=null,endDate=null;
        try {
            baseDate = sdf.parse(dsJSON);
            startDate = Utils.getStartTimeOfDay(baseDate);
            endDate = Utils.getEndTimeOfDay(baseDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Object[] objects = new Object[]{startDate,endDate};
        String hql ="from DsLisoutputEntity where time between ? and ?";
        List<DsLisoutputEntity> list = dsDao.getDSPL(hql,objects);

        HashMap<String,List<DsLisoutputEntity>> hashMap = new HashMap<>();
        for(DsLisoutputEntity pl :list){
            if(hashMap.get(pl.getSampleId())==null){
                List<DsLisoutputEntity> listtemp =  new ArrayList<>();
                listtemp.add(pl);
                hashMap.put(pl.getSampleId(),listtemp);
            }else{
                List<DsLisoutputEntity> a = hashMap.get(pl.getSampleId());
                a.add(pl);
                hashMap.put(pl.getSampleId(),a);
            }
        }

        JSONObject joo = new JSONObject();

        Collection<List<DsLisoutputEntity>> a = hashMap.values();
        Iterator it = a.iterator();
        while(it.hasNext()){
            List<DsLisoutputEntity> l = (List<DsLisoutputEntity>) it.next();
            //JSONArray jo = new JSONArray();
            //jo.add(l);
            joo.put(l.get(0).getSampleId(),l);
        }

        //String str2 =JSONArray.toJSONString(joo);
        return JSON.toJSONString(joo);
    }

    public String getDSPLBySampleId(String dsJSON){

        Object[] objects = new Object[]{dsJSON};
        String hql ="from DsLisoutputEntity where sampleId =?";
        List<DsLisoutputEntity> list = dsDao.getDSPL(hql,objects);

        return JSON.toJSONString(list);
    }

}
