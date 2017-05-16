package com.sinnowa.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinnowa.daoimpl.DSDaoImpl;
import com.sinnowa.daoimpl.PLDaoImpl;
import com.sinnowa.entity.DsLisoutputEntity;
import com.sinnowa.entity.DsLisoutputEntityPK;
import com.sinnowa.entity.PlLisoutputEntity;
import com.sinnowa.entity.PlLisoutputEntityPK;
import com.sinnowa.service.DSPLService;
import com.sinnowa.util.Utils;

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
public class PLServiceImpl implements DSPLService<PlLisoutputEntity> {

    @Autowired
    private PLDaoImpl plDao;

    @Override
    public boolean createDSPL(String plJSON) {
        List<PlLisoutputEntity> list=new ArrayList<PlLisoutputEntity>(JSONArray.parseArray(plJSON,PlLisoutputEntity.class));
        for (PlLisoutputEntity pl :list) {
            plDao.save(pl);
        }
        return false;
    }


	public String getDSPLByTime(String plJSON){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String str = "2017-05-24 21:14:29";
        Date baseDate,startDate=null,endDate=null;
        try {
            baseDate = sdf.parse(plJSON);
            startDate = Utils.getStartTimeOfDay(baseDate);
            endDate = Utils.getEndTimeOfDay(baseDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Object[] objects = new Object[]{startDate,endDate};
        String hql ="from PlLisoutputEntity where testTime between ? and ?";
        List<PlLisoutputEntity> list = plDao.getDSPL(hql,objects);

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

    public String getDSPLBySampleId(String plJSON){

        Object[] objects = new Object[]{plJSON};
        String hql ="from PlLisoutputEntity where sampleId =?";
        List<PlLisoutputEntity> list = plDao.getDSPL(hql,objects);

        return JSON.toJSONString(list);
    }

    @Override
    public boolean  updateDSPL(String plJSON) {
	    //plDao.updateDSPL(null);
        /*List<PlLisoutputEntity> list=new ArrayList<PlLisoutputEntity>(JSONArray.parseArray(plJSON,PlLisoutputEntity.class));
        for (PlLisoutputEntity pl :list) {
            //plDao.updateDSPL(pl);
            PlLisoutputEntityPK plpk = new PlLisoutputEntityPK();
            plpk.setSampleId(pl.getSampleId());
            plpk.setBarCode(pl.getBarCode());
            plpk.setItem(pl.getItem());
            plpk.setTestTime(pl.getTestTime());
            plpk.setDevice(pl.getDevice());

            PlLisoutputEntity pltemp = plDao.get(PlLisoutputEntity.class,plpk);
            pltemp.setIssend(true);
            plDao.save(pltemp);
        }*/

        PlLisoutputEntityPK plLisoutputEntity = JSON.parseObject(plJSON,PlLisoutputEntityPK.class);
        String hql = "from PlLisoutputEntity where sampleId=? and device =? and item =?";

        Object[] objects =new Object[3];
        objects[0] = plLisoutputEntity.getSampleId();
        objects[1] = plLisoutputEntity.getDevice();
        objects[2] = plLisoutputEntity.getItem();

        PlLisoutputEntity ds = plDao.getDSPLById(hql,objects);
        //PlLisoutputEntity ds = plDao.get(PlLisoutputEntity.class,plLisoutputEntity);

        ds.setIssend(true);

        plDao.update(ds);
        return false;
    }

}
