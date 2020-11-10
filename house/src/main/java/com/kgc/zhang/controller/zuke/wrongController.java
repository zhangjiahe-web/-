package com.kgc.zhang.controller.zuke;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.*;
import com.kgc.zhang.service.paidService;
import com.kgc.zhang.service.topaidService;
import com.kgc.zhang.service.userlistService;
import com.kgc.zhang.service.wrongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class wrongController {
    @Resource
    topaidService topaidService;
    @Resource
    userlistService userlistService;
    @Resource
    paidService paidService;
    @Resource
    wrongService wrongService;
    @RequestMapping("toaddwrong")
    public  String toaddwrong(Model model, HttpServletRequest request, String pageNumStr, Date fromdate, Date todate){
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
        System.out.println(sum);
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
        model.addAttribute("mainPage", "toaddwrong.jsp");
        return "zuke/main";
    }
    @RequestMapping("paidcha")
    public  String paidcha(Integer id, Model model, HttpSession session){
        paid paid = paidService.selectByPrimaryKey(id);
        session.setAttribute("paidid",id);
        model.addAttribute("paid",paid);
        model.addAttribute("mainPage", "addwrong.jsp");
        return "zuke/main";
    }
    @RequestMapping("insertwrong")
    public  String insertwrong(HttpServletRequest request,String houseId,String address,String detail,Model model){
        user user = (user) request.getSession().getAttribute("user");
        Integer paidid = (Integer) request.getSession().getAttribute("paidid");
        userlistExample example1 =new userlistExample();
        userlistExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUserIdEqualTo(user.getId());
        List<userlist> userlists = userlistService.GetAll(example1);

        wrong wrong=new wrong();
        wrong.setDate(new Date());
        wrong.setUserlistId(userlists.get(0).getId());
        wrong.setStatus("待处理");
        wrong.setAddress(address);
        wrong.setHouseId(houseId);
        wrong.setDetail(detail);
        wrong.setName(userlists.get(0).getName());
        int i = wrongService.insertSelective(wrong);
        if (i>0){
            return "redirect:toaddwrong";
        }else {
            return "redirect:toaddwrong";
        }


    }
    @RequestMapping("mywronglist")
    public  String mywronglist(Model model,HttpServletRequest request,String pageNumStr){
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
        PageHelper.orderBy("id desc");
        wrongExample example=new wrongExample();
        wrongExample.Criteria criteria = example.createCriteria();
        criteria.andUserlistIdEqualTo(userlists.get(0).getId());
        List<wrong> wrongs = wrongService.selectByExample(example);
        PageInfo<wrong> list = new PageInfo<>(wrongs);
        model.addAttribute("pageInfo",list);
        model.addAttribute("mainPage", "mywrong.jsp");
        return "zuke/main";


    }
}
