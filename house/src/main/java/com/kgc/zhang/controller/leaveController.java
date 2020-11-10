package com.kgc.zhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class leaveController {
    @RequestMapping("leavelogin")
    public  String leavelogin(HttpSession session){
        session.invalidate();
        return"login";
    }

}
