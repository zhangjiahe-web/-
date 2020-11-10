package com.kgc.zhang.service;

import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.checkout;

/**
 * @author shkstart
 * @create 2020-10-16 16:54
 */
public interface CheckoutService {
    void insertCheckout(String house_id, Integer userlist_id, String address);

    PageInfo<checkout> select(Integer pageNum, Integer pageSize, String landlady);

    void deleteById(Integer id);

    void insert(checkout checkout);
}
