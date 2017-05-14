package com.sinnowa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by yiyuan on 17/5/14.
 */

@RestController
public class LoginController {

    @RequestMapping(value="/Login",method= RequestMethod.POST)
    public String getPLResult(@RequestParam(value="username", defaultValue="admin") String username,
                              @RequestParam(value="password", defaultValue = "admin") String password,
                              HttpServletResponse response){

        return "success";
    }
}
