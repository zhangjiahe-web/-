package com.kgc.zhang.controller.fangdong;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.*;
import com.kgc.zhang.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FangapplyController {
    @Resource
    applyService applyService;
    @Resource
    houselistService houselistService;
    @Resource
    userlistService userlistService;
    @Resource
    applyoutService applyOutService;
    @Resource
    zulistService zulistService;
    @Resource
    HeTongService heTongService;
    @Resource
    CheckoutService checkoutService;
    @Resource
    paidService paidService;

    /*看房申请*/
    @RequestMapping("findapplylist")
    public String findapplylist(Model model, HttpServletRequest request, String pageNumStr) {
        user user = (user) request.getSession().getAttribute("user");
        Integer pageNum = 1;//第几页
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        Integer pageSize = 5;//每页的数量
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("apply_id desc");
        List<apply> findapplylist = applyService.findapplylist(user.getUsername());
        PageInfo<apply> list = new PageInfo<>(findapplylist);

        model.addAttribute("applylist", list);

        model.addAttribute("mainPage", "../admin/applylist.jsp");
        return "admin/main1";
    }

    /*房东拒绝申请*/
    @RequestMapping("updateapply")
    public String updateapply(Integer applyid, String houseid) {
        apply apply = new apply();
        apply.setApplyId(applyid);
        apply.setHouseId(houseid);
        apply.setStatus("已拒绝");
        int i = applyService.updateByPrimaryKeySelective(apply);
        if (i > 0) {
            houselistExample example = new houselistExample();
            houselistExample.Criteria criteria = example.createCriteria();
            criteria.andHouseidEqualTo(houseid);

            List<houselist> all = houselistService.getAll(example);
            houselist houselist = new houselist();
            houselist.setId(all.get(0).getId());
            houselist.setStatus("未租赁");
            houselistService.updateByPrimaryKeySelective(houselist);
            return "redirect:findapplylist";
        } else {
            return "redirect:findapplylist";
        }
    }

    //刘学文
    /*房东同意申请*/
    @RequestMapping("tongyi")
    public String tongapply(String house_id, Integer userid, Model model, HttpSession session, HttpServletRequest request) {
        session.setAttribute("tongyihouse_id",house_id);
        session.setAttribute("tongyiuserid",userid);
        houselist houselista = houselistService.selectByHouseId(house_id);
        System.out.println(userid);
        userlist userlista = userlistService.selectById(userid);
        user user = (user) session.getAttribute("user");
        userlist userlist = userlistService.selectByUserId(user.getId());
        model.addAttribute("userlist",userlist);
        System.out.println(userlista.getId());
        model.addAttribute("zuidcard", userlista.getIdcard());
        model.addAttribute("zuke", userlista.getName());
        model.addAttribute("house_id", house_id);
        model.addAttribute("houseaddress", houselista.getAddress());
        model.addAttribute("userid", userid);
        model.addAttribute("mainPage", "../admin/addhetong.jsp");
        return "admin/main1";
    }

    //退组申请
    @RequestMapping("goapplyout")
    public String toapplyout(Model model, String pageNumStr, HttpServletRequest request) {
        Integer pageNum = 1;//第几页
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        user usera = (user) request.getSession().getAttribute("user");
        String landlady = usera.getUsername();
        Integer pageSize = 5;//每页的数量
        PageInfo<applyout> applyoutPageInfo = applyOutService.select(pageNum, pageSize, landlady);
        model.addAttribute("applyouts", applyoutPageInfo);
        model.addAttribute("mainPage", "../admin/applyout.jsp");
        return "admin/main1";
    }

    //删除退组申请
    @RequestMapping("deleteapplyout")
    public String deleteapplyout(Integer id) {
        applyOutService.deleteById(id);
        return "redirect:/goapplyout";
    }

    //同意
    @RequestMapping("agreeapplyout")
    public String agreeapplyout(Integer id) {
        applyOutService.updateTongYi(id);
        applyout applyout = applyOutService.selectById(id);
        //房子改为未租赁
        houselist houselist = new houselist();
        com.kgc.zhang.entity.houselist houselist1 = houselistService.selectByHouseId(applyout.getHouseId());
        houselist.setId(houselist1.getId());
        houselist.setHouseid(applyout.getHouseId());
        houselist.setStatus("未租赁");
        houselistService.updateByHouseList(houselist);
        //添加到已退租列表
        checkout checkout=new checkout();
        checkout.setUserlistId(applyout.getUserlistId());
        checkout.setStatus("已退租");
        checkout.setAddress(applyout.getAddress());
        checkout.setHouseId(applyout.getHouseId());
        checkoutService.insert(checkout);
        //删除再租列表
        zulistService.delzuList(applyout.getHouseId());
        //删除合同
        heTongService.delhetongByhouseId(applyout.getHouseId());
        //删除paid
        paidExample example=new paidExample();
        paidExample.Criteria criteria = example.createCriteria();
        criteria.andHouseIdEqualTo(applyout.getHouseId());

  paidService.deleteByExample(example);

        return "redirect:/goapplyout";
    }

    //拒绝
    @RequestMapping("refuseapplyout")
    public String refuseapplyout(Integer id) {
        applyOutService.updateJuJue(id);
        return "redirect:/goapplyout";
    }

}
