package com.kgc.zhang.controller.fangdong;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.schedule;
import com.kgc.zhang.entity.scheduleExample;
import com.kgc.zhang.entity.user;
import com.kgc.zhang.service.scheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RiChengController {
@Resource
    scheduleService scheduleService;
    @RequestMapping("selectAll")
    public  String  selectAll(Model model, HttpServletRequest request,String pageNumStr){
        user user = (user) request.getSession().getAttribute("user");
        scheduleExample scheduleExample=new scheduleExample();
        com.kgc.zhang.entity.scheduleExample.Criteria criteria = scheduleExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        Integer pageNum=1;//第几页
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        Integer pageSize=5;//每页的数量

//排序
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id desc");
        List<schedule> schedules = scheduleService.selectByExample(scheduleExample);
        PageInfo<schedule> list = new PageInfo<>(schedules);
        model.addAttribute("pageInfo",list);
        model.addAttribute("mainPage", "schedule.jsp");
        return "admin/main1";
    }

    @RequestMapping("/toinsert")
    public String toinsert(Model model){
        model.addAttribute("mainPage", "addschedule.jsp");

        return "admin/main1";

    }
    @RequestMapping("insertschedule")
    public  String insertschedule(schedule schedule,HttpServletRequest request){
        user user = (user) request.getSession().getAttribute("user");
        schedule.setUsername(user.getUsername());
        int i = scheduleService.insertSelective(schedule);
        if (i>0){
            return "redirect:selectAll";
        }else {
            return "redirect:selectAll";
        }

    }
    @RequestMapping("toupdate")
    public  String toupdate(Integer id,Model model){
        schedule schedule = scheduleService.selectByPrimaryKey(id);
        model.addAttribute("schedule", schedule);
        model.addAttribute("mainPage", "updateschedule.jsp");
        return "admin/main1";
    }
    @RequestMapping("updateschedule")
    public  String updateschedule(schedule schedule){
        int i = scheduleService.updateByPrimaryKeySelective(schedule);
        if (i>0){
            return "redirect:selectAll";
        }else {
            return "redirect:selectAll";
        }

    }
    @RequestMapping("deleteschedule")
    public  String  deleteschedule(Integer id){
        int i = scheduleService.deleteByPrimaryKey(id);
        if (i>0){
            return "redirect:selectAll";
        }else {
            return "redirect:selectAll";
        }

    }
}
