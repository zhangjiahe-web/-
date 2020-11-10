package com.kgc.zhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestControllor {
    @RequestMapping("")
    public  String tologin(){
        return "login";
    }
    @RequestMapping("/tozhuce")
    public  String tozhuce(){
        return "register";
    }
    @RequestMapping("/toaddhouse")
    public  String toaddhouse(Model model){
        model.addAttribute("mainPage","../admin/addhouse.jsp");
        return "/admin/main1";
    }



}
