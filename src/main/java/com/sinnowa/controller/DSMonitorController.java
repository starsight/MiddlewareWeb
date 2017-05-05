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
	
	@RequestMapping(value="/hello",method= RequestMethod.GET)
	public String helloWorld(@RequestParam(value="dsJSON", defaultValue="null") String dsJSON,
							 HttpServletResponse response){
		//DS ds = new DS(id,enID,name,new Date());
		//dsService.updateDS(dsJSON);

		dsService.getDS();

        return "hello";
	}

    @RequestMapping(value="/updateDSResult",method= RequestMethod.POST)
    public String updateDSResult(@RequestParam(value="dsJSON", defaultValue="null") String dsJSON,
                             HttpServletResponse response){
        dsService.updateDSPL(dsJSON);
        return "success";
    }
}
