package com.sinnowa.service;

import com.sinnowa.entity.DeviceinfoEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
public interface DeviceMonitorService {
    List<String> getDeviceNameByTimeService(Date date);
    String getDeviceStateService(String deviceName);
    long getNewSampleInfoService(String deviceName);
    Date getLastQueryTimeService(String deviceName);
    //int getSampleSumService(String deviceName);
    //List<Integer> getSampleCountBy2HoursService(String deviceName);
    List<Integer> getSampleNumberService(String deviceName);
    int getAverageDetectionTimeService(String deviceName);
    String getSampleDetectionQualityService(String deviceName);
    Date getLastActiveTimeService(String deviceName);
    DeviceinfoEntity getDeviceAllInfoService(String deviceName);
    List<DeviceinfoEntity> getAllDevicesInfoService();
}
