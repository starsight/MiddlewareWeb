package com.sinnowa.daoimpl;

import com.sinnowa.dao.DeviceMonitorDao;
import com.sinnowa.entity.DsLisoutputEntity;
import com.sinnowa.entity.PlLisoutputEntity;
import com.sinnowa.util.Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/5/24.
 */
@Repository
public class DeviceMonitorDaoImpl extends BaseDao implements DeviceMonitorDao {


    public List<String> getDeviceName(Date startDate,Date endDate){

        String dsHql ="from DsLisoutputEntity where time between ? and ?";
        List<DsLisoutputEntity> dsList =getDSPL(dsHql,new Object[]{startDate,endDate});

        String plHql ="from PlLisoutputEntity where testTime between ? and ?";
        List<PlLisoutputEntity> plList =getDSPL(plHql,new Object[]{startDate,endDate});

        Map<String,String> map =new HashMap<>();
        for (DsLisoutputEntity ds:dsList) {
            String devname = ds.getDeviceName();
            if(devname!=null)
                map.putIfAbsent(devname,devname);
        }
        for (PlLisoutputEntity pl:plList) {
            String devname = pl.getDeviceName();
            if(devname!=null)
                map.putIfAbsent(devname,devname);
        }

        List<String> devicenameList =new ArrayList<>();
        Set<String> set = map.keySet();
        devicenameList.addAll(set);

        return devicenameList;
    }
}
