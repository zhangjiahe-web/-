package com.kgc.zhang.controller.fangdong;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.user;
import com.kgc.zhang.entity.userlist;
import com.kgc.zhang.service.userlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class zhglController {
    @Resource
    userlistService userlistService;
    @RequestMapping("findalluserlist")
    public  String findalluserlist(Model model, HttpServletRequest request,String pageNumStr){
        user user = (user) request.getSession().getAttribute("user");
        Integer pageNum=1;//第几页
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        Integer pageSize=5;//每页的数量

//排序
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id desc");
        List<userlist> zhgl = userlistService.zhgl(user.getUsername());
        PageInfo<userlist> list = new PageInfo<>(zhgl);
        model.addAttribute("pageInfo",list);
        model.addAttribute("mainPage", "../admin/userlist.jsp");
        return "admin/main1";
    }
}
