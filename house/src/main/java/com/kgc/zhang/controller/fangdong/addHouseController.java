package com.kgc.zhang.controller.fangdong;

import com.kgc.zhang.entity.houselist;
import com.kgc.zhang.entity.user;
import com.kgc.zhang.service.addhouselistService;
import com.kgc.zhang.service.houselistService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class addHouseController {
    @Resource
    addhouselistService addhouselistService;
    @RequestMapping("addhouse")
    public  String addhouse (Model model, HttpServletRequest request, houselist houselist, MultipartFile file, HttpSession session){
        //文件上传
        if (file!=null||file.isEmpty()==false){
            String realPath = session.getServletContext().getRealPath("/static/imgs/images");
            String originalFilename = file.getOriginalFilename();
            String extension = FilenameUtils.getExtension(originalFilename);
            String s = System.currentTimeMillis() + "_" + RandomUtils.nextInt(10000) + "_." + extension;

            File files=new File(realPath,s);
            try {
                file.transferTo(files);
                user user = (user) request.getSession().getAttribute("user");

                houselist.setLandlady(user.getUsername());
                houselist.setImg("/imgs/images/"+s);
                houselist.setStatus("未租赁");
                int addhouse = addhouselistService.addhouse(houselist);
                if (addhouse>0){
                    model.addAttribute("error","添加房源成功");
                    model.addAttribute("mainPage","../admin/addhouse.jsp");
                    return "/admin/main1";
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("error","添加房源失败");
        model.addAttribute("mainPage","../admin/addhouse.jsp");
        return "/admin/main1";



    }
}
