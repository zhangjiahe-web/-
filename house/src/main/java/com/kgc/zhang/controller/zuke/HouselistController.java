package com.kgc.zhang.controller.zuke;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.houselist;
import com.kgc.zhang.entity.houselistExample;
import com.kgc.zhang.entity.user;
import com.kgc.zhang.service.houselistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HouselistController {
  @Resource
    houselistService houselistService;
   @RequestMapping("/houselist")
    public  String houselist(Model model,String pageNumStr,String address,String status,String area,String price){
       houselistExample example=new houselistExample();
       houselistExample.Criteria criteria = example.createCriteria();

       if (address!=null&&address.isEmpty()==false){
           criteria.andAddressLike("%"+address+"%");
       }

       if (status!=null&&status.isEmpty()==false){
           criteria.andStatusEqualTo(status);

       }
       System.out.println(area);




       if (area!=null&&area.isEmpty()==false){
           String[] areas = area.split(",");
           String area1 = areas[0];
           String area2 = areas[1];
           Double aDouble1 = Double.valueOf(area1);
           Double aDouble2 = Double.valueOf(area2);
           criteria.andAreaBetween(aDouble1,aDouble2);

       }



       if (price!=null&&price.isEmpty()==false){
           String[] prices = price.split(",");
           String price1 = prices[0];
           String price2 = prices[1];
           Double Dsplit1 = Double.valueOf(price1);
           Double Dsplit2 = Double.valueOf(price2);
           criteria.andPriceBetween(Dsplit1,Dsplit2);

       }
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
       //数据回显
       model.addAttribute("address",address);
       model.addAttribute("status",status);
       model.addAttribute("area",area);
       model.addAttribute("price",price);


       model.addAttribute("mainPage","../zuke/houselist.jsp");
       return "zuke/main";
    }

/*房子信息查看*/
@RequestMapping("houseDetails")
    public  String houseDetails(Integer id,Model model){
      System.out.println(id);
houselist houselist=new houselist();
houselist.setId(id);
    com.kgc.zhang.entity.houselist houselist1 = houselistService.houListCHA(houselist);
    model.addAttribute("houseDetail",houselist1);

    model.addAttribute("mainPage","../zuke/details.jsp");
    return "zuke/main";
}













   /* @RequestMapping("/mohuhouselist")
    public  String mohuhouselist(Model model,String pageNumStr,String address,String status,String area,String price){

        if (address!=null&&address.isEmpty()==false){
            houselistExample example=new houselistExample();
            houselistExample.Criteria criteria = example.createCriteria();
            criteria.andAddressLike("%"+address+"%");
            Integer pageNum=1;//第几页
            if(pageNumStr!=null){
                pageNum=Integer.parseInt(pageNumStr);
            }
            Integer pageSize=5;//每页的数量
            PageHelper.startPage(pageNum,pageSize);
            PageHelper.orderBy("id asc");
            List<houselist> houselists = houselistService.getAll(example);

            PageInfo<houselist> list = new PageInfo<>(houselists);
            model.addAttribute("houselist",list);


            model.addAttribute("mainPage","../zuke/houselist.jsp");
            return "zuke/main";
        }
        if (status!=null&&status.isEmpty()==false){
            houselistExample example=new houselistExample();
            houselistExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo(status);
            Integer pageNum=1;//第几页
            if(pageNumStr!=null){
                pageNum=Integer.parseInt(pageNumStr);
            }
            Integer pageSize=5;//每页的数量
            PageHelper.startPage(pageNum,pageSize);
            PageHelper.orderBy("id asc");
            List<houselist> houselists = houselistService.getAll(example);

            PageInfo<houselist> list = new PageInfo<>(houselists);
            model.addAttribute("houselist",list);


            model.addAttribute("mainPage","../zuke/houselist.jsp");
            return "zuke/main";
        }
        System.out.println(area);
        if (area!=null&&area.isEmpty()==false){
            houselistExample example=new houselistExample();
            houselistExample.Criteria criteria = example.createCriteria();
            String[] areas = area.split(",");
            String area1 = areas[0];
            String area2 = areas[1];
            Double aDouble1 = Double.valueOf(area1);
            Double aDouble2 = Double.valueOf(area2);
            criteria.andAreaBetween(aDouble1,aDouble2);
            Integer pageNum=1;//第几页
            if(pageNumStr!=null){
                pageNum=Integer.parseInt(pageNumStr);
            }
            Integer pageSize=5;//每页的数量
            PageHelper.startPage(pageNum,pageSize);
            PageHelper.orderBy("id asc");
            List<houselist> houselists = houselistService.getAll(example);

            PageInfo<houselist> list = new PageInfo<>(houselists);
            model.addAttribute("houselist",list);


            model.addAttribute("mainPage","../zuke/houselist.jsp");
            return "zuke/main";
        }
        System.out.println(price);

        if (price!=null&&price.isEmpty()==false){
            houselistExample example=new houselistExample();
            houselistExample.Criteria criteria = example.createCriteria();
            String[] prices = price.split(",");
            String price1 = prices[0];
            String price2 = prices[1];
            Double Dsplit1 = Double.valueOf(price1);
            Double Dsplit2 = Double.valueOf(price2);
            criteria.andPriceBetween(Dsplit1,Dsplit2);
            Integer pageNum=1;//第几页
            if(pageNumStr!=null){
                pageNum=Integer.parseInt(pageNumStr);
            }
            Integer pageSize=5;//每页的数量
            PageHelper.startPage(pageNum,pageSize);
            PageHelper.orderBy("id asc");
            List<houselist> houselists = houselistService.getAll(example);

            PageInfo<houselist> list = new PageInfo<>(houselists);
            model.addAttribute("houselist",list);


            model.addAttribute("mainPage","../zuke/houselist.jsp");
            return "zuke/main";

        }

        model.addAttribute("mainPage","../zuke/houselist.jsp");
        return "zuke/main";
    }*/
}
