package com.sinnowa.serviceimpl;

import com.sinnowa.dao.DeviceMonitorDao;
import com.sinnowa.daoimpl.DeviceMonitorDaoImpl;
import com.sinnowa.service.DeviceMonitorService;
import com.sinnowa.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
@Service
public class DeviceMonitorServiceImpl implements DeviceMonitorService{

    @Autowired
    DeviceMonitorDaoImpl deviceMonitorDao;

    @Override
    public List<String> getDeviceNameByTime(Date baseDate) {

        Date startDate = Utils.getStartTimeOfDay(baseDate);
        Date endDate = Utils.getEndTimeOfDay(baseDate);

        List<String> list = deviceMonitorDao.getDeviceName(startDate,endDate);
        return list;
    }

}
