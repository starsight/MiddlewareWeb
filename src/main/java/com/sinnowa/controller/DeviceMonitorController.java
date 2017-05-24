package com.sinnowa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sinnowa.serviceimpl.DSServiceImpl;
import com.sinnowa.serviceimpl.DeviceMonitorServiceImpl;
import com.sinnowa.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/24.
 */
@RestController
@RequestMapping(value="/DeviceMonitor")
public class DeviceMonitorController {

    @Autowired
    private DSServiceImpl dsService;

    @Autowired
    private DeviceMonitorServiceImpl deviceMonitorService;

    @RequestMapping(value="/DeviceList",method = RequestMethod.GET)
    public String getCurrentDeviceNameList(HttpServletResponse response){
        List<String> l = deviceMonitorService.getDeviceNameByTimeService(new Date());
        return JSON.toJSONString(l);
    }

    /**
    * 仪器的检测样本个数
     * 根据时间段区分,先检测样本总数，再每个时间段的样本数量
    * */
    @RequestMapping(value="/{DeviceName}/SampleSum",method=RequestMethod.GET)
    public String getDeviceTestCount(@PathVariable("DeviceName") String deviceName,
            HttpServletResponse response){
        int count =0;
        return null;
    }

    @RequestMapping(value = "/{DeviceName}/{DeviceItem}", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getDeviceState(@PathVariable("DeviceName") String deviceName,
                                 @PathVariable("DeviceItem") String deviceItem){
        String json = null;
        switch(deviceItem){
            case "State":{
                String temp = deviceMonitorService.getDeviceStateService(deviceName);
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("DeviceName",deviceName);
                jsonObject.put("State",temp);
                json = jsonObject.toJSONString();
                break;
            }
            case "SampleNumber":{
                List<Integer> list = deviceMonitorService.getSampleNumberService(deviceName);
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("DeviceName",deviceName);
                jsonObject.put("SampleCount",list.get(0));
                for(int i=1;i<list.size();i++){
                    jsonObject.put("SampleNum"+(i-1)*2,list.get(i));
                }
                json = jsonObject.toJSONString();
                break;
            }
            case "AverageDetectionTime":{
                int time = deviceMonitorService.getAverageDetectionTimeService(deviceName);
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("DeviceName",deviceName);
                jsonObject.put("AverageDetectionTime",time);
                json = jsonObject.toJSONString();
                break;
            }
            case "SampleDetectionQuality":{
                String temp = deviceMonitorService.getSampleDetectionQualityService(deviceName);
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("DeviceName",deviceName);
                jsonObject.put("SampleDetectionQuality",temp);
                json = jsonObject.toJSONString();
                break;
            }
            case "LastActiveTime":{
                Date temp = deviceMonitorService.getLastActiveTimeService(deviceName);
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("DeviceName",deviceName);
                jsonObject.put("LastActiveTime",temp);
                json = jsonObject.toJSONString();
                //LastActiveTime: 1495629904000
                break;
            }
            case "LastQueryTime":{
                Date temp = deviceMonitorService.getLastQueryTimeService(deviceName);
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("DeviceName",deviceName);
                jsonObject.put("LastQueryTime",temp);
                json = jsonObject.toJSONString();
                break;
            }
            case "NewSample":{
                Long l = deviceMonitorService.getNewSampleInfoService(deviceName);
                /*JSONObject jsonObject =new JSONObject();
                jsonObject.put("DeviceName",deviceName);*/
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //jsonObject.put("NewSample",sdf.format(new Date(l)));

                json = dsService.getDSPLByTime(new Object[]{new Date(l),new Date()});

                //json = jsonObject.toJSONString();

            }
            default:break;
        }

        return  json;
    }
}
