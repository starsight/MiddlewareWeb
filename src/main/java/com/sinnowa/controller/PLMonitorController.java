package com.sinnowa.controller;

import com.sinnowa.serviceimpl.DSServiceImpl;
import com.sinnowa.serviceimpl.PLServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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


    @RequestMapping(value="/PLResult",method= RequestMethod.POST)
    public String createPLResult(@RequestParam(value="plJSON", defaultValue="null") String plJSON,
                                 HttpServletResponse response){
        plService.createDSPL(plJSON);
        return "success";
    }

    @RequestMapping(value="/PLResultByTime",method= RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getPLResult(@RequestParam(value="time", defaultValue="2017-05-15 00:00:00") String plJSON,
                                 HttpServletResponse response){
        //plJSON = "2005-01-01 21:14:29";
        return plService.getDSPLByTime(plJSON);
    }

    @RequestMapping(value="/PLResult",method= RequestMethod.PUT)
    public String updatePLResult(@RequestParam(value="plJSON", defaultValue="null") String plJSON,
                              HttpServletResponse response){
        plService.updateDSPL(plJSON);
        return "success";
    }

}
