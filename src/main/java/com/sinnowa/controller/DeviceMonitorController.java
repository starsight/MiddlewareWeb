package com.sinnowa.controller;

import com.alibaba.fastjson.JSON;
import com.sinnowa.serviceimpl.DeviceMonitorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private DeviceMonitorServiceImpl deviceMonitorService;

    @RequestMapping(value="/DeviceList",method = RequestMethod.GET)
    public String getCurrentDeviceNameList(HttpServletResponse response){
        List<String> l = deviceMonitorService.getDeviceNameByTime(new Date());
        return JSON.toJSONString(l);
    }

    /**
    * 仪器的检测样本个数
     * 根据时间段区分,先检测样本总数，再每个时间段的样本数量
    * */
    @RequestMapping(value="/{DeviceName}/TestCount",method=RequestMethod.GET)
    public String getDeviceTestCount(@PathVariable("DeviceName") String deviceName,
            HttpServletResponse response){
        int count =0;
        return null;
    }

    public String hasNewSampleResult(){

        return null;
    }
}
