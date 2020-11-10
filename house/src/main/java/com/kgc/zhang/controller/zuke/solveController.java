package com.kgc.zhang.controller.zuke;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.*;
import com.kgc.zhang.service.solveService;
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
public class solveController {

    @Resource
    solveService solveService;
    @Resource
    userlistService userlistService;

    @RequestMapping("findmysolve")
    public  String findmysolve(Model model, HttpServletRequest request, String pageNumStr, String  detail, Date date){
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

  solveExample solveExample=new solveExample();
        com.kgc.zhang.entity.solveExample.Criteria criteria = solveExample.createCriteria();
criteria.andUserlistIdEqualTo(userlists.get(0).getId());
if (detail!=null&&detail.isEmpty()==false){
    criteria.anddetailLike("%"+detail+"%");
}
        if (date!=null){
            criteria.andDateEqualTo(date);
        }
        List<solve> solves = solveService.selectByExample(solveExample);
        PageInfo<solve> list = new PageInfo<>(solves);
        model.addAttribute("pageInfo",list);
        model.addAttribute("count",solves.size());
        model.addAttribute("detail",detail);
        model.addAttribute("date",date);
        model.addAttribute("mainPage", "mysolve.jsp");
        return "zuke/main";
    }
    @RequestMapping("deletesolve")
    public  String deletesolve(Integer id){
        int i = solveService.deleteByPrimaryKey(id);
        if (i>0){
            return "redirect:findmysolve";
        }else {
            return "redirect:findmysolve";
        }

    }
}
