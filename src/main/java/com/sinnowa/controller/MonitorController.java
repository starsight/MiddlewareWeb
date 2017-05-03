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
public class MonitorController {
	
	@Autowired
	private DSServiceImpl dsService;
	
	@RequestMapping(value="/hello",method= RequestMethod.GET)
	public String helloWorld(@RequestParam(value="dsJSON", defaultValue="null") String dsJSON,
							 HttpServletResponse response){
		//DS ds = new DS(id,enID,name,new Date());
		//dsService.updateDS(dsJSON);

		String jsonstring = "{\"Abb\":51,\"abbC\":3}";
		User u1 = JSON.parseObject(jsonstring, new TypeReference<User>(){});
        User u2 = JSON.parseObject(jsonstring,User.class);
        //System.out.println(u1.getAbb());
        //System.out.println(u2.getabb());

        return "hello";
	}
}
