package com.sinnowa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinnowa.entity.DeviceinfoEntity;
import com.sinnowa.serviceimpl.DSServiceImpl;
import com.sinnowa.serviceimpl.DeviceMonitorServiceImpl;
import com.sinnowa.serviceimpl.PLServiceImpl;
import com.sinnowa.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    private PLServiceImpl plService;


    @Autowired
    private DeviceMonitorServiceImpl deviceMonitorService;

    @RequestMapping(value="/TodayActiveDevicesList",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getCurrentDeviceNameList(HttpServletResponse response){
        List<String> l = deviceMonitorService.getDeviceNameByTimeService(new Date());
        String json = new JSONObject().toJSONString(l);
        return json;
    }

    @RequestMapping(value="/TodayActiveDevicesInfo",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getTodayActiveDevicesInfo(HttpServletResponse response){
        List<String> l = deviceMonitorService.getDeviceNameByTimeService(new Date());
        JSONObject jsonObject =new JSONObject();
        List<DeviceinfoEntity> list = new ArrayList<>();
        for (String deviceName:l) {
            DeviceinfoEntity deviceinfoEntity = deviceMonitorService.getDeviceAllInfoService(deviceName);
            list.add(deviceinfoEntity);
        }

        String json = jsonObject.toJSONString(list);
        return json;
    }

    @RequestMapping(value="/HistoryDevicesInfo",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getCurrentDeviceInfo(HttpServletResponse response){
        List<DeviceinfoEntity> l = deviceMonitorService.getAllDevicesInfoService();
        return JSON.toJSONString(l);
    }

    /**
     *
     * @param deviceName 查询的设备名
     * @param deviceItem 查询的设备项
     * @return String json 结果JSON串
     * 功能：根据URL的Name和Item选择不同的服务项目，封装后的JSON串都是带DeviceName标签字段的
     * 对于样本检测数，先发送总的SampleCount，再根据每两小时一个结果发12个SampleNum，标号SampleNum0，2,4...22
     * 对于新样本信息，会依次查询DS，PL设备，再拼装成一个JSON串，如果上次查询时间大于一小时，以一小时查询为上限进行查询
     */
    @RequestMapping(value = "/{DeviceName}/{DeviceItem}", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getDeviceState(@PathVariable("DeviceName") String deviceName,
                                 @PathVariable("DeviceItem") String deviceItem){
        String json = null;
        switch(deviceItem){
            case "DeviceAllInfo":{
                DeviceinfoEntity deviceinfoEntity = deviceMonitorService.getDeviceAllInfoService(deviceName);
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("DeviceName",deviceName);
                jsonObject.put("AllDeviceInfo",deviceinfoEntity);
                json = jsonObject.toJSONString();
                break;
            }
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

                JSONObject jo = dsService.getDSPLByTime(new Object[]{new Date(l),new Date(),deviceName});
                JSONObject jo2 =  plService.getDSPLByTime(new Object[]{new Date(l),new Date(),deviceName});
                Set<String> set =jo.keySet();
                for(String s:set){
                    JSONArray ja = jo.getJSONArray(s);
                    jo2.put(s,ja);
                }
                json = JSON.toJSONString(jo2);

            }
            default:break;
        }

        return  json;
    }
}
