package com.kgc.zhang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kgc.zhang.entity.user;
import com.kgc.zhang.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @author shkstart
 * @create 2020-09-11 13:00
 */
@Controller
public class RegisterController {
    @Resource
    UserInfoService userInfoService;

    @RequestMapping("registercheck")
    public String registercheck(HttpServletRequest request, Model model) {
        String usernamea = request.getParameter("usernamea");
        if (usernamea == null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String type = request.getParameter("type");
            user user = new user();
            user.setUsername(username);
            user.setType(type);
            user.setPassword(password);
            int insert = userInfoService.insert(user);
            if (insert > 0) {
                return "login";
            } else {
                return "register";
            }

        } else {
            model.addAttribute("msg", "用户名已存在");
            return "register";
        }
    }

    @RequestMapping("/ucexist")
    @ResponseBody
    public Map yanzheng(HttpServletRequest request, String userName) {
        Map map = new HashMap();
        System.out.println("第53行" + userName);
        user user = userInfoService.selectByUserName(userName);
        System.out.println("第五十四行" + user);
        if (user.getUsername().equals(userName)) {
            map.put("status", "true");
        } else {
            map.put("status", "false");
        }
        return map;
    }


    @RequestMapping("quemima")
    @ResponseBody
    public Map queMima(String password,String quepassword) {

        Map map = new HashMap();
        if (quepassword.equals(password)){

        }else{
            map.put("status", "false");
        }
        return map;
    }
}
