package com.kgc.zhang.service;

import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.*;

import java.util.List;

public interface zulistService {
    List<zulist> zulin(zulistExample example);

    int deleteByPrimaryKey(zulistKey key);

    zulist selectByPrimaryKey(zulistKey key);

    hetong chahetong(Integer id);
    List<zulist> shouzu(String landlady);
    zulist shouzuaddcha(Integer zid);
    //刘学文
    PageInfo<zulist> select(Integer pageNum, Integer pageSize, String landlady);

    void delzuList(String house_id);
}
