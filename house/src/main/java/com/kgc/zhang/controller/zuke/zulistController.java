package com.kgc.zhang.controller.zuke;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.*;
import com.kgc.zhang.service.applyoutService;
import com.kgc.zhang.service.userlistService;
import com.kgc.zhang.service.zulistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class zulistController {
    @Resource
    applyoutService applyoutService;
    @Resource
    zulistService zulistService;
    @Resource
    userlistService userlistService;
    @RequestMapping("myzulist")
    public  String myzulist(Model model, HttpServletRequest request,String pageNumStr){
        user user = (user) request.getSession().getAttribute("user");
        userlistExample example1 =new userlistExample();
        userlistExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUserIdEqualTo(user.getId());
        List<userlist> userlists = userlistService.GetAll(example1);
        zulistExample example =new zulistExample();
        zulistExample.Criteria criteria = example.createCriteria();
        criteria.andUserlistIdEqualTo(userlists.get(0).getId());
        Integer pageNum=1;//第几页
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        Integer pageSize=5;//每页的数量

//排序
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("zid desc");
        List<zulist> zulin = zulistService.zulin(example);
        PageInfo<zulist> list = new PageInfo<>(zulin);

        model.addAttribute("pageInfo",list);
        model.addAttribute("mainPage", "myzulist.jsp");
        return "zuke/main";

    }
    @RequestMapping("zukeseehetong")
public  String zukeseehetong (Integer contractId,Model model){
        hetong chahetong = zulistService.chahetong(contractId);
        model.addAttribute("hetong",chahetong);
        model.addAttribute("mainPage", "showhetong.jsp");
        return "zuke/main";
    }
    /*申请退宿*/
    @RequestMapping("insertapplyout")
    public  String  insertapplyout(String houseid, String address, HttpServletRequest request){
        user user = (user) request.getSession().getAttribute("user");
        userlistExample example1 =new userlistExample();
        userlistExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUserIdEqualTo(user.getId());

        List<userlist> userlists = userlistService.GetAll(example1);
        applyout applyout=new applyout();
        applyout.setAddress(address);
        applyout.setHouseId(houseid);
        applyout.setStatus("申请中");
        applyout.setUserlistId(userlists.get(0).getId());
        int i = applyoutService.insertSelective(applyout);
        if (i>0){
            return "redirect:myzulist";
        }else {
            return "redirect:myzulist";
        }

    }

}
