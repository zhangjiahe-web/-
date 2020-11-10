package com.kgc.zhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.checkout;
import com.kgc.zhang.entity.userlist;
import com.kgc.zhang.entity.userlistExample;
import com.kgc.zhang.entity.zulist;
import com.kgc.zhang.mapper.checkoutMapper;
import com.kgc.zhang.mapper.userlistMapper;
import com.kgc.zhang.service.CheckoutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-16 16:54
 */
@Service("checkoutService")
public class CheckoutServiceImpl implements CheckoutService {
    @Resource
    checkoutMapper checkoutMappera;

    @Resource
    userlistMapper userlistMapper1;

    @Override
    public void insertCheckout(String house_id, Integer userlist_id, String address) {
        checkout checkouta = new checkout();
        checkouta.setAddress(address);
        checkouta.setHouseId(house_id);
        checkouta.setStatus("已退租");
        checkouta.setUserlistId(userlist_id);
        checkoutMappera.insertSelective(checkouta);
    }

    @Override
    public PageInfo<checkout> select(Integer pageNum, Integer pageSize,String landlady) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("cid asc");
        List<checkout> checkouts = checkoutMappera.select(landlady);
        PageInfo<checkout> checkoutPageInfo = new PageInfo<>(checkouts);
        return checkoutPageInfo;
    }

    @Override
    public void deleteById(Integer id) {
        checkoutMappera.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(checkout checkout) {
        checkoutMappera.insertSelective(checkout);
    }
}
