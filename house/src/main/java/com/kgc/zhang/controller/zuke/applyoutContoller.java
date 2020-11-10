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
import java.util.List;

@Controller
public class applyoutContoller {
    @Resource
    applyoutService applyoutService;
    @Resource
    userlistService userlistService;
    /*已退租列表*/
    @RequestMapping("getmycheckout")
    public  String getmycheckout(Model model, HttpServletRequest request, String pageNumStr){
        user user = (user) request.getSession().getAttribute("user");
        userlistExample example1 =new userlistExample();
        userlistExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUserIdEqualTo(user.getId());
        List<userlist> userlists = userlistService.GetAll(example1);
        applyoutExample applyoutExample=new applyoutExample();
        com.kgc.zhang.entity.applyoutExample.Criteria criteria = applyoutExample.createCriteria();
        criteria.andUserlistIdEqualTo(userlists.get(0).getId());
        Integer pageNum=1;//第几页
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        Integer pageSize=5;//每页的数量

//排序
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("aoid desc");
        List<applyout> tuizulist = applyoutService.tuizulist(applyoutExample);
        PageInfo<applyout> list = new PageInfo<>(tuizulist);


        model.addAttribute("pageInfo",list);
        model.addAttribute("mainPage", "mycheckout.jsp");
        return "zuke/main";

    }
//删除申请拒绝租赁信息
    @RequestMapping("applyoutdel")
    public  String applyoutdel(Integer aoid){
        int i = applyoutService.deleteByPrimaryKey(aoid);
        if (i>0){
            return "redirect:getmycheckout";
        }else {
            return "redirect:getmycheckout";
        }

    }
}
