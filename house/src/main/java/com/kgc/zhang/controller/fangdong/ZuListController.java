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
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-16 11:36
 */
@Controller
public class ZuListController {
    @Resource
    zulistService zuListService;

    @Resource
    HeTongService heTongService;

    @Resource
    CheckoutService checkoutService;
    @Resource
    topaidService topaidService;
@Resource
    paidService paidService;
@Resource
    houselistService houselistService;


    //刘学文
    @RequestMapping("toZuList")
    public String toZuList(String pageNumStr, Model model, HttpServletRequest request) {
        Integer pageNum = 1;//第几页
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        user user = (user)request.getSession().getAttribute("user");
        String landlady=user.getUsername();
        Integer pageSize = 5;//每页的数量
        PageInfo<zulist> zulistPageInfo = zuListService.select(pageNum, pageSize,landlady);
        model.addAttribute("zulistPageInfo", zulistPageInfo);
        model.addAttribute("mainPage", "../admin/zulist.jsp");
        return "admin/main1";
    }

    //查看合同
    @RequestMapping("/tohetong")
    public String tohetong(Model model, String house_id) {
        hetong hetonga = heTongService.selectByhouseId(house_id);
        model.addAttribute("hetong", hetonga);
        model.addAttribute("mainPage", "../admin/hetong.jsp");
        return "admin/main1";
    }

    //终止合同
    @RequestMapping("/delhetong")
    public String delhetong(Model model, String house_id, Integer userlist_id, String address) {
        houselist houselist = new houselist();
        com.kgc.zhang.entity.houselist houselist1 = houselistService.selectByHouseId(house_id);
        houselist.setId(houselist1.getId());
        houselist.setHouseid(house_id);
        houselist.setStatus("未租赁");
        houselistService.updateByHouseList(houselist);
        checkoutService.insertCheckout(house_id, userlist_id, address);
        zuListService.delzuList(house_id);
        heTongService.delhetongByhouseId(house_id);
        paidExample example=new paidExample();
        paidExample.Criteria criteria = example.createCriteria();
        criteria.andHouseIdEqualTo(house_id);

        paidService.deleteByExample(example);

        //`cid``house_id``address``status``userlist_id`
        return "redirect:/toZuList";
    }
    //我要收租
    @RequestMapping("showaddpaid")
    public  String showaddpaid(Model model,HttpServletRequest request,String pageNumStr){
        user user = (user) request.getSession().getAttribute("user");
        Integer pageNum=1;//第几页
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        Integer pageSize=5;//每页的数量

//排序
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id desc");
        List<zulist> shouzu = zuListService.shouzu(user.getUsername());
        PageInfo<zulist> list = new PageInfo<>(shouzu);
        model.addAttribute("pageInfo",list);
        model.addAttribute("mainPage", "showaddpaid.jsp");
        return "admin/main1";
    }
    @RequestMapping("addpaid")
    public  String  addpaid(Integer id,Model model){
        zulist shouzuaddcha = zuListService.shouzuaddcha(id);
        model.addAttribute("zulist", shouzuaddcha);
        model.addAttribute("mainPage", "addpaid.jsp");
        return "admin/main1";

    }
    @RequestMapping("inserttopaid")
    public  String inserttopaid(topaid topaid){
        topaid.setStatus("租金未缴");
        topaidService.insert(topaid);
        return "redirect:/toshowaddpaid";
    }
}
