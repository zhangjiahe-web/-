package com.kgc.zhang.controller.fangdong;


import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.solve;
import com.kgc.zhang.entity.user;
import com.kgc.zhang.entity.wrong;
import com.kgc.zhang.service.solveService;
import com.kgc.zhang.service.wrongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author shkstart
 * @create 2020-10-21 16:17
 */
@Controller
public class WrongsController {

    @Resource
    wrongService wrongServicea;

    @Resource
    solveService solveServicea;


    @RequestMapping("towronglist")
    public String towronglist(Model model, String pageNumStr, HttpServletRequest request) {
        Integer pageNum = 1;//第几页
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        Integer pageSize = 5;//每页的数量
        user usera = (user) request.getSession().getAttribute("user");
        String landlady = usera.getUsername();
        PageInfo<wrong> wrongPageInfo = wrongServicea.select(pageNum, pageSize, landlady);
        model.addAttribute("wrongs", wrongPageInfo);
        model.addAttribute("mainPage", "../admin/wrong.jsp");
        return "admin/main1";
    }

    @RequestMapping("gotosolve")
    public String gotosolve(Model model,String zuname,String ida, Integer id,String pageNumStr,HttpServletRequest request) {
        //根据id得到是哪个房屋报障
        wrong wronga = wrongServicea.selectById(id);
        solve solvea = new solve();
        solvea.setName(wronga.getName());
        solvea.setUserlistId(wronga.getUserlistId());
        solvea.setHouseId(wronga.getHouseId());
        solvea.setDetail(wronga.getDetail());
        solvea.setAddress(wronga.getAddress());
        solvea.setDate(new Date());
        solvea.setStatus("已处理");
        solveServicea.insert(solvea);
        wrongServicea.deleteById(id);
        Integer pageNum = 1;//第几页
        Integer pageSize = 5;//每页的数量
        user usera = (user) request.getSession().getAttribute("user");
        String landlady = usera.getUsername();
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        if (zuname==""||zuname==null){
            zuname="";
        }
        if (ida==""||ida==null){
            ida="";
        }
        PageInfo<solve> solvePageInfo = solveServicea.select(pageNum, pageSize,landlady,"%"+zuname+"%","%"+ida+"%");
        model.addAttribute("solves", solvePageInfo);
        model.addAttribute("mainPage", "../admin/solve.jsp");
        return "admin/main1";
    }
}
