package com.sinnowa.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sinnowa.dao.DeviceMonitorDao;
import com.sinnowa.daoimpl.DeviceMonitorDaoImpl;
import com.sinnowa.entity.DeviceinfoEntity;
import com.sinnowa.entity.DsLisoutputEntity;
import com.sinnowa.entity.PlLisoutputEntity;
import com.sinnowa.service.DeviceMonitorService;
import com.sinnowa.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
@Service
public class DeviceMonitorServiceImpl implements DeviceMonitorService{

    @Autowired
    DeviceMonitorDaoImpl deviceMonitorDao;

    @Override
    public List<String> getDeviceNameByTimeService(Date baseDate) {

        Date startDate = Utils.getStartTimeOfDay(baseDate);
        Date endDate = Utils.getEndTimeOfDay(baseDate);

        List<String> list = deviceMonitorDao.getDeviceName(startDate,endDate);
        return list;
    }


    @Override
    public String getDeviceStateService(String deviceName) {
        DeviceinfoEntity device= deviceMonitorDao.getDeviceInfo(deviceName);
        String state =device.getState();
        return state;
    }

    /***
     * @param deviceName 设备名
     * @return 上次查询时间（若多余一小时以2小时位上限）
     * 功能：获取设备上次的查询时间，同时更新本次查询时间到数据库
     */
    @Override
    public long getNewSampleInfoService(String deviceName) {
        DeviceinfoEntity device= deviceMonitorDao.getDeviceInfo(deviceName);
        Date baseDate =device.getLastQueryTime();
        Date tempdate =Utils.getTimeBeforeTwoHour(new Date());
        if(baseDate.getTime()<tempdate.getTime()){
            baseDate = tempdate;
        }
        device.setLastQueryTime(new Timestamp(new Date().getTime()));
        deviceMonitorDao.update(device);
        return baseDate.getTime();
    }

    @Override
    public Date getLastQueryTimeService(String deviceName) {
        DeviceinfoEntity device= deviceMonitorDao.getDeviceInfo(deviceName);
        Date date =device.getLastQueryTime();
        return date;
    }


    @Override
    public List<Integer> getSampleNumberService(String deviceName) {
        List<Integer> list = new ArrayList<>();
        list.add(getSampleSum(deviceName));
        list.addAll(getSampleCountBy2Hours(deviceName));
        return list;
    }


    private int getSampleSum(String deviceName) {
        DeviceinfoEntity device= deviceMonitorDao.getDeviceInfo(deviceName);
        int sampleSum = device.getSampleSum();
        return sampleSum;
    }

    private List<Integer> getSampleCountBy2Hours(String deviceName) {
        DeviceinfoEntity device= deviceMonitorDao.getDeviceInfo(deviceName);

        List<Integer> sampleCountBy2HoursService= device.change2SampleCountList();
        return sampleCountBy2HoursService;
    }

    @Override
    public int getAverageDetectionTimeService(String deviceName) {
        DeviceinfoEntity device= deviceMonitorDao.getDeviceInfo(deviceName);
        int averageDetectionTime = device.getAverageDetectionTime();

        return averageDetectionTime;
    }

    @Override
    public String getSampleDetectionQualityService(String deviceName) {
        DeviceinfoEntity device= deviceMonitorDao.getDeviceInfo(deviceName);
        String quality = device.getSampleDetectionQuality();
        return quality;
    }

    @Override
    public Date getLastActiveTimeService(String deviceName) {
        DeviceinfoEntity device= deviceMonitorDao.getDeviceInfo(deviceName);
        Date date = device.getLastActiveTime();
        return date;
    }

    @Override
    public DeviceinfoEntity getDeviceAllInfoService(String deviceName) {
        return deviceMonitorDao.getDeviceInfo(deviceName);
    }

    @Override
    public List<DeviceinfoEntity> getAllDevicesInfoService() {
        List<DeviceinfoEntity> list = deviceMonitorDao.getDSPL("from DeviceinfoEntity",new Object[]{});
        return list;
    }


}
