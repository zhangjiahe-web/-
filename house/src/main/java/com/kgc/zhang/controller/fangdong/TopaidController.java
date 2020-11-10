package com.kgc.zhang.controller.fangdong;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.topaid;
import com.kgc.zhang.entity.user;
import com.kgc.zhang.service.topaidService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TopaidController {
    @Resource
    topaidService topaidService;
    @RequestMapping("topaidlist")
    public  String topaidlist(Model model, HttpServletRequest request,String pageNumStr){
        user user = (user) request.getSession().getAttribute("user");
        Integer pageNum=1;//第几页
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        Integer pageSize=5;//每页的数量

//排序
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id desc");
        List<topaid> fdzujinweijiao = topaidService.fdzujinweijiao(user.getUsername());
        PageInfo<topaid> list = new PageInfo<>(fdzujinweijiao);
        model.addAttribute("pageInfo",list);
        model.addAttribute("mainPage", "topaid.jsp");
        return "admin/main1";

    }
}
