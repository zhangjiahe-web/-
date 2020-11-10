package com.kgc.zhang.controller.zuke;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.*;
import com.kgc.zhang.service.paidService;
import com.kgc.zhang.service.topaidService;
import com.kgc.zhang.service.userlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class topaidContoller {
    @Resource
    topaidService topaidService;
    @Resource
    userlistService userlistService;
    @Resource
    paidService paidService;
    @RequestMapping("mytopaidlist")
    public  String mytopaidlist(Model model, HttpServletRequest request,String pageNumStr){
        user user = (user) request.getSession().getAttribute("user");
        userlistExample example1 =new userlistExample();
        userlistExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUserIdEqualTo(user.getId());

        List<userlist> userlists = userlistService.GetAll(example1);

        Integer pageNum=1;//第几页
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        Integer pageSize=5;//每页的数量

//排序
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id asc");

        topaidExample example=new topaidExample();
        topaidExample.Criteria criteria = example.createCriteria();
        criteria.andUserlistIdEqualTo(userlists.get(0).getId());

        List<topaid> zkdaijiaozujin = topaidService.zkdaijiaozujin(example);
        PageInfo<topaid> list = new PageInfo<>(zkdaijiaozujin);
        model.addAttribute("pageInfo",list);
        model.addAttribute("mainPage", "mytopaid.jsp");
        return "zuke/main";
    }
    @RequestMapping("gotopay")
    public  String gotopay(Integer id,HttpServletRequest request,Model model){
        user user = (user) request.getSession().getAttribute("user");
        userlistExample example1 =new userlistExample();
        userlistExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUserIdEqualTo(user.getId());
        List<userlist> userlists = userlistService.GetAll(example1);
        topaid topaid = topaidService.selectByPrimaryKey(id);
paid paid=new paid();
paid.setHouseId(topaid.getHouseId());
paid.setAddress(topaid.getAddress());
paid.setName(topaid.getName());
paid.setPrice(topaid.getPrice());
paid.setDate(new Date());
paid.setPaydate(new Date());
paid.setStatus("租金已缴");
paid.setUserlistId(userlists.get(0).getId());
        int i1 = topaidService.insertSelective(paid);
        if (i1>0){
            int i = topaidService.deleteByPrimaryKey(id);
            if (i>0){
                model.addAttribute("price",topaid.getPrice());
                model.addAttribute("id",topaid.getHouseId());
                model.addAttribute("name",topaid.getAddress());
                return "index";
            }

        }else {
            return "redirect:mytopaidlist";
        }
        return "redirect:mytopaidlist";

    }


}
