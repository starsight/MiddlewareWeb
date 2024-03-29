package com.sinnowa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sinnowa.serviceimpl.DSServiceImpl;
import com.sinnowa.serviceimpl.PLServiceImpl;
import com.sinnowa.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/5.
 */
@RestController
@RequestMapping(value="/PL")
public class PLMonitorController {
    @Autowired
    private PLServiceImpl plService;


    @RequestMapping(value="/PLResult/{DeviceName}",method= RequestMethod.POST)
    public String createPLResult(@RequestParam(value="plJSON", defaultValue="null") String plJSON,
                                 @PathVariable("DeviceName") String deviceName,
                                 HttpServletResponse response){
        plService.createDSPL(plJSON,deviceName);
        return "success";
    }

    @RequestMapping(value="/PLResultByTime",method= RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getPLResult(@RequestParam(value="time", defaultValue="2005-01-01 00:00:00") String plJSON,
                                 HttpServletResponse response){
        //plJSON = "2005-01-01 21:14:29";
        Object[] objects =Utils.getStartEndDate(plJSON);
        JSONObject jo = plService.getDSPLByTime(objects);
        return JSON.toJSONString(jo);
    }

   /*@RequestMapping(value="/PLListByTime",method= RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getPLList(@RequestParam(value="time", defaultValue="2017-05-15 00:00:00") String plJSON,
                                      HttpServletResponse response){
        return plService.getDSPLByTime(plJSON);
    }*/

    @RequestMapping(value="/PLResultBySampleId",method= RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getPLResultSampleId(@RequestParam(value="sampleid", defaultValue="000001") String plJSON,
                              HttpServletResponse response){
        return plService.getDSPLBySampleId(plJSON);
    }

    @RequestMapping(value="/PLResult/{DeviceName}",method= RequestMethod.PUT)
    public String updatePLResult(@RequestParam(value="plJSON", defaultValue="null") String plJSON,
                                 @PathVariable("DeviceName") String deviceName,
                                 HttpServletResponse response){
        plService.updateDSPL(plJSON);
        return "success";
    }

}
