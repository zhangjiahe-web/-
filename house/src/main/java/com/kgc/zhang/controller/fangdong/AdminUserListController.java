package com.kgc.zhang.controller.fangdong;

import com.kgc.zhang.entity.user;
import com.kgc.zhang.entity.userlist;
import com.kgc.zhang.service.userlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminUserListController {
    @Resource
    userlistService userlistService;
    @RequestMapping("/findhasuserlist1")
    public String findhasuserlist1(Model model,HttpServletRequest request) {
        user user = (user) request.getSession().getAttribute("user");
        List<userlist> userlist = userlistService.UserListID(user.getId());
        if (userlist.size()==0){
            model.addAttribute("mainPage","../admin/updateuserlist.jsp");
            return"admin/main1";
        }else {

            System.out.println(userlist);
            model.addAttribute("userlist", userlist.get(0));
            model.addAttribute("mainPage","../admin/updateuserlist.jsp");
            return"admin/main1";
        }


}

//完善资料
@RequestMapping("/checkuserlist1")
    public  String checkuserlist1  (userlist userlist,Model model,HttpServletRequest request){
    user user = (user) request.getSession().getAttribute("user");
    userlist.setUserId(user.getId());
    int i = userlistService.userlistAdd(userlist);
    if (i>0){
        model.addAttribute("error", "绑定成功！");
        model.addAttribute("mainPage","../admin/updateuserlist.jsp");
        return"admin/main1";
    }else {
        model.addAttribute("error", "绑定失败请自行检查！！！");
        model.addAttribute("mainPage","../admin/updateuserlist.jsp");
        return"admin/main1";
    }

}
//判断是否完善用户资料;
    @RequestMapping("/checkuserlists1")
    @ResponseBody
    public Map checkuserlists1(HttpServletRequest request, Model model) {
        Map map = new HashMap();
        user user = (user) request.getSession().getAttribute("user");
        List<userlist> userlists = userlistService.UserListID(user.getId());

        if (userlists.size() == 0) {
            model.addAttribute("info", "请完善资料后再使用本功能！");
            map.put("status","flase");

        }else {

            map.put("status","true");
        }
        return map;
    }

}
