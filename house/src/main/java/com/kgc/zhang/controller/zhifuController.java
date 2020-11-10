package com.kgc.zhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class zhifuController {
    @RequestMapping("zhifu")
    public  String zhifu(){
        return "alipay.trade.page.pay";
    }
}
