package com.kgc.zhang.controller.zuke;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.app;
import com.kgc.zhang.entity.*;
import com.kgc.zhang.service.applyService;
import com.kgc.zhang.service.houselistService;
import com.kgc.zhang.service.userlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class applyController {
    @Resource
    applyService applyService;
    @Resource
    houselistService houselistService;
    @Resource
    userlistService userlistService;
    @RequestMapping("getmyapply")
    public  String getmyapply(Model model,HttpServletRequest request,String pageNumStr){
        user user = (user) request.getSession().getAttribute("user");
        userlistExample  example1 =new userlistExample();
        userlistExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUserIdEqualTo(user.getId());

        List<userlist> userlists = userlistService.GetAll(example1);
        applyExample example=new applyExample();
        applyExample.Criteria criteria = example.createCriteria();
        criteria.andUserlistIdEqualTo(userlists.get(0).getId());
        criteria.andStatusEqualTo("申请中");
        Integer pageNum=1;//第几页
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        Integer pageSize=5;//每页的数量
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("apply_id desc");
        List<apply> all = applyService.selectapplyanduserlist(example);
        PageInfo<apply> list = new PageInfo<>(all);

        model.addAttribute("userlist",list);

        model.addAttribute("mainPage", "../zuke/myapply.jsp");
        return "zuke/main";
    }
    /*点击申请看房*/
    @RequestMapping("applycheckuserlist")
    public  String applycheckuserlist(Model model,Integer id ,HttpServletRequest request){
              user user = (user) request.getSession().getAttribute("user");
        userlistExample  example1 =new userlistExample();
        userlistExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUserIdEqualTo(user.getId());

        List<userlist> userlists = userlistService.GetAll(example1);
        houselist house=new houselist();
        house.setId(id);
        house.setStatus("已被申请");
        int i = houselistService.houlistKAN(house);
        if (i>0){
            houselist houselist1 = houselistService.houListCHA(house);

            if (house.getStatus()=="已被申请"){
                apply apply=new apply();
                apply.setHouseId(houselist1.getHouseid());
                apply.setAddress(houselist1.getAddress());
                apply.setArea(houselist1.getArea());
                apply.setPrice(houselist1.getPrice());
                apply.setStatus("申请中");
                apply.setUserlistId(userlists.get(0).getId());
                int addapply = applyService.addapply(apply);
                if (addapply>0){
                    model.addAttribute("houseDetail",houselist1);
                    model.addAttribute("error","applysuccess");
                    model.addAttribute("mainPage","../zuke/details.jsp");
                    return "zuke/main";
                }else {
                    return "";
                }
            }else {
                return "";
            }




    }else {
            houselist houselist2 = houselistService.houListCHA(house);
            model.addAttribute("houseDetail",houselist2);
            model.addAttribute("error","msg");
            model.addAttribute("mainPage","../zuke/details.jsp");
            return "zuke/main";
        }
    }
    /*租客查看租房申请被拒绝*/
    @RequestMapping("zukejujueapply")
    public  String zukejujueapply(Model model,HttpServletRequest request,String pageNumStr){
        user user = (user) request.getSession().getAttribute("user");
        userlistExample  example1 =new userlistExample();
        userlistExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUserIdEqualTo(user.getId());

        List<userlist> userlists = userlistService.GetAll(example1);
        applyExample example=new applyExample();
        applyExample.Criteria criteria = example.createCriteria();
        criteria.andUserlistIdEqualTo(userlists.get(0).getId());
        criteria.andStatusEqualTo("已拒绝");
        Integer pageNum=1;//第几页
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        Integer pageSize=5;//每页的数量
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("apply_id desc");
        List<apply> all = applyService.selectapplyanduserlist(example);
        PageInfo<apply> list = new PageInfo<>(all);

        model.addAttribute("userlist",list);

        model.addAttribute("mainPage", "../zuke/myapplyout.jsp");
        return "zuke/main";
    }
    /*租客删除拒绝申请信息*/
    @RequestMapping("deleteapply")
    public  String deleteapply(Integer applyid,String houseid){
        apply apply=new apply();
        apply.setApplyId(applyid);
        apply.setHouseId(houseid);
        int i = applyService.deleteByPrimaryKey(apply);
        if (i>0){
            return "redirect:zukejujueapply";
        }else {
            return "redirect:zukejujueapply";
        }

    }
}
