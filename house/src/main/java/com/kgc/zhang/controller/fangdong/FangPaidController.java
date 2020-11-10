package com.kgc.zhang.controller.fangdong;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.paid;
import com.kgc.zhang.entity.paidExample;
import com.kgc.zhang.entity.user;
import com.kgc.zhang.service.paidService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FangPaidController {
    @Resource
    paidService paidServices;
    @RequestMapping("selectall")
    public  String selectall(Model model, HttpServletRequest request,String pageNumStr,String houseid,String address,String name){
        user user = (user) request.getSession().getAttribute("user");
        paidExample example=new paidExample();
        paidExample.Criteria criteria = example.createCriteria();
        Integer pageNum=1;//第几页
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        Integer pageSize=5;//每页的数量

//排序
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id desc");
        if (name!=null&&name.isEmpty()==false){
            criteria.andNameLike("%"+name+"%");
        }
        if (houseid!=null&&houseid.isEmpty()==false){
            criteria.andHouseIdLike("%"+houseid+"%");
        }
        if (address!=null&&address.isEmpty()==false){
            criteria.andAddressLike("%"+address+"%");
        }
        criteria.andUsername(user.getUsername());
        List<paid> fdokzhifu = paidServices.fdokzhifu(example);
        PageInfo<paid> list = new PageInfo<>(fdokzhifu);
        Double sum = paidServices.selectSum(example);
        model.addAttribute("pageInfo",list);
        model.addAttribute("sum",sum);
        model.addAttribute("mainPage", "paid.jsp");
        return "admin/main1";
    }
    @RequestMapping("deletepaid")
    public  String deletepaid(Integer id){
        int i = paidServices.deleteByPrimaryKey(id);
        if (i>0){
            return "redirect:selectall";
        }else {
            return "redirect:selectall";
        }

    }
}
