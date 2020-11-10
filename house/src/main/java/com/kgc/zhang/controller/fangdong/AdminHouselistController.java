package com.kgc.zhang.controller.fangdong;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.houselist;
import com.kgc.zhang.entity.houselistExample;
import com.kgc.zhang.entity.user;
import com.kgc.zhang.service.houselistService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminHouselistController {
  @Resource
    houselistService houselistService;
   @RequestMapping("/ahouselist")
    public  String houselist(Model model, HttpServletRequest request,String pageNumStr){
       user user = (user) request.getSession().getAttribute("user");
       houselistExample example=new houselistExample();
       houselistExample.Criteria criteria = example.createCriteria();
       criteria.andLandladyEqualTo(user.getUsername());
       Integer pageNum=1;//第几页
       if(pageNumStr!=null){
           pageNum=Integer.parseInt(pageNumStr);
       }
       Integer pageSize=5;//每页的数量
       PageHelper.startPage(pageNum,pageSize);
       PageHelper.orderBy("id desc");
       List<houselist> houselists = houselistService.getAll(example);

       PageInfo<houselist> list = new PageInfo<>(houselists);
       model.addAttribute("houselist",list);
       model.addAttribute("mainPage","../admin/ahouselist.jsp");
       return "/admin/main1";
    }
	//刘学文
	//修改房源信息
    @RequestMapping("/tochangehouse")
    public String upd(Model model, int id) {
        houselist houselista = houselistService.select(id);
        model.addAttribute("houselista", houselista);
        model.addAttribute("mainPage", "../admin/changehouse.jsp");
        return "admin/main1";
    }
    //修改房源信息
    @RequestMapping("/dochangehouse")
    public String updhouse(Model model, houselist houselista, MultipartFile file, HttpSession session, HttpServletRequest request) {
        if (file != null || file.isEmpty() == false) {
            String realPath = session.getServletContext().getRealPath("/static/imgs/images");
            String originalFilename = file.getOriginalFilename();
            String extension = FilenameUtils.getExtension(originalFilename);
            String s = System.currentTimeMillis() + "_" + RandomUtils.nextInt(10000) + "_." + extension;

            File files = new File(realPath, s);
            try {
                file.transferTo(files);
                user user = (user) request.getSession().getAttribute("user");

                houselista.setLandlady(user.getUsername());
                houselista.setImg("/imgs/images/" + s);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        houselistService.update(houselista);
        return "redirect:/ahouselist";
    }
    //删除房源信息deletehouse.action?id=50
    @RequestMapping("delhouse")
    public String delhouse(int id){
        houselistService.delete(id);
        return "redirect:/ahouselist";
    }
}
