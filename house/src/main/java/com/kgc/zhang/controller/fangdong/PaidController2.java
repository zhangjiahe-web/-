package com.kgc.zhang.controller.fangdong;

import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.paid;
import com.kgc.zhang.entity.user;
import com.kgc.zhang.entity.zulist;
import com.kgc.zhang.service.paidService;
import com.kgc.zhang.service.zulistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-29 9:41
 */
@Controller
public class PaidController2 {
    @Resource
    paidService paidServicea;

    @Resource
    zulistService zulistServicea;

    @RequestMapping("toshowaddpaid")
    public String showaddpaid(Model model, HttpServletRequest request,String pageNumStr) {
        Integer pageNum = 1;//第几页
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        user user = (user)request.getSession().getAttribute("user");
        String landlady=user.getUsername();
        Integer pageSize = 5;//每页的数量
        PageInfo<zulist> zulistPageInfo = zulistServicea.select(pageNum, pageSize,landlady);
        model.addAttribute("zulistPageInfo",zulistPageInfo);
        model.addAttribute("mainPage", "showaddpaid.jsp");
        return "admin/main1";
    }
}
