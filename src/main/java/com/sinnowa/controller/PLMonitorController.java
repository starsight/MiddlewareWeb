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


    @RequestMapping(value="/updatePLResult",method= RequestMethod.POST)
    public String updateDSResult(@RequestParam(value="plJSON", defaultValue="null") String plJSON,
                                 HttpServletResponse response){
        //plService.updateDSPL(plJSON);
        plService.updateDSPL(plJSON);
        return "success";
    }

    @RequestMapping(value="/getPLResult",method= RequestMethod.GET)
    public String getDSResult(@RequestParam(value="plJSON", defaultValue="null") String plJSON,
                                 HttpServletResponse response){
        //plService.updateDSPL(plJSON);
        plService.getDSPL(plJSON);
        return "success";
    }
}
