package com.sinnowa.dao;

import com.sinnowa.entity.DeviceinfoEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
public interface DeviceMonitorDao {
    List<String> getDeviceName(Date startDate,Date endDate);
    //String getDeviceState(String deviceName);
    //Date getLastQueryTime(String deviceName);
    //int getSampleSum(String deviceName);
    //List<Integer> getSampleCountBy2Hours(String deviceName);
    //int getAverageDetectionTime(String deviceName);
    //String getSampleDetectionQuality(String deviceName);
    //Date getLastActiveTime(String deviceName);

    /*boolean updateDeviceState(String deviceName,String state);
    boolean updateLastQueryTime(String deviceName,Date lastQueryTime);
    boolean updateSampleSum(String deviceName,int SampleSum);
    boolean updateSampleCountBy2Hours(String deviceName,List<Integer> SampleCount);
    boolean updateAverageDetectionTime(String deviceName, Date averageDetectionTime);
    boolean updateSampleDetectionQuality(String deviceName,String quality);
    boolean updateLastActiveTime(String deviceName,Date activeTime);*/
    DeviceinfoEntity getDeviceInfo(String deviceName);
    boolean updateDeviceInfo(DeviceinfoEntity device);

}
