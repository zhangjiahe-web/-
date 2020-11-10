package com.kgc.zhang.controller.fangdong;

import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.checkout;
import com.kgc.zhang.entity.user;
import com.kgc.zhang.entity.zulist;
import com.kgc.zhang.service.CheckoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author shkstart
 * @create 2020-10-16 18:00
 */
@Controller
public class CheckoutController {
    @Resource
    CheckoutService checkoutService;

	//刘学文
    @RequestMapping("toCheckout")
    public String toZuList(String pageNumStr, Model model, HttpServletRequest request) {
        Integer pageNum = 1;//第几页
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        Integer pageSize = 5;//每页的数量
        user user = (user)request.getSession().getAttribute("user");
        String landlady=user.getUsername();
        PageInfo<checkout> checkoutPageInfo = checkoutService.select(pageNum, pageSize,landlady);
        model.addAttribute("checkoutPageInfo", checkoutPageInfo);
        model.addAttribute("mainPage", "../admin/checkout.jsp");
        return "admin/main1";
    }

    @RequestMapping("/delcheckout")
    public String delcheckout(Model model, Integer id) {
        checkoutService.deleteById(id);
        return "redirect:/toCheckout";
    }
}
