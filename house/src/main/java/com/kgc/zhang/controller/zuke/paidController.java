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
public class paidController {
    @Resource
    topaidService topaidService;
    @Resource
    userlistService userlistService;
    @Resource
    paidService paidService;
    @RequestMapping("findmypaid")
    public  String findmypaid(Model model, HttpServletRequest request, String pageNumStr, Date fromdate, Date todate){
        user user = (user) request.getSession().getAttribute("user");
        userlistExample example1 =new userlistExample();
        userlistExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUserIdEqualTo(user.getId());
        List<userlist> userlists = userlistService.GetAll(example1);


        paidExample example=new paidExample();
        paidExample.Criteria criteria = example.createCriteria();
        criteria.andUserlistIdEqualTo(userlists.get(0).getId());
        if (fromdate!=null&&todate==null){
            criteria.andDateEqualTo(fromdate);
        }
        if (todate!=null&&fromdate==null){
            criteria.andPaydateEqualTo(todate);
        }
        Double sum = paidService.selectSum(example);

        Integer pageNum=1;//第几页
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        Integer pageSize=5;//每页的数量

//排序
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id desc");
        List<paid> paids = paidService.selectByExample(example);
        PageInfo<paid> list = new PageInfo<>(paids);
        model.addAttribute("pageInfo",list);
        model.addAttribute("sum",sum);
model.addAttribute("fromdate",fromdate);
model.addAttribute("todate",todate);
        model.addAttribute("mainPage", "mypaid.jsp");
        return "zuke/main";
    }
    /*删除缴纳租金信息*/
    @RequestMapping("zukedeletepaid")
    public  String zukedeletepaid(Integer id){
        int i = paidService.deleteByPrimaryKey(id);
        if (i>0){
            return "redirect:findmypaid";
        }else {
            return "redirect:findmypaid";
        }

    }
}
