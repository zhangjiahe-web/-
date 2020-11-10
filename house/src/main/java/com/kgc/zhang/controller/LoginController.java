package com.kgc.zhang.controller;

import com.kgc.zhang.entity.user;
import com.kgc.zhang.entity.userlist;
import com.kgc.zhang.service.UserInfoService;
import com.kgc.zhang.service.userlistService;
import javafx.scene.media.SubtitleTrack;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-10 9:53
 */
@Controller
public class LoginController {
    @Resource
    UserInfoService userInfoService;
    @Resource
    userlistService userlistService;

    @RequestMapping("/dologin")
    public String doLogin(HttpServletRequest request, HttpSession session, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        System.out.println(username);
        System.out.println(password);
        System.out.println(type);

        user user = null;
        try {
            user = userInfoService.selectByUserName(username);
            if (type.equals("zuke")) {
                if (username.equals(user.getUsername())) {
                    if (password.equals(user.getPassword())) {
                        if (type.equals(user.getType())) {
                            session.setAttribute("user", user);
                            return "zuke/main";
                        }
                    }
                } else {
                    request.setAttribute("error", "error");
                    return "login";
                }

            } else if (type.equals("admin")) {
                if (username.equals(user.getUsername())) {
                    if (password.equals(user.getPassword())) {
                        if (type.equals(user.getType())) {
                            session.setAttribute("user", user);
                            return "admin/main1";
                        }
                    }
                } else {
                    request.setAttribute("error", "error");
                    return "login";
                }
            }
        } catch (Exception e) {
            request.setAttribute("error", "error");
            return "login";
        }

        request.setAttribute("error", "error");
        return "login";


    }
}