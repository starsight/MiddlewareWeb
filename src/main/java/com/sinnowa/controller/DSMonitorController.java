package com.sinnowa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sinnowa.entity.User;
import com.sinnowa.serviceimpl.DSServiceImpl;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value="/DS")
public class DSMonitorController {
	
	@Autowired
	private DSServiceImpl dsService;
	

    @RequestMapping(value="/DSResult",method= RequestMethod.POST)
    public String createDSResult(@RequestParam(value="dsJSON", defaultValue="null") String dsJSON,
                             HttpServletResponse response){
        dsService.createDSPL(dsJSON);
        return "success";
    }

    @RequestMapping(value="/DSResultByTime",method= RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getDSResult(@RequestParam(value="time", defaultValue="2017-02-16 00:00:00") String dsJSON,
                              HttpServletResponse response){
        //dsJSON = "2017-02-16 21:14:29";
        return dsService.getDSPLByTime(dsJSON);
    }

    @RequestMapping(value="/DSResultBySampleId",method= RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getDSResultSampleId(@RequestParam(value="sampleid", defaultValue="201702160025") String dsJSON,
                                      HttpServletResponse response){
        return dsService.getDSPLBySampleId(dsJSON);
    }

    @RequestMapping(value="/DSResult",method= RequestMethod.PUT)
	public String updateDSResult(@RequestParam(value="dsJSON", defaultValue="null") String dsJSON,
								 HttpServletResponse response){

        dsService.updateDSPL(dsJSON);
		return "success";
	}
}
