package com.kgc.zhang.controller.fangdong;

import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.solve;
import com.kgc.zhang.entity.user;
import com.kgc.zhang.service.solveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author shkstart
 * @create 2020-10-28 15:17
 */
@Controller
public class SolveController2 {

    @Resource
    solveService solveServicea;

    @RequestMapping("toSolve")//zuname,id
    public String toSolve(Model model, String pageNumStr, String zuname, String id, HttpServletRequest request) {
        user usera = (user) request.getSession().getAttribute("user");
        String landlady = usera.getUsername();
        Integer pageNum = 1;//第几页
        System.out.println(pageNumStr);
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        Integer pageSize = 5;//每页的数量
        if (zuname==""||zuname==null){
            zuname="";
        }
        if (id==""||id==null){
            id="";
        }
        PageInfo<solve> solvePageInfo = solveServicea.select(pageNum, pageSize, landlady, "%" + zuname + "%", "%" + id + "%");
        model.addAttribute("solves", solvePageInfo);
        model.addAttribute("mainPage", "../admin/solve.jsp");
        return "admin/main1";
    }

    @RequestMapping("/dolsolve/{id}")
    public String delsolve(@PathVariable("id") Integer id, Model model) {
        solveServicea.deleteById(id);
        return "redirect:/toSolve";
    }
    //house/paid/showaddpaid.action


}
