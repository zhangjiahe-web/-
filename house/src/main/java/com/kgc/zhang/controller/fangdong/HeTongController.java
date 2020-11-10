package com.kgc.zhang.controller.fangdong;

import com.kgc.zhang.entity.*;
import com.kgc.zhang.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.zip.ZipEntry;

/**
 * @author shkstart
 * @create 2020-10-20 9:49
 */
@Controller
public class HeTongController {

    @Resource
    HeTongService heTongService;

    @Resource
    applyService applyServicea;

    @Resource
    applyoutService applyOutService;

    @Resource
    houselistService houselistServicea;

    @Resource
    topaidService topaidService;

    @Resource
    userlistService userlistServicea;

    //刘学文
    @RequestMapping("dohetong")
    public String dohetong(hetong hetonga, Integer userid, Model model) {

        heTongService.insert(hetonga, userid);
        applyServicea.deleteByHouserID(hetonga.getHouseId());
        userlist userlista = userlistServicea.selectById(userid);
        topaid topaida = new topaid();
        topaida.setHouseId(hetonga.getHouseId());
        topaida.setAddress(hetonga.getAddress());
        topaida.setPrice(hetonga.getPrice());
        topaida.setDate(new Date());
        topaida.setName(userlista.getName());
        topaida.setUserlistId(userid);
        topaida.setStatus("租金未缴");
        topaidService.insert(topaida);
        houselist houselist = houselistServicea.selectByHouseId(hetonga.getHouseId());
        houselist houselista = new houselist();
        houselista.setId(houselist.getId());
        houselista.setStatus("已租赁");
        houselistServicea.updateByPrimaryKeySelective(houselista);
        model.addAttribute("mainPage", "../admin/hetong.jsp");
        return "admin/main1";
    }

    @RequestMapping("toupdatehetong")
    public String toupdatehetong(Model model, String house_id) {
        hetong hetong = heTongService.selectByhouseId(house_id);
        model.addAttribute("hetong", hetong);
        model.addAttribute("mainPage", "../admin/updatehetong.jsp");
        return "admin/main1";
    }

    @RequestMapping("changehetong")
    public String changehetong(hetong hetong, HttpSession session) {
        heTongService.update(hetong);
        String tongyihouse_id = (String) session.getAttribute("tongyihouse_id");
        Integer tongyiuserid = (Integer) session.getAttribute("tongyiuserid");
        return "redirect:tongyi?house_id=" + tongyihouse_id + "&userid=" + tongyiuserid;
    }

}
